package com.jerry.order.service.feign;

import com.inter.user.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "SERVICE-USER")
public interface UserRemoteService extends UserApi {
}
