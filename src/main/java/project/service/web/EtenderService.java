package project.service.web;

import project.model.response.Tender;

import java.util.List;

public class EtenderService implements IWebService {
    @Override
    public void updateTenderList() {
    }

    @Override
    public List<Tender> getTenderList() {
        return List.of();
    }

    @Override
    public List<Tender> getOnlyNewTenderList() {
        return List.of();
    }
}
