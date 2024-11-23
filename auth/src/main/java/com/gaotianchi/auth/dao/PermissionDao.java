package com.gaotianchi.auth.dao;

import com.gaotianchi.auth.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限表(Permission)表数据库访问层
 *
 * @author gaotianchi
 * @since 2024-11-23 18:02:34
 */
@Mapper
public interface PermissionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return Integer 实例对象
     */
    Permission queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param permission 查询条件
     * @param pageable   Pageable 分页对象
     * @return List<Permission> 对象列表
     */
    List<Permission> queryByPage(Permission permission, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param permission 查询条件
     * @return long 总行数
     */
    long count(Permission permission);

    /**
     * 新增数据
     *
     * @param permission 实例对象
     * @return int 影响行数
     */
    int insert(Permission permission);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Permission> 实例对象列表
     * @return int 影响行数
     */
    int insertBatch(@Param("entities") List<Permission> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Permission> 实例对象列表
     * @return int 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Permission> entities);

    /**
     * 修改数据
     *
     * @param permission 实例对象
     * @return int 影响行数
     */
    int update(Permission permission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return int 影响行数
     */
    int deleteById(Integer id);
}

