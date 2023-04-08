package project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import project.service.TenderService;

@RestController
public class TenderController {

    private final TenderService service;

    public TenderController (TenderService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getTenderList() {
        return service.getTenderDAOList().toString();
    }


    @GetMapping(path = "/{id}")
    public String getTenderFromDBByID(@PathVariable String id) {
        return service.getTenderFromDBByID(id);
    }

    @PostMapping(path = "/{id}")
    public void postTenderToDBByPositionInList(@PathVariable String id) {
        service.postTenderToDBByPositionInList(id);
    }
}
