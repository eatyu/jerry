package com.jerry.facade.service;

import com.jerry.facade.service.feign.OrderRemoteService;
import com.jerry.facade.service.feign.UserRemoteService;
import com.jerry.facade.vo.UserOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class UserService {

    @Autowired
    private UserRemoteService userRemoteService;
    @Autowired
    private OrderRemoteService orderRemoteService;



    public UserOrders getUserOrders(BigInteger userId) {
        UserOrders userOrders = new UserOrders();
        userOrders.setUserDto(userRemoteService.getInfobyId(userId));
        userOrders.setOrderDtos(orderRemoteService.getInfoByUserId(userId));
        return userOrders;
    }

}
