package project.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import project.model.dao.HTenderDAO;
import project.model.dao.ITenderDAO;
import project.model.dto.smarttender.SmarttenderDTO;
import project.model.response.Initiator;
import project.model.response.Site;
import project.model.response.Tender;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
//TODO Separate methods to specialized classes.
public class TenderService {

    private final String BASE_URL = "https://smarttender.biz/CommercialTrades/GetTenders/";
    private final Duration DURATION_TIMEOUT = Duration.ofSeconds(3);
    private final WebClient webClient;
    private final ITenderDAO<Tender> dao = new HTenderDAO();
    private final String BODY_VALUE =
            "{\n" +
            "  \"searchParam\": {\n" +
            "    \"TradeSegment\": 1,\n" +
            "    \"TenderMode\": 1,\n" +
            "    \"Page\": %d,\n" +
            "    \"ClassificationGroupId\": null,\n" +
            "    \"Sorting\": 2,\n" +
            "    \"AssignedManagerIds\": [],\n" +
            "    \"OrganizerIds\": [],\n" +
            "    \"TenderStatuses\": [],\n" +
            "    \"GroupedBiddingTypeCodes\": [],\n" +
            "    \"BiddingTypeCodes\": [],\n" +
            "    \"AddressSearchTypes\": [\n" + "1\n" + "],\n" +
            "    \"RegionInfos\": [],\n" +
            "    \"CategoryIds\": [],\n" +
            "    \"AwardStatusCodes\": [],\n" +
            "    \"MainProcurementCategoryIds\": [],\n" +
            "    \"RationaleIds\": [],\n" +
            "    \"PaymentTermTypeIds\": [],\n" +
            "    \"MyFilterId\": null\n" +
            "  }\n" +
            "}";

    public TenderService() {
        webClient = WebClient.builder()
                .baseUrl(BASE_URL)
                .build();
    }

    public List<Tender> getTenderDAOList() {
        List<project.model.dto.smarttender.Tender> tenderList = new ArrayList<>();
        int page = 1;
        while (tenderList.addAll(getSmarttenderDTOByPage(page++).getTenders()));
        return tenderList.stream().map(TenderService::mapTenderDtoToDao).collect(Collectors.toList());
    }

    private static Tender mapTenderDtoToDao(project.model.dto.smarttender.Tender dto) {
        Site site = new Site.Builder()
                .withName("SmartTender")
                .withUrl("https://smarttender.bizzz")
                .build();

        Initiator initiator = new Initiator.Builder()
                .withName(dto.getOrganizer().getTitle())
                .build();

        Tender tender = new Tender.Builder()
                .withSiteInnerId(dto.getNumber())
                .withSite(site)
                .withInitiator(initiator)
                .withSubject(dto.getSubject())
                .withStartTimestamp(Timestamp.valueOf(dto.getTenderingPeriod().getDateStart().replace('T', ' ')))
                .withEndTimestamp(Timestamp.valueOf(dto.getTenderingPeriod().getDateEnd().replace('T', ' ')))
                .withUrl("https://smarttender.biz/komertsiyni-torgy/" + dto.getId() + "/")
                .build();

        return tender;
    }

    private SmarttenderDTO getSmarttenderDTOByPage(int page) {
        return webClient
                .post()
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(String.format(BODY_VALUE, page))
                .retrieve()
                .bodyToMono(SmarttenderDTO.class)
                .block(DURATION_TIMEOUT);
    }

    public String getTenderFromDBByID(String id) {
        Optional<Tender> tenderOpt = dao.getTenderByID(id);
        return tenderOpt.isPresent()
                ? tenderOpt.get().toString()
                : String.format("There is no tender with ID = %s in DB", id);
    }

    public void postTenderToDBByPositionInList(String id) {
        dao.save(getTenderDAOList().get(Integer.parseInt(id)));
    }

    public void deleteTenderFromDBByID(String id) {
        Tender tender = dao.getTenderByID(id).get();
        dao.remove(tender);
    }
}
