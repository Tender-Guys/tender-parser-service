package project.telegram;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TenderParserServiceBot extends TelegramWebhookBot {

    String webHookPath;
    String botName;
    String botToken;

    // TODO: 25.03.2023 add MessageHandler and CallBackQueryHeandler
    public TenderParserServiceBot(SetWebhook setWebhook) {
        super(setWebhook);
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        // TODO: 25.03.2023 realise method 
        return null;
    }

    @Override
    public String getBotPath() {
        return webHookPath;
    }

    @Override
    public String getBotUsername() {
        return botName;
    }
}
