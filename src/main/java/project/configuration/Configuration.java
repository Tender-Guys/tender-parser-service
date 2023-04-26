package project.configuration;

import project.service.web.EtenderService;
import project.service.web.IWebService;
import project.service.web.SmarttenderService;
import java.util.ArrayList;
import java.util.List;

public abstract class Configuration {

    private Configuration() {
    }

    public static List<IWebService> getWebServiceList() {
        return new ArrayList<>(List.of(
                new SmarttenderService(),
                new EtenderService()
        ));
    }
}