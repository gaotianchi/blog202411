package com.gaotianchi.auth.dao;

import com.gaotianchi.auth.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 用户角色关联表(UserRole)表数据库访问层
 *
 * @author gaotianchi
 * @since 2024-11-23 18:02:35
 */
@Mapper
public interface UserRoleDao {


    /**
     * 查询指定行数据
     *
     * @param userRole 查询条件
     * @param pageable Pageable 分页对象
     * @return List<UserRole> 对象列表
     */
    List<UserRole> queryByPage(UserRole userRole, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param userRole 查询条件
     * @return long 总行数
     */
    long count(UserRole userRole);

    /**
     * 新增数据
     *
     * @param userRole 实例对象
     * @return int 影响行数
     */
    int insert(UserRole userRole);
}

