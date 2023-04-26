package project.service;

import com.mysql.cj.exceptions.WrongArgumentException;
import org.springframework.stereotype.Service;
import project.configuration.Configuration;
import project.model.dao.ITenderDAO;
import project.model.response.Tender;
import project.service.web.IWebService;
import java.util.List;

@Service
public class TenderService {
    private final ITenderDAO dao;
    private final String REMOVE_ALL_MSG = "DataBase was removed";
    private final List<IWebService> webServiceList;

    public TenderService() {
        dao = Configuration.getDaoImplementation();
        webServiceList = Configuration.getWebServiceList();
    }

    public void updateTenderListInDB() {
        for (IWebService webService : webServiceList) {
            webService.updateTenderLists();
            dao.addAll(webService.getOnlyNewTenderList());
        }
    }

    public List<Tender> getOnlyNewTenderListFromDB() {
        return webServiceList.stream()
                .map(IWebService::getOnlyNewTenderList)
                .flatMap(List::stream)
                .map(dao::findTender)
                .filter(tender -> tender.getId() != null)
                .toList();
    }

    public String getTenderFromDBByID(String id) {
        return dao.getByID(mapIdToIntegerOrThrowException(id)).toString();
    }

    public List<Tender> getFullTenderListFromDB() {
        return dao.getAll();
    }

    public String removeTenderFromDBByID(String id) {
        return dao.removeById(mapIdToIntegerOrThrowException(id)).toString();
    }

    public String removeAllTendersFromDB() {
        dao.removeAll();
        return REMOVE_ALL_MSG;
    }

    private Integer mapIdToIntegerOrThrowException(String id) {
        if (!id.strip().matches("\\d+")) {
            throw new WrongArgumentException("ID should be any natural number {1, 2, 3, ... n}");
        }
        return Integer.parseInt(id.strip());
    }
}