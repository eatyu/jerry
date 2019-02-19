package com.safesoft.gateway.entity;

public class NoTokenReturnEntity extends ReturnEntity {
    public NoTokenReturnEntity(){
        code = -1;
        msg = "no token error";
    }
}
