package project.service.web;

import project.model.dao.ITenderDAO;
import project.model.response.Tender;
import java.util.List;

/**
 * @author Mykola Lisnyi
 */
public class EtenderService implements IWebService {
    @Override
    public void updateTenderLists() {
    }

    @Override
    public void initializeBy(List<project.model.response.Tender> tenderList) {
    }

    @Override
    public List<Tender> getFullTenderList() {
        return List.of();
    }

    @Override
    public List<Tender> getOnlyNewTenderList() {
        return List.of();
    }
}