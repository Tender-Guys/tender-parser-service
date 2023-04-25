package project.service;

import org.springframework.stereotype.Service;
import project.configuration.Configuration;
import project.model.dao.ITenderDAO;
import project.model.response.Tender;
import project.service.web.IWebService;
import java.util.List;

@Service
public class TenderService {
    private final ITenderDAO dao;
    private final String WRONG_PARAMETER_MSG = "Input parameter [%s] is not correct. Enter Integer type (more than 0).";
    private final String REMOVE_ALL_MSG = "DataBase was removed";
    private final List<IWebService> webServiceList;

    public TenderService() {
        dao = Configuration.getDaoImplementation();
        webServiceList = Configuration.getWebServiceList();
    }

    public List<Tender> getOnlyNewTenderListFromDB() {
        List<Tender> onlyNewTenderListFromAllSites = webServiceList.stream()
                .map(IWebService::getOnlyNewTenderList)
                .flatMap(List::stream)
                .toList();
        dao.addAll(onlyNewTenderListFromAllSites);
        return onlyNewTenderListFromAllSites.stream().filter(t -> t.getId() != null).toList();
    }

    public String getTenderFromDBByID(String id) {
        return isCorrect(id)
                ? dao.getByID(Integer.parseInt(id.strip())).toString()
                : String.format(WRONG_PARAMETER_MSG, id);
    }

    public String getAllTendersFromDB() {
        return dao.getAll().toString();
    }

    public String removeTenderFromDBByID(String id) {
        return isCorrect(id)
                ? dao.removeById(Integer.parseInt(id.strip())).toString()
                : String.format(WRONG_PARAMETER_MSG, id);
    }

    public String removeAllTendersFromDB() {
        dao.removeAll();
        return REMOVE_ALL_MSG;
    }

    private boolean isCorrect(String id) {
        return id.strip().matches("\\d+");
    }
}