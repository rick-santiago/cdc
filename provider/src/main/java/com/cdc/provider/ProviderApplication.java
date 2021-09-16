package com.cdc.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
@RestController
@EnableFeignClients
@EnableDiscoveryClient
public class ProviderApplication implements OrderApi {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Override
    @GetMapping(value = "/orders/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String orders(@PathVariable String id) {
        if (id.equals("123456")) {
            return "{\"id\":\"123456\", \"name\":\"testOrder\"}";
        } else {
//            response.setStatus(404);
            return null;
        }
    }
}
