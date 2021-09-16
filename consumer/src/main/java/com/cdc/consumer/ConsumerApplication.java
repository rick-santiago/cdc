package com.cdc.consumer;

import com.cdc.provider.OrderApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.cdc.provider"})
public class ConsumerApplication {
//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
//    @Autowired
//    RestTemplate restTemplate;
//    @Autowired
//    LoadBalancerClient loadBalancerClient;
    @Autowired
    OrderApi orderApi;

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @GetMapping("/orders")
    public String payments() {
        String orders = orderApi.orders("123456");

//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Content-Type", "application/json");
//        ServiceInstance choose = loadBalancerClient.choose("consul-client-provider");
//        ResponseEntity<String> responseEntity = restTemplate.exchange(
//                choose.getUri() + "/orders/123456",
//                HttpMethod.GET,
//                new HttpEntity<>(httpHeaders),
//                String.class);
//        ResponseEntity<String> responseEntity = restTemplate.exchange(
//                "http://localhost:8090/orders/123456",
//                HttpMethod.GET,
//                new HttpEntity<>(httpHeaders),
//                String.class);

//        return responseEntity.getBody();
        return orders;
    }
}
