package com.gaotianchi.auth.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.io.Serial;

/**
 * 用户表(User)实体类
 *
 * @author gaotianchi
 * @since 2024-11-23 18:00:30
 */
@Setter
@Getter
@NoArgsConstructor
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = -15525258711410910L;

    private Integer id;  // 自增ID
    private String username;  // 用户名
    private String password;  // 用户密码
    private String email;  // 邮箱
    private Date createdAt;  // 用户创建时间
    private Date updatedAt;  // 上次登录时间
    private Date lastLoginTime;  // 用户最后一次登录时间
    private String lastLoginIp;  // 用户最后一次登录IP
    private Integer failedAttempts;  // 连续登录失败次数
    private Integer isLocked;  // 是否锁定用户（0未锁定，1锁定）
    private Date lockExpiration;  // 账户锁定到期时间
    private Integer isClosed;  // 是否注销账户（0未注销，1已经注销）


}
