package project.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import project.telegram.TenderParserServiceBot;

@RestController
@AllArgsConstructor
public class WebHookController {

    private final TenderParserServiceBot tenderParserServiceBot;

    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return tenderParserServiceBot.onWebhookUpdateReceived(update);
    }
}
