package com.gaotianchi.auth.model.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.io.Serial;

/**
 * 用户角色关联表(UserRole)实体类
 *
 * @author gaotianchi
 * @since 2024-11-23 17:12:51
 */
@Setter
@Getter
@NoArgsConstructor
public class UserRole implements Serializable {

    @Serial
    private static final long serialVersionUID = -90350974147412578L;

    private Integer userId;  // 用户id
    private Integer roleCode;  // 角色代码


}

