package com.github.rusichpt.wb.telegrambot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {
    void execute(Update update);

    default void executeCallback(Update update) {
    }
}
