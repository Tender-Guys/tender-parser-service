package project.service.web;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import project.model.dto.smarttender.SmarttenderDTO;
import project.model.response.Initiator;
import project.model.response.Site;
import project.model.response.Tender;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SmarttenderService implements IWebService {
    private List<project.model.dto.smarttender.Tender> tenderList;
    private List<project.model.dto.smarttender.Tender> onlyNewTenderList;

    private final String BASE_URL = "https://smarttender.biz/CommercialTrades/GetTenders/";
    private final Duration DURATION_TIMEOUT = Duration.ofSeconds(3);
    private final WebClient webClient;
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
                .baseUrl(BASE_URL)
                .build();
    }

    @Override
    public void updateTenderList() {
        List<project.model.dto.smarttender.Tender> tenders = new ArrayList<>();

        int page = 1;
        while (tenders.addAll(getSmarttenderDTOByPage(page++).getTenders()));

        tenders.removeAll(tenderList);
        onlyNewTenderList = tenders;

        tenders.addAll(tenderList);
        tenderList = tenders;
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
    public List<Tender> getTenderList() {
        updateTenderList();
        return mapToTender(tenderList);
    }

    @Override
    public List<Tender> getOnlyNewTenderList() {
        updateTenderList();
        return mapToTender(onlyNewTenderList);
    }

    //TODO correct method. It has many mistakes.
    private List<Tender> mapToTender(List<project.model.dto.smarttender.Tender> tenders) {
        List<Tender> tenderList = new ArrayList<>();
        for (project.model.dto.smarttender.Tender dto : tenders) {
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
                    .withStartTimestamp(LocalDateTime.parse(dto.getTenderingPeriod().getDateStart()))
                    .withEndTimestamp(LocalDateTime.parse(dto.getTenderingPeriod().getDateEnd()))
                    .withUrl("https://smarttender.biz/komertsiyni-torgy/" + dto.getId() + "/")
                    .build();

            tenderList.add(tender);
        }
        return tenderList;
    }
}
