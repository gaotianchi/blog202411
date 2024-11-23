package com.gaotianchi.auth.controller;

import org.apache.catalina.util.StringUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
