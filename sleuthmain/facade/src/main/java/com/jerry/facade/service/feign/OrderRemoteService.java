package com.jerry.facade.service.feign;

import com.inter.order.api.OrderApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "SERVICE-ORDER")
public interface OrderRemoteService extends OrderApi {
}
