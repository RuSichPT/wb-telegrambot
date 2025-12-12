package com.github.rusichpt.wb.telegrambot.service;

import com.github.rusichpt.wb.telegrambot.repository.entity.TelegramUser;

public interface EncryptTgUserService {

    void code(TelegramUser telegramUser);

    void decode(TelegramUser telegramUser);
}
