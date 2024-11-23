package com.gaotianchi.auth.model.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.io.Serial;

/**
 * 权限表(Permission)实体类
 *
 * @author gaotianchi
 * @since 2024-11-23 17:12:51
 */
@Setter
@Getter
@NoArgsConstructor
public class Permission implements Serializable {

    @Serial
    private static final long serialVersionUID = 847937582793597607L;

    private Integer id;  // 自增ID
    private Integer code;  // 权限代码
    private String name;  // 权限名称
    private String description;  // 描述


}

