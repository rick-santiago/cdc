package com.cdc.provider;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;

@FeignClient(name = "consul-client-provider"
        , url = "${feign.client.url.orderUrl}"
)
public interface OrderApi {
    @GetMapping(value = "/orders/{id}")
    String orders(@PathVariable String id);
}
