package com.inter.order.api;

import com.inter.order.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigInteger;
import java.util.List;

@FeignClient(value = "SERVICE-ORDER")
public interface OrderApi {

    @RequestMapping("/getInfoByUserId")
    List<OrderDto> getInfoByUserId(@RequestParam("userId") BigInteger userId);

}
