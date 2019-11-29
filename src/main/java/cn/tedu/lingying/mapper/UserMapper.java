package cn.tedu.lingying.mapper;

import cn.tedu.lingying.entity.Admin;
import cn.tedu.lingying.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
	
	
	/**
	 * 添加
	 * @param user
	 * @return
	 */
	
	Integer insert(User user);
	
	
	
	/**
	 * 根据用户名查询用户数据
	 * @param username 用户名
	 * @return 匹配的用户数据，如果没有匹配的数据，则返回null
	 */
	User findByUsername(String username);

	/**
	 * 查找所有用户并展示出来
	 * @return 返回查找到的数据。
	 */
	List<User> getAllUser();
	
	/**
	 * 根据用户名查询管理员用户数据
	 * @param username 账户名
	 * @return 匹配的用户数据，如果没有匹配的数据，则返回null
	 */
	Admin findByAdminname(String username);


	/**
	 * x修改用户权限身份
	 * @param status
	 * @return
	 */
	Integer updateStatus(@Param("id") Integer id,
						 @Param("status") String status);





}
