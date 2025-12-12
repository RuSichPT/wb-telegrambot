package com.github.rusichpt.wb.telegrambot.command;

import com.github.rusichpt.wb.telegrambot.wbclient.WbClientPrices;
import com.github.rusichpt.wb.telegrambot.wbclient.WbClientPricesImpl;
import com.github.rusichpt.wb.telegrambot.wbclient.dto.Order;
import com.github.rusichpt.wb.telegrambot.wbclient.dto.Orders;
import com.github.rusichpt.wb.telegrambot.wbclient.dto.PriceInfoGet;
import kong.unirest.HttpResponse;
import org.mockito.Mockito;

import java.util.List;

import static java.util.Collections.singletonList;

public abstract class AbstractWbClientCommandTest extends AbstractCommandTest {

    protected final WbClientPrices wbClientPrices = Mockito.mock(WbClientPricesImpl.class);
    protected final HttpResponse<List<PriceInfoGet>> httpResponseList = Mockito.mock(HttpResponse.class);
    protected final List<PriceInfoGet> priceInfoGetList = createPriceInfoGetList();

    protected final HttpResponse<Orders> httpResponseOrders = Mockito.mock(HttpResponse.class);
    protected final Orders orders = Mockito.mock(Orders.class);
    protected final List<Order> ordersList = Mockito.mock(List.class);

    private List<PriceInfoGet> createPriceInfoGetList() {
        PriceInfoGet priceInfoGet = new PriceInfoGet();
        priceInfoGet.setNmId(123456);
        priceInfoGet.setPrice(10256d);
        priceInfoGet.setDiscount(53);
        priceInfoGet.setPromoCode(123d);

        return singletonList(priceInfoGet);
    }

    protected void initHttpResponseOrders(int size) {
        Mockito.when(httpResponseOrders.getBody()).thenReturn(orders);
        Mockito.when(orders.getOrders()).thenReturn(ordersList);
        Mockito.when(ordersList.size()).thenReturn(size);
    }
}
