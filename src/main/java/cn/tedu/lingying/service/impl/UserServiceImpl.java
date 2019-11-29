package cn.tedu.lingying.service.impl;

import cn.tedu.lingying.entity.Admin;
import cn.tedu.lingying.entity.User;
import cn.tedu.lingying.mapper.UserMapper;
import cn.tedu.lingying.service.UserService;
import cn.tedu.lingying.service.ex.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper mapper;
	
	
	
	

	@Override
	public void reg(User user) throws UsernameDuplicateException, InsertException {
	    // 根据参数user中的getUsername()获取尝试注册的用户名
	    String username = user.getUsername();
	    // 根据以上用户名查询用户数据
	    User result = mapper.findByUsername(username);
	    // 判断查询结果是否不为null
	    if (result != null) {
	        // 是：用户名已经被占用，抛出UsernameDuplicateException
	        throw new UsernameDuplicateException(
	            "注册失败！尝试注册的用户名(" + username + ")已经被占用！");
	    }
	    // 执行注册
	    Integer rows = mapper.insert(user);
	  if (rows != 1) {
	        throw new InsertException(
	            "注册失败！插入用户数据时出现未知错误！");
	    }
	}
	

	@Override
	public User login(String username, String password) throws UserNotFoundException, PasswordNotMatchException, LoginException {
		
				User result = mapper.findByUsername(username);
				// 判断查询结果是否为null
				if (result == null) {
					throw new UserNotFoundException(
						"登录失败！用户名不存在！");
				}
				if (!result.getPassword().equals(password)) {
					throw new PasswordNotMatchException(
						"登录失败！密码错误！");
				}

                if (!result.getStatus().equals("通过")) {
                    throw new LoginException(
                    "未经授权登录失败！");
                }

				// 密码错误将查询结果中的password设置为null
				result.setPassword(null);
				return result;
	}

	/**
	 * 获取用户表里边全部数据
	 * @return
	 */
	@Override
	public List<User> getUser() {

		return mapper.getAllUser();
	}

	/**
	 * 通过id修改改普通用户的权限
	 * @return
	 */
	@Override
	public Integer updateStatusbyId(Integer id, String status) {
		return mapper.updateStatus(id,status);
	}


	@Override
	public Admin denglu(String username, String password) throws UserNotFoundException, PasswordNotMatchException {
		Admin result = mapper.findByAdminname(username);
		// 判断查询结果是否为null
		if (result == null) {
			throw new UserNotFoundException(
				"登录失败！用户名不存在！");
		}
		if (!result.getPassword().equals(password)) {
			throw new PasswordNotMatchException(
				"登录失败！密码错误！");
		}
		// 密码错误将查询结果中的password设置为null
		result.setPassword(null);
		return result;
	}


	/**
	 * 根据用户id修改登录权限
	 * @param id
	 * @param status
	 * @return
	 */
	@Override
	public Integer updateStatus(Integer id, String status) {
		return mapper.updateStatus(id,status);
	}


}
