package com.jerry.facade.service;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.inter.order.dto.OrderDto;
import com.inter.user.dto.UserDto;
import com.jerry.facade.service.feign.OrderRemoteService;
import com.jerry.facade.service.feign.UserRemoteService;
import com.jerry.facade.vo.UserOrders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRemoteService userRemoteService;
    @Autowired
    private OrderRemoteService orderRemoteService;



    public UserOrders getUserOrders(BigInteger userId) {
        UserOrders userOrders = new UserOrders();
        UserDto infobyId = userRemoteService.getInfobyId(userId);
        logger.info("infobyId={}", JSON.toJSONString(infobyId));
        userOrders.setUserDto(infobyId);
        List<OrderDto> infoByUserId = orderRemoteService.getInfoByUserId(userId);
        logger.info("infoByUserId={}", JSON.toJSONString(infoByUserId));
        userOrders.setOrderDtos(infoByUserId);
        return userOrders;
    }

}
