package com.gaotianchi.auth.service;

import com.gaotianchi.auth.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * 用户表(User)表服务接口
 *
 * @author gaotianchi
 * @since 2024-11-23 19:41:37
 */
public interface UserService extends UserDetailsService {

    /**
     * 通过用户名查询用户
     *
     * @param username username
     * @return com.gaotianchi.auth.entity.User
     * @author gaotianchi
     * @since 2024/11/24 12:35
     **/
    User queryByUsername(String username);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Integer id);

    /**
     * 分页查询
     *
     * @param user        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<User> queryByPage(User user, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
