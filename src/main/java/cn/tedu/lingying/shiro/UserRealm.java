//package cn.tedu.lingying.shiro;
//
//
//import cn.tedu.lingying.entity.User;
//import cn.tedu.lingying.mapper.UserMapper;
//import cn.tedu.lingying.service.UserService;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.subject.Subject;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.annotation.Resource;
//
//;
//
//
///**
// * 自定义Realm
// * @author lenovo
// *
// */
//public class UserRealm extends AuthorizingRealm {
//
//	@Resource
//	private UserMapper mapper;
//
//	/**
//	 * 执行授权逻辑
//	 */
//	@Override
//	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
//		System.out.println("执行授权逻辑");
//
//		//给资源进行授权
//		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//
//		//添加资源的授权字符串
//		//info.addStringPermission("user:add");
//
//		//到数据库查询当前登录用户的授权字符串
//		//获取当前登录用户
//		Subject subject = SecurityUtils.getSubject();
//		User user = (User)subject.getPrincipal();
////		User dbUser = userSerivce.findById(user.getId());//根据id获取用户信息
////
////		info.addStringPermission(dbUser.getPerms());//得到该用户的权限是啥   然后放行
//
//		return info;
//	}
//
//	@Autowired
//	private UserService userSerivce;
//
//	/**
//	 * 执行认证逻辑
//	 */
//	@Override
//	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
//		System.out.println("执行认证逻辑");
//
//		//编写shiro判断逻辑，判断用户名和密码
//		//1.判断用户名
//		UsernamePasswordToken token = (UsernamePasswordToken)arg0;
//
//		User user = mapper.findByUsername(token.getUsername());
//
//		if(user==null){
//			//用户名不存在
//			return null;//shiro底层会抛出UnKnowAccountException
//		}
//
//		//2.判断密码
//		return new SimpleAuthenticationInfo(user,user.getPassword(),"");
//	}
//
//}