package project.service.web;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import project.model.dto.smarttender.SmarttenderDTO;
import project.model.dto.smarttender.Tender;
import project.model.response.Initiator;
import project.model.response.Site;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SmarttenderService implements IWebService {
    private final WebClient webClient;
    private final Duration DURATION_TIMEOUT = Duration.ofSeconds(3);
    private List<Tender> tenderList;
    private List<Tender> onlyNewTenderList;
    private final String SMARTTENDER_NAME = "SmartTender";
    private final String BASE_URL = "https://smarttender.biz";
    private final String PARSING_ENDPOINT = BASE_URL + "/CommercialTrades/GetTenders/";
    private final String TENDER_URL = BASE_URL + "/komertsiyni-torgy/%s/";
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

    public SmarttenderService() {
        tenderList = new ArrayList<>();
        onlyNewTenderList = new ArrayList<>();
        webClient = WebClient.builder()
                .baseUrl(PARSING_ENDPOINT)
                .build();
    }

    @Override
    public void updateTenderList() {
        List<Tender> tenders = new ArrayList<>();
        int page = 1;
        while (tenders.addAll(getSmarttenderDTOByPage(page++).getTenders()));
        tenders.removeAll(tenderList);
        onlyNewTenderList.clear();
        onlyNewTenderList.addAll(tenders);
        tenders.addAll(tenderList);
        tenderList.clear();
        tenderList.addAll(tenders);
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

    @Override
    public List<project.model.response.Tender> getTenderList() {
        updateTenderList();
        return mapToTender(tenderList);
    }

    @Override
    public List<project.model.response.Tender> getOnlyNewTenderList() {
        updateTenderList();
        return mapToTender(onlyNewTenderList);
    }

    private List<project.model.response.Tender> mapToTender(List<Tender> tenders) {
        List<project.model.response.Tender> tenderList = new ArrayList<>();
        for (Tender dto : tenders) {
            Site site = new Site.Builder()
                    .withName(SMARTTENDER_NAME)
                    .withUrl(BASE_URL)
                    .build();
            Initiator initiator = new Initiator.Builder()
                    .withName(dto.getOrganizer().getTitle())
                    .build();
            project.model.response.Tender tender = new project.model.response.Tender.Builder()
                    .withSiteInnerId(dto.getNumber())
                    .withSite(site)
                    .withInitiator(initiator)
                    .withSubject(dto.getSubject())
                    .withStartTimestamp(LocalDateTime.parse(dto.getTenderingPeriod().getDateStart()))
                    .withEndTimestamp(LocalDateTime.parse(dto.getTenderingPeriod().getDateEnd()))
                    .withUrl(String.format(TENDER_URL, dto.getId()))
                    .build();
            tenderList.add(tender);
        }
        return tenderList;
    }
}