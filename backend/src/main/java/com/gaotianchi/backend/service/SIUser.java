package com.gaotianchi.backend.service;

import com.gaotianchi.backend.Response.info.UserInfo;

public interface SIUser {
    UserInfo newUser();
    void deleteUser();
    UserInfo getInfo();
    void updatePassword(String newPassword);
    void updatePenName(String newPenName);
}
