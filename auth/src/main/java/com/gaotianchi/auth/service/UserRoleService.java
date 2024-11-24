package com.gaotianchi.auth.service;

import com.gaotianchi.auth.entity.UserRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 用户角色关联表(UserRole)表服务接口
 *
 * @author gaotianchi
 * @since 2024-11-23 19:41:37
 */
public interface UserRoleService {

    /**
     * 分页查询
     *
     * @param userRole    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<UserRole> queryByPage(UserRole userRole, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param userRole 实例对象
     * @return 实例对象
     */
    UserRole insert(UserRole userRole);

}
