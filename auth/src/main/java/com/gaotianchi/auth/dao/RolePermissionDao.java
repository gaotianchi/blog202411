package com.gaotianchi.auth.dao;

import com.gaotianchi.auth.entity.RolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

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
     * 通过ID查询单条数据
     *
     * @param roleCode 主键
     * @return Integer 实例对象
     */
    RolePermission queryById(Integer roleCode);

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

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<RolePermission> 实例对象列表
     * @return int 影响行数
     */
    int insertBatch(@Param("entities") List<RolePermission> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<RolePermission> 实例对象列表
     * @return int 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<RolePermission> entities);

    /**
     * 修改数据
     *
     * @param rolePermission 实例对象
     * @return int 影响行数
     */
    int update(RolePermission rolePermission);

    /**
     * 通过主键删除数据
     *
     * @param roleCode 主键
     * @return int 影响行数
     */
    int deleteById(Integer roleCode);
}

