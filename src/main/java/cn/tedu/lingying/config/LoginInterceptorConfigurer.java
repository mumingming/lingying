//package cn.tedu.lingying.config;
//
//import cn.tedu.lingying.interceptor.LoginInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//
///**
// * 登录拦截器的配置类
// */
//@Configuration
//public class LoginInterceptorConfigurer implements WebMvcConfigurer {
//
//	@Override
//	public void addInterceptors(
//			InterceptorRegistry registry) {
//		// 创建拦截器对象
//		HandlerInterceptor interceptor
//			= new LoginInterceptor();
//
//		// 创建白名单
//		List<String> excludePaths = new ArrayList<>();
//		excludePaths.add("/layui/**");
//		excludePaths.add("/css/**");
//		excludePaths.add("/bootstrap3/**");
//		excludePaths.add("/images/**");
//		excludePaths.add("/web/register.html");
//		excludePaths.add("/web/login.html");
//		//excludePaths.add("/web/reg");
//		//excludePaths.add("/web/login");
//
//		// 注册拦截器，并设置黑白名单
//		registry.addInterceptor(interceptor)
//			.addPathPatterns("/**")
//			.excludePathPatterns(excludePaths);
//	}
//
//}
//
//
//
