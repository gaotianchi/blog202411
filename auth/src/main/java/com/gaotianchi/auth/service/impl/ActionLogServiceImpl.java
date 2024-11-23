package com.gaotianchi.auth.service.impl;

import com.gaotianchi.auth.model.entity.ActionLog;
import com.gaotianchi.auth.dao.ActionLogDao;
import com.gaotianchi.auth.service.ActionLogService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;


/**
 * 用户行为日志(ActionLog)表服务实现类
 *
 * @author gaotianchi
 * @since 2024-11-23 17:48:23
 */
@Service("actionLogService")
public class ActionLogServiceImpl implements ActionLogService {

    private final ActionLogDao actionLogDao;

    public ActionLogServiceImpl(ActionLogDao actionLogDao) {
        this.actionLogDao = actionLogDao;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return ActionLog 实例对象
     */
    @Override
    public ActionLog queryById(Integer id) {
        return actionLogDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param actionLog   筛选条件
     * @param pageRequest 分页对象
     * @return Page<ActionLog> 查询结果
     */
    @Override
    public Page<ActionLog> queryByPage(ActionLog actionLog, PageRequest pageRequest) {
        long total = actionLogDao.count(actionLog);
        return new PageImpl<>(actionLogDao.queryByPage(actionLog, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param actionLog 实例对象
     * @return ActionLog 实例对象
     */
    @Override
    public ActionLog insert(ActionLog actionLog) {
        actionLogDao.insert(actionLog);
        return actionLog;
    }

    /**
     * 修改数据
     *
     * @param actionLog 实例对象
     * @return ActionLog 实例对象
     */
    @Override
    public ActionLog update(ActionLog actionLog) {
        actionLogDao.update(actionLog);
        return queryById(actionLog.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return boolean 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return actionLogDao.deleteById(id) > 0;
    }
}
