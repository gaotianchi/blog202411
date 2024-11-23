package com.gaotianchi.auth.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.io.Serial;

/**
 * 用户角色关联表(UserRole)实体类
 *
 * @author gaotianchi
 * @since 2024-11-23 18:00:30
 */
@Setter
@Getter
@NoArgsConstructor
public class UserRole implements Serializable {

    @Serial
    private static final long serialVersionUID = 275944137737357865L;

    private Integer userId;  // 用户id
    private Integer roleCode;  // 角色代码


}

