package com.gaotianchi.auth.controller;

import com.gaotianchi.auth.dto.CreateClientDto;
import org.springframework.web.bind.annotation.*;

/**
 * @author gaotianchi
 * @since 2024/11/23 19:51
 **/
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("/{a}")
    public String test(@PathVariable String a) {
        if (a != null && !a.isEmpty()) {
            throw new RuntimeException("runtime exception");
        }
        return "test";
    }

    @PostMapping("/create-client")
    public String createClient(@RequestBody CreateClientDto createClientDto) {
        return "create-client";
    }
}
