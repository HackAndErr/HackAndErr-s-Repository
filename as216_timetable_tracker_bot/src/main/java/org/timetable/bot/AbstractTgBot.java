package org.example.tg.bot;

import org.example.tg.bot.providers.BotNameProvider;
import org.example.tg.bot.providers.TokenProvider;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public abstract class AbstractTgBot extends TelegramLongPollingBot {

    private final TokenProvider tokenProvider;
    private final BotNameProvider botNameProvider;

    protected AbstractTgBot(TokenProvider tokenProvider, BotNameProvider botNameProvider) {
        this.tokenProvider = tokenProvider;
        this.botNameProvider = botNameProvider;
    }

    @Override
    public final String getBotUsername() {
        return botNameProvider.get();
    }

    @Override
    public final String getBotToken() {
        return tokenProvider.get();
    }

}
