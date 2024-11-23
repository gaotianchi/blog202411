package com.gaotianchi.auth.service.impl;

import com.gaotianchi.auth.entity.Role;
import com.gaotianchi.auth.dao.RoleDao;
import com.gaotianchi.auth.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;


/**
 * 角色表(Role)表服务实现类
 *
 * @author gaotianchi
 * @since 2024-11-23 18:02:34
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return Role 实例对象
     */
    @Override
    public Role queryById(Integer id) {
        return roleDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param role        筛选条件
     * @param pageRequest 分页对象
     * @return Page<Role> 查询结果
     */
    @Override
    public Page<Role> queryByPage(Role role, PageRequest pageRequest) {
        long total = roleDao.count(role);
        return new PageImpl<>(roleDao.queryByPage(role, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param role 实例对象
     * @return Role 实例对象
     */
    @Override
    public Role insert(Role role) {
        roleDao.insert(role);
        return role;
    }

    /**
     * 修改数据
     *
     * @param role 实例对象
     * @return Role 实例对象
     */
    @Override
    public Role update(Role role) {
        roleDao.update(role);
        return queryById(role.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return boolean 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return roleDao.deleteById(id) > 0;
    }
}
