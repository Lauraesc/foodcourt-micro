package com.foodcourt.foodcourtmicro.adapters.driven.feign.client;

import com.foodcourt.foodcourtmicro.configuration.bean.feign.FeignConfig;
import org.apache.coyote.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-micro", url = "http://localhost:8080/users", configuration = FeignConfig.class)
public interface IUserClient {

    @GetMapping("/user-role")
    Boolean userRole(@RequestParam Long id, @RequestParam String role);
}
