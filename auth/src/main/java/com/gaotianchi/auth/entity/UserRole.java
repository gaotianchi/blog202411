package com.gaotianchi.auth.entity;


import lombok.Data;
import lombok.Builder;

import java.io.Serializable;
import java.io.Serial;

/**
 * 用户角色关联表(UserRole)实体类
 * @author gaotianchi
 * @since 2024-11-24 20:26:27
 */
@Data
@Builder
public class UserRole implements Serializable {

    @Serial
    private static final long serialVersionUID = -36562653974590927L;
    
    private Integer userId;  // 用户id
    private Integer roleCode;  // 角色代码
}

