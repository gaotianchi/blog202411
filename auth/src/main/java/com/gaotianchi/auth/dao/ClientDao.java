package com.gaotianchi.auth.dao;

import com.gaotianchi.auth.entity.Client;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 客户端表(Client)表数据库访问层
 *
 * @author gaotianchi
 * @since 2024-11-25 13:13:05
 */
@Mapper
public interface ClientDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return Integer 实例对象
     */
    Client selectById(Integer id);

    /**
     * query client by clientId
     * @author gaotianchi
     * @since 2024/11/25 19:58
     * @param clientId clientId
     * @return com.gaotianchi.auth.entity.Client
     **/
    Client selectByClientId(String clientId);

    /**
     * 查询指定行数据
     *
     * @param client   查询条件
     * @param pageable Pageable 分页对象
     * @return List<Client> 对象列表
     */
    List<Client> selectByPage(Client client, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param client 查询条件
     * @return long 总行数
     */
    long count(Client client);

    /**
     * 新增数据
     *
     * @param client 实例对象
     * @return int 影响行数
     */
    int insert(Client client);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Client> 实例对象列表
     * @return int 影响行数
     */
    int insertBatch(@Param("entities") List<Client> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Client> 实例对象列表
     * @return int 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Client> entities);

    /**
     * 修改数据
     *
     * @param client 实例对象
     * @return int 影响行数
     */
    int update(Client client);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return int 影响行数
     */
    int deleteById(Integer id);
}

