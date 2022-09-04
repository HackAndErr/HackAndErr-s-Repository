package org.timetable.bot;

import org.timetable.bot.providers.BotNameProvider;
import org.timetable.bot.providers.TokenProvider;
import org.telegram.telegrambots.meta.api.objects.Update;

public class CurrencyInfoBot extends AbstractTgBot{


    public CurrencyInfoBot(TokenProvider tokenProvider, BotNameProvider botNameProvider) {
        super(tokenProvider, botNameProvider);
    }

    @Override
    public void onUpdateReceived(Update update){
        System.out.println(update.getMessage().getChatId());
        System.out.println(update.getMessage().getText());

    }
}
