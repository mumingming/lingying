package cn.tedu.lingying.controller;

import cn.tedu.lingying.entity.User;
import cn.tedu.lingying.service.UserService;
import cn.tedu.lingying.util.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 处理用户数据相关请求的控制器类
 */
@RestController
public class UserController extends BaseController {

	@Resource
	private UserService userService;
	
	@RequestMapping("/web/reg")
	public JsonResult<Void> reg(User user) {
		System.out.println("注册");
		// 执行注册
		userService.reg(user);
		// 响应操作成功
		return new JsonResult<Void>(SUCCESS);
	}

	@RequestMapping("/web/login")
	public JsonResult<User> login(
		String username, String password,
		HttpSession session) {
		System.out.println("进入");
		// 执行登录，获取登录返回结果
		User user = userService.login(username, password);
		// 向Session中封装数据
		session.setAttribute("id", user.getId());
		session.setAttribute("username", user.getUsername());
		// 向客户端响应操作成功
		return new JsonResult<>(SUCCESS, user);
	}

	/**
	 * 获取普通用户列表
	 * @return
	 */
	@RequestMapping("/web/getuser")
	public JsonResult<List<User>> getUser(){
	    //User user = new User();
		List<User> data = userService.getUser();

		return new JsonResult<>(SUCCESS,data);
	}


	/**
	 * 根据用户id修改权限
	 * @param id
	 * @param status
	 * @return
	 */
	@RequestMapping("/status")
	public JsonResult<Void> updateStatus(@Param("id") Integer id,
										@Param("status") String status){

		userService.updateStatus(id,status);

		return new JsonResult<Void>(SUCCESS);
	}



}