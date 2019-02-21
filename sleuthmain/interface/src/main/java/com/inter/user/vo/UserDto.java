package com.inter.user.vo;

import lombok.Data;

import java.math.BigInteger;

@Data
public class UserDto {
    private BigInteger userId;
    private String name;
}
