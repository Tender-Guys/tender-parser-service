package project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Service
public class TenderService {

    private final String BASE_URL = "https://smarttender.biz/CommercialTrades/GetPageView/";
    private final Duration DURATION_TIMEOUT = Duration.ofSeconds(3);
    private final WebClient webClient;

    public TenderService() {
        webClient = WebClient.builder()
                .baseUrl(BASE_URL)
                .build();
    }

    public String getSomeResponse() {
        return webClient
                .get()
                .retrieve()
                .bodyToMono(String.class)
                .block(DURATION_TIMEOUT);
    }
}
