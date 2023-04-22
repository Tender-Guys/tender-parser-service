package project.configuration;

import project.model.dao.HTenderDAO;
import project.model.dao.ITenderDAO;
import project.service.web.EtenderService;
import project.service.web.IWebService;
import project.service.web.SmarttenderService;

import java.util.ArrayList;
import java.util.List;

abstract public class Configuration {
    private Configuration() {
    }

    static public ITenderDAO getDaoImplementation(){
        return new HTenderDAO();
    }

    public static List<IWebService> getWebServiceList() {
        return new ArrayList<>(List.of(
                new SmarttenderService(),
                new EtenderService()
        ));
    }
}
