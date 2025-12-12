package com.github.rusichpt.wb.telegrambot.command;

import kong.unirest.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.github.rusichpt.wb.telegrambot.command.CommandName.GET_NEW_ORDERS;
import static com.github.rusichpt.wb.telegrambot.command.GetAllOrdersCommand.MESSAGE2;
import static com.github.rusichpt.wb.telegrambot.command.GetNewOrdersCommand.MESSAGE1;

public class GetNewOrdersCommandTest extends AbstractWbClientCommandTest {

    private final GetNewOrdersCommand getNewOrdersCommand = new GetNewOrdersCommand(sendBotService, telegramUserService, wbClientPrices);

    @BeforeEach
    public void init() {
        initHttpResponseOrders(15);

        Mockito.when(wbClientPrices.getNewOrders(Mockito.any(String.class))).thenReturn(httpResponseOrders);

        initTelegramUserService();
    }

    @Test
    public void shouldCorrectlySendMessage1() {
        //given
        Mockito.when(httpResponseOrders.getStatus()).thenReturn(HttpStatus.OK);
        String command = GET_NEW_ORDERS.getCommandName();
        String answer = String.format(MESSAGE1, ordersList.size());

        executeAndVerify(getNewOrdersCommand, command, answer);
    }

    @Test
    public void shouldCorrectlySendMessage2() {
        //given
        Mockito.when(httpResponseOrders.getStatus()).thenReturn(HttpStatus.BAD_REQUEST);
        String command = GET_NEW_ORDERS.getCommandName();

        executeAndVerify(getNewOrdersCommand, command, MESSAGE2);
    }
}
