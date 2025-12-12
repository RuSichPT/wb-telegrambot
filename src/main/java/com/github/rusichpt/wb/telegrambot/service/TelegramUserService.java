package com.github.rusichpt.wb.telegrambot.service;

import com.github.rusichpt.wb.telegrambot.repository.entity.TelegramUser;

import java.util.List;
import java.util.Optional;

public interface TelegramUserService {

    void deleteUserByChatId(Long chatId);

    void saveUser(TelegramUser user);

    Optional<TelegramUser> findUserByChatId(Long chatId);

    List<TelegramUser> findAll();

    boolean hasWbToken(Long chatId);
}
