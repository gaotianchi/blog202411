package com.gaotianchi.auth.service;

import com.gaotianchi.auth.entity.ActionLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 用户行为日志(ActionLog)表服务接口
 *
 * @author gaotianchi
 * @since 2024-11-23 18:02:34
 */
public interface ActionLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ActionLog queryById(Integer id);

    /**
     * 分页查询
     *
     * @param actionLog   筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<ActionLog> queryByPage(ActionLog actionLog, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param actionLog 实例对象
     * @return 实例对象
     */
    ActionLog insert(ActionLog actionLog);

    /**
     * 修改数据
     *
     * @param actionLog 实例对象
     * @return 实例对象
     */
    ActionLog update(ActionLog actionLog);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
