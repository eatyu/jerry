package com.jerry.facade.service.feign;

import com.inter.user.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

@FeignClient(value = "SERVICE-USER")
public interface UserRemoteService extends UserApi {
}
