package project.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import project.telegram.TenderParserServiceBot;

@Configuration
@AllArgsConstructor
public class SpringConfig {

    private final TelegramConfig telegramConfig;

    @Bean
    public SetWebhook setWebhookInstance() {
        return SetWebhook.builder().url(telegramConfig.getWebHookPath()).build();
    }

    public TenderParserServiceBot springWebHookBot(SetWebhook setWebhook) {
        TenderParserServiceBot bot = new TenderParserServiceBot(setWebhook);

        bot.setWebHookPath(telegramConfig.getWebHookPath());
        bot.setBotName(telegramConfig.getBotName());
        bot.setBotToken(telegramConfig.getBotToken());

        return bot;
    }
}
