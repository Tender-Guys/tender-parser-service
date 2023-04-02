package project.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import project.model.dao.HTenderDAO;
import project.model.dao.ITenderDAO;
import project.model.dto.smarttender.SmarttenderDTO;
import project.model.response.Tender;

import java.time.Duration;
import java.util.Optional;

@Service
public class TenderService {

    private final String BASE_URL = "https://smarttender.biz/CommercialTrades/GetTenders/";
    private final Duration DURATION_TIMEOUT = Duration.ofSeconds(3);
    private final WebClient webClient;
    private final ITenderDAO<Tender> dao = new HTenderDAO();

    public TenderService() {
        webClient = WebClient.builder()
                .baseUrl(BASE_URL)
                .build();
    }

    public String getSomeResponse() {
        return webClient
                .post()
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue("{\n" +
                        "  \"searchParam\": {\n" +
                        "    \"TradeSegment\": 1,\n" +
                        "    \"TenderMode\": 1,\n" +
                        "    \"Page\": 30,\n" +
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
                        "}")
                .retrieve()
                .bodyToMono(SmarttenderDTO.class)
                .block(DURATION_TIMEOUT)
                .toString();
    }


    public String getTenderFromDBByID(String id) {
        Optional<Tender> tenderOpt = dao.getByID(id);
        return tenderOpt.isPresent()
                ? tenderOpt.get().toString()
                : String.format("There is no tender with ID = %s in DB", id);
    }
}
