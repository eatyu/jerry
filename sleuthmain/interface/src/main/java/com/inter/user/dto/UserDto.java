package com.inter.user.dto;

import lombok.Data;

import java.math.BigInteger;

@Data
public class UserDto {
    private BigInteger userId;
    private String name;
}
