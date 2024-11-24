package com.gaotianchi.auth.dao;

import com.gaotianchi.auth.entity.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 角色权限表(RolePermission)表数据库访问层
 *
 * @author gaotianchi
 * @since 2024-11-23 18:02:34
 */
@Mapper
public interface RolePermissionDao {

    /**
     * Get the user's role and permission name, role name with prefix "ROLE_"
     *
     * @param username username
     * @return java.util.List<java.lang.String>
     * @author gaotianchi
     * @since 2024/11/24 14:39
     **/
    List<String> queryUserPermissionNameAndRoleNameWithRolePrefixByUsername(String username);

    /**
     * 查询指定行数据
     *
     * @param rolePermission 查询条件
     * @param pageable       Pageable 分页对象
     * @return List<RolePermission> 对象列表
     */
    List<RolePermission> queryByPage(RolePermission rolePermission, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param rolePermission 查询条件
     * @return long 总行数
     */
    long count(RolePermission rolePermission);

    /**
     * 新增数据
     *
     * @param rolePermission 实例对象
     * @return int 影响行数
     */
    int insert(RolePermission rolePermission);
}

