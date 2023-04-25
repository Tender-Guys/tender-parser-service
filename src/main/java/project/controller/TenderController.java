package project.controller;

import org.springframework.web.bind.annotation.*;
import project.service.TenderService;

@RestController
public class TenderController {

    private final TenderService service;

    public TenderController (TenderService service) {
        this.service = service;
    }

    @GetMapping(path = "/")
    public String getOnlyNewTenderListFromDB() {
        return service.getOnlyNewTenderListFromDB().toString();
    }

    @GetMapping(path = "/{id}")
    public String getTenderFromDBByID(@PathVariable String id) {
        return service.getTenderFromDBByID(id);
    }

    @GetMapping(path = "/all")
    public String getAllTendersFromDB() {
        return service.getAllTendersFromDB();
    }

    @DeleteMapping(path = "/{id}")
    public String removeTenderFromDBByID(@PathVariable String id) {
        return service.removeTenderFromDBByID(id);
    }

    @DeleteMapping(path = "/all")
    public String removeAllTendersFromDB() {
        return service.removeAllTendersFromDB();
    }
}