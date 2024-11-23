package com.gaotianchi.auth.service.impl;

import com.gaotianchi.auth.entity.RolePermission;
import com.gaotianchi.auth.dao.RolePermissionDao;
import com.gaotianchi.auth.service.RolePermissionService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;


/**
 * 角色权限表(RolePermission)表服务实现类
 *
 * @author gaotianchi
 * @since 2024-11-23 18:02:34
 */
@Service("rolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService {

    private final RolePermissionDao rolePermissionDao;

    public RolePermissionServiceImpl(RolePermissionDao rolePermissionDao) {
        this.rolePermissionDao = rolePermissionDao;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param roleCode 主键
     * @return RolePermission 实例对象
     */
    @Override
    public RolePermission queryById(Integer roleCode) {
        return rolePermissionDao.queryById(roleCode);
    }

    /**
     * 分页查询
     *
     * @param rolePermission 筛选条件
     * @param pageRequest    分页对象
     * @return Page<RolePermission> 查询结果
     */
    @Override
    public Page<RolePermission> queryByPage(RolePermission rolePermission, PageRequest pageRequest) {
        long total = rolePermissionDao.count(rolePermission);
        return new PageImpl<>(rolePermissionDao.queryByPage(rolePermission, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param rolePermission 实例对象
     * @return RolePermission 实例对象
     */
    @Override
    public RolePermission insert(RolePermission rolePermission) {
        rolePermissionDao.insert(rolePermission);
        return rolePermission;
    }

    /**
     * 修改数据
     *
     * @param rolePermission 实例对象
     * @return RolePermission 实例对象
     */
    @Override
    public RolePermission update(RolePermission rolePermission) {
        rolePermissionDao.update(rolePermission);
        return queryById(rolePermission.getRoleCode());
    }

    /**
     * 通过主键删除数据
     *
     * @param roleCode 主键
     * @return boolean 是否成功
     */
    @Override
    public boolean deleteById(Integer roleCode) {
        return rolePermissionDao.deleteById(roleCode) > 0;
    }
}
