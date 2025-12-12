package com.github.rusichpt.wb.telegrambot.wbclient.dto;

import lombok.Data;

@Data
public class PriceInfoGet {
    private Integer nmId;
    private Double price;
    private Integer discount;
    private Double promoCode;
}
