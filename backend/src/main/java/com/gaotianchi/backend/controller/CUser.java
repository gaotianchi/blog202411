package com.gaotianchi.backend.controller;

import com.gaotianchi.backend.Response.R;
import com.gaotianchi.backend.Response.info.UserInfo;
import com.gaotianchi.backend.request.UpdatePassword;
import com.gaotianchi.backend.service.SUser;
import org.springframework.web.bind.annotation.*;

@RestController
public class CUser {
    private final SUser sUser;

    public CUser(SUser sUser) {
        this.sUser = sUser;
    }

    @GetMapping("/users/info")
    public R<UserInfo> getInfo() {
        return R.success(sUser.getInfo());
    }

    @PatchMapping("/users/pen-name/{newName}")
    public R<Void> updatePenName(@PathVariable String newName) {
        sUser.updatePenName(newName);
        return R.success();
    }

    @PatchMapping("/users/password")
    public R<Void> updatePassword(@RequestBody UpdatePassword updatePassword) {
        sUser.updatePassword(updatePassword.getPassword());
        return R.success();
    }
}