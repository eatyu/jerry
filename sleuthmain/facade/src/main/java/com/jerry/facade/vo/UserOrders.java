package com.jerry.facade.vo;

import com.inter.order.dto.OrderDto;
import com.inter.user.dto.UserDto;
import lombok.Data;

import java.util.List;

@Data
public class UserOrders {
    private UserDto userDto;
    private List<OrderDto> orderDtos;
}
