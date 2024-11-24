package com.gaotianchi.auth.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * 权限表(Permission)实体类
 *
 * @author gaotianchi
 * @since 2024-11-23 18:00:29
 */
@Setter
@Getter
@NoArgsConstructor
public class Permission implements Serializable {

    @Serial
    private static final long serialVersionUID = -98977377874010388L;

    private Integer id;  // 自增ID
    private Integer code;  // 权限代码
    private String name;  // 权限名称
    private String description;  // 描述


}

