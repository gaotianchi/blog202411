package com.gaotianchi.auth.entity;


import lombok.Data;
import lombok.Builder;

import java.io.Serializable;
import java.io.Serial;

/**
 * (UserRole)实体类
 *
 * @author gaotianchi
 * @since 2024-11-27 21:01:30
 */
@Data
@Builder
public class UserRole implements Serializable {

    @Serial
    private static final long serialVersionUID = -84758873007088946L;

    private Integer id;
    private Integer userId;  // 用户id
    private Integer roleCode;  // 角色代码
}

