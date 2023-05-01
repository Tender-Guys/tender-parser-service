package project.service.web;

import project.model.response.Tender;
import java.util.List;

/**
 * @author Mykola Lisnyi
 */
public interface IWebService {
    void updateTenderLists();
    List<Tender> getFullTenderList();
    List<Tender> getOnlyNewTenderList();
    void initializeBy(List<Tender> tenderList);
}