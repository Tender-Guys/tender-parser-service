package project.service.web;

import project.model.response.Tender;
import java.util.List;

public interface IWebService {
    void updateTenderLists();
    List<Tender> getFullTenderList();
    List<Tender> getOnlyNewTenderList();
}