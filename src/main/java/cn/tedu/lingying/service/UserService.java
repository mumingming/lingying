package cn.tedu.lingying.service;

import cn.tedu.lingying.entity.Admin;
import cn.tedu.lingying.entity.User;
import cn.tedu.lingying.service.ex.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 处理用户数据的业务层接口
 */
public interface UserService {


    /**
     * 注册
     *
     * @param user
     * @throws UsernameDuplicateException
     * @throws InsertException
     */
    void reg(User user) throws UsernameDuplicateException, InsertException;


    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录成功的用户的信息
     * @throws UserNotFoundException     用户数据不存在，例如用户名尚未注册，或用户数据被标记为已删除
     * @throws PasswordNotMatchException 密码错误
     */
    User login(String username, String password)
            throws UserNotFoundException, PasswordNotMatchException, LoginException;

    /**
     * 得到普通用户数据进行展示
     *
     * @return
     */
    List<User> getUser();

    /**
     * 通过id修改改普通用户的权限
     *
     * @return
     */
    Integer updateStatusbyId(@Param("id") Integer id,
                             @Param("status") String status);

    /**
     * 管理员登录
     *
     * @param username   用户账号
     * @param password密码
     * @return 登录成功的用户的信息
     * @throws UserNotFoundException用户数据不存在，例如用户名尚未注册，或用户数据被标记为已删除
     * @throws PasswordNotMatchException密码错误
     */
    Admin denglu(String username, String password)
            throws UserNotFoundException, PasswordNotMatchException;


    /**
     * 根据用户id修改用户状态权限
     *
     * @param id
     * @param status
     * @return
     */
    Integer updateStatus(@Param("id") Integer id,
                         @Param("status") String status);

}
