package com.gaotianchi.auth.service;

import com.gaotianchi.auth.entity.Permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 权限表(Permission)表服务接口
 *
 * @author gaotianchi
 * @since 2024-11-23 18:02:34
 */
public interface PermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Permission queryById(Integer id);

    /**
     * 分页查询
     *
     * @param permission  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Permission> queryByPage(Permission permission, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    Permission insert(Permission permission);

    /**
     * 修改数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    Permission update(Permission permission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
