package com.github.rusichpt.wb.telegrambot.command;

import com.github.rusichpt.wb.telegrambot.service.SendBotService;
import com.github.rusichpt.wb.telegrambot.service.SendBotServiceImpl;
import com.github.rusichpt.wb.telegrambot.service.TelegramUserService;
import com.github.rusichpt.wb.telegrambot.wbclient.WbClientPrices;
import com.github.rusichpt.wb.telegrambot.wbclient.WbClientPricesImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CommandContainerTest {

    protected final SendBotService sendBotService = Mockito.mock(SendBotServiceImpl.class);
    protected final WbClientPrices wbClientPrices = Mockito.mock(WbClientPricesImpl.class);
    protected final TelegramUserService telegramUserService = Mockito.mock(TelegramUserService.class);
    private final CommandContainer commandContainer = new CommandContainer(sendBotService, wbClientPrices, telegramUserService);

    @Test
    public void shouldBeTheSameNumberCommand() {
        Assertions.assertEquals(commandContainer.size(), CommandName.values().length);
    }
}
