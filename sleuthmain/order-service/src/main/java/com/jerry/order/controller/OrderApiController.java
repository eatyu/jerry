package com.jerry.order.controller;

import com.inter.order.api.OrderApi;
import com.inter.order.dto.OrderDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderApiController implements OrderApi {

    @Override
    @RequestMapping("/getInfoByUserId")
    public List<OrderDto> getInfoByUserId(BigInteger userId) {
        List<OrderDto> orderDtos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            OrderDto dto = new OrderDto();
            dto.setActualMoney(i * 100 + 1);
            dto.setName("物品" + i);
            dto.setPrice(i * 1000 + 1);
            dto.setOrderId(new BigInteger("" + i));
        }
        return orderDtos;
    }
}
