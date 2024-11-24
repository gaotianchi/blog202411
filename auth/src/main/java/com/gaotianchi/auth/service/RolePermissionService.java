package com.gaotianchi.auth.service;

import com.gaotianchi.auth.entity.RolePermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 角色权限表(RolePermission)表服务接口
 *
 * @author gaotianchi
 * @since 2024-11-23 19:41:37
 */
public interface RolePermissionService {

    /**
     * 分页查询
     *
     * @param rolePermission 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    Page<RolePermission> queryByPage(RolePermission rolePermission, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param rolePermission 实例对象
     * @return 实例对象
     */
    RolePermission insert(RolePermission rolePermission);
}
