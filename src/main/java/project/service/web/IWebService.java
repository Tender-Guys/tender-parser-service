package project.service.web;

import project.model.response.Tender;

import java.util.List;

public interface IWebService {
    void updateTenderList();
    List<Tender> getTenderList();
    List<Tender> getOnlyNewTenderList();
}
