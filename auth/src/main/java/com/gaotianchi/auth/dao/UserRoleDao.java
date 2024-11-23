package com.gaotianchi.auth.dao;

import com.gaotianchi.auth.entity.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

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
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return Integer 实例对象
     */
    UserRole queryById(Integer userId);

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

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserRole> 实例对象列表
     * @return int 影响行数
     */
    int insertBatch(@Param("entities") List<UserRole> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserRole> 实例对象列表
     * @return int 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<UserRole> entities);

    /**
     * 修改数据
     *
     * @param userRole 实例对象
     * @return int 影响行数
     */
    int update(UserRole userRole);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return int 影响行数
     */
    int deleteById(Integer userId);
}

