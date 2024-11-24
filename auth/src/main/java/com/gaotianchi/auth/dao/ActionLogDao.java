package com.gaotianchi.auth.dao;

import com.gaotianchi.auth.entity.ActionLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 用户行为日志(ActionLog)表数据库访问层
 *
 * @author gaotianchi
 * @since 2024-11-23 18:02:33
 */
@Mapper
public interface ActionLogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return Integer 实例对象
     */
    ActionLog queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param actionLog 查询条件
     * @param pageable  Pageable 分页对象
     * @return List<ActionLog> 对象列表
     */
    List<ActionLog> queryByPage(ActionLog actionLog, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param actionLog 查询条件
     * @return long 总行数
     */
    long count(ActionLog actionLog);

    /**
     * 新增数据
     *
     * @param actionLog 实例对象
     * @return int 影响行数
     */
    int insert(ActionLog actionLog);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ActionLog> 实例对象列表
     * @return int 影响行数
     */
    int insertBatch(@Param("entities") List<ActionLog> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ActionLog> 实例对象列表
     * @return int 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ActionLog> entities);

    /**
     * 修改数据
     *
     * @param actionLog 实例对象
     * @return int 影响行数
     */
    int update(ActionLog actionLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return int 影响行数
     */
    int deleteById(Integer id);
}

