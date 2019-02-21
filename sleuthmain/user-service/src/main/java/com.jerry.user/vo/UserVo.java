package com.jerry.user.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.Data;

import java.math.BigInteger;

@Data
public class UserVo {


    @JSONField(name = "tap_name")
    private String tapId;

    @JSONField(name = "tap")
    private String ta;

    @JSONField(serializeUsing= ToStringSerializer.class)
    private BigInteger userId;
}
