package com.gaotianchi.auth.entity;


import lombok.Data;
import lombok.Builder;

import java.io.Serializable;
import java.io.Serial;

/**
 * 角色权限表(RolePermission)实体类
 *
 * @author gaotianchi
 * @since 2024-11-27 21:01:30
 */
@Data
@Builder
public class RolePermission implements Serializable {

    @Serial
    private static final long serialVersionUID = -19450644609074521L;

    private Integer id;
    private Integer roleCode;  // 角色代码
    private Integer permissionCode;  // 权限代码
}

