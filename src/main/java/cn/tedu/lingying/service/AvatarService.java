package cn.tedu.lingying.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tedu.lingying.entity.Admin;
import cn.tedu.lingying.entity.Avatar;
import cn.tedu.lingying.entity.User;
import cn.tedu.lingying.service.ex.InsertException;
import cn.tedu.lingying.service.ex.PasswordNotMatchException;
import cn.tedu.lingying.service.ex.UserNotFoundException;
import cn.tedu.lingying.service.ex.UsernameDuplicateException;


/**
 * 处理用户数据的业务层接口
 */
public interface  AvatarService {

	
	
	
	
	
	/**
	 * 插入图片
	 * @param uid 
	 * @param user
	 * @throws UsernameDuplicateException
	 * @throws InsertException
	 */

	Integer insert(String address,String cpname);
	
	
	
	/**
	 * 查询图片
	 * @param cpname
	 * @return
	 */
	List<Avatar> findbycpname(String cpname);
	
	
	
	/**
	 * 通过图片地址删除对应的图片
	 * @param address
	 * @return
	 */
	Integer deletebyaddress(String address);
	
	
	
	
	
	
}
