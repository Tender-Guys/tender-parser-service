package project.controller;

import org.springframework.web.bind.annotation.*;
import project.service.TenderService;

/**
 * @author Mykola Lisnyi
 */
@RestController
public class TenderController {

    private final TenderService service;

    public TenderController (TenderService service) {
        this.service = service;
    }

    @GetMapping(path = "/new")
    public String getOnlyNewTenderListFromDB() {
        return service.getOnlyNewTenderListFromDB().toString();
    }

    @GetMapping(path = "/update")
    public String updateTenderListInDB() {
        service.updateTenderListInDB();
        return service.getOnlyNewTenderListFromDB().toString();
    }

    @GetMapping(path = "/{id}")
    public String getTenderFromDBByID(@PathVariable String id) {
        return service.getTenderFromDBByID(id).toString();
    }

    @GetMapping(path = "/all")
    public String getFullTenderListFromDB() {
        return service.getFullTenderListFromDB().toString();
    }

    @DeleteMapping(path = "/{id}")
    public String removeTenderFromDBByID(@PathVariable String id) {
        return service.removeTenderFromDBByID(id).toString();
    }

    @DeleteMapping(path = "/all")
    public String removeAllTendersFromDB() {
        return service.removeAllTendersFromDB();
    }
}