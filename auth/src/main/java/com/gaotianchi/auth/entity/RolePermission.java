package com.gaotianchi.auth.entity;


import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 角色权限表(RolePermission)实体类
 *
 * @author gaotianchi
 * @since 2024-11-24 20:26:27
 */
@Data
@Builder
public class RolePermission implements Serializable {

    @Serial
    private static final long serialVersionUID = -52572510350031322L;

    private Integer roleCode;  // 角色代码
    private Integer permissionCode;  // 权限代码
}

