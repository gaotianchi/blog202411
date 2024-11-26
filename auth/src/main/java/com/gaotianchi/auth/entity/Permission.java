package com.gaotianchi.auth.entity;

import java.util.Date;

import lombok.Data;
import lombok.Builder;

import java.io.Serializable;
import java.io.Serial;

/**
 * 权限表(Permission)实体类
 * @author gaotianchi
 * @since 2024-11-24 20:26:27
 */
@Data
@Builder
public class Permission implements Serializable {

    @Serial
    private static final long serialVersionUID = 881075493759081439L;
    
    private Integer id;  // 自增ID
    private Integer code;  // 权限代码
    private String name;  // 权限名称
    private String description;  // 描述
    private Date createdAt; 
    private Date updatedAt; 
}

