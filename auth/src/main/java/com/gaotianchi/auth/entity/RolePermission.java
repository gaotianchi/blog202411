package com.gaotianchi.auth.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.io.Serial;

/**
 * 角色权限表(RolePermission)实体类
 *
 * @author gaotianchi
 * @since 2024-11-23 18:00:30
 */
@Setter
@Getter
@NoArgsConstructor
public class RolePermission implements Serializable {

    @Serial
    private static final long serialVersionUID = 401260537757915641L;

    private Integer roleCode;  // 角色代码
    private Integer permissionCode;  // 权限代码


}

