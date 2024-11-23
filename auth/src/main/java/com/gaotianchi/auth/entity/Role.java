package com.gaotianchi.auth.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.io.Serial;

/**
 * 角色表(Role)实体类
 *
 * @author gaotianchi
 * @since 2024-11-23 18:00:29
 */
@Setter
@Getter
@NoArgsConstructor
public class Role implements Serializable {

    @Serial
    private static final long serialVersionUID = 971841347992257629L;

    private Integer id;  // 自增ID
    private Integer code;  // 角色代码
    private String name;  // 角色名称
    private String description;  // 描述
    private Date createdAt;  // 创建时间
    private Date updatedAt;  // 更新时间


}

