package com.gaotianchi.auth.controller;

import com.gaotianchi.auth.entity.User;
import com.gaotianchi.auth.service.UserService;
import com.gaotianchi.auth.vo.VO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gaotianchi
 * @since 2024/11/28 21:09
 **/
@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public VO<String> addUser() {
        return null;
    }
}
