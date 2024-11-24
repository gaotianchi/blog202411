package com.gaotianchi.auth.service.impl;

import com.gaotianchi.auth.dao.UserRoleDao;
import com.gaotianchi.auth.entity.UserRole;
import com.gaotianchi.auth.service.UserRoleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


/**
 * 用户角色关联表(UserRole)表服务实现类
 *
 * @author gaotianchi
 * @since 2024-11-23 19:41:37
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleDao userRoleDao;

    public UserRoleServiceImpl(UserRoleDao userRoleDao) {
        this.userRoleDao = userRoleDao;
    }

    /**
     * 分页查询
     *
     * @param userRole    筛选条件
     * @param pageRequest 分页对象
     * @return Page<UserRole> 查询结果
     */
    @Override
    public Page<UserRole> queryByPage(UserRole userRole, PageRequest pageRequest) {
        long total = userRoleDao.count(userRole);
        return new PageImpl<>(userRoleDao.queryByPage(userRole, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param userRole 实例对象
     * @return UserRole 实例对象
     */
    @Override
    public UserRole insert(UserRole userRole) {
        userRoleDao.insert(userRole);
        return userRole;
    }

}
