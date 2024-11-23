package com.gaotianchi.auth.service.impl;

import com.gaotianchi.auth.model.entity.Permission;
import com.gaotianchi.auth.dao.PermissionDao;
import com.gaotianchi.auth.service.PermissionService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;


/**
 * 权限表(Permission)表服务实现类
 *
 * @author gaotianchi
 * @since 2024-11-23 17:50:52
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    private final PermissionDao permissionDao;

    public PermissionServiceImpl(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return Permission 实例对象
     */
    @Override
    public Permission queryById(Integer id) {
        return permissionDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param permission  筛选条件
     * @param pageRequest 分页对象
     * @return Page<Permission> 查询结果
     */
    @Override
    public Page<Permission> queryByPage(Permission permission, PageRequest pageRequest) {
        long total = permissionDao.count(permission);
        return new PageImpl<>(permissionDao.queryByPage(permission, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param permission 实例对象
     * @return Permission 实例对象
     */
    @Override
    public Permission insert(Permission permission) {
        permissionDao.insert(permission);
        return permission;
    }

    /**
     * 修改数据
     *
     * @param permission 实例对象
     * @return Permission 实例对象
     */
    @Override
    public Permission update(Permission permission) {
        permissionDao.update(permission);
        return queryById(permission.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return boolean 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return permissionDao.deleteById(id) > 0;
    }
}
