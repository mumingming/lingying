package cn.tedu.lingying.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import cn.tedu.lingying.entity.Account;
import cn.tedu.lingying.service.ex.InsertException;
import cn.tedu.lingying.service.ex.UpdateException;
import cn.tedu.lingying.service.ex.UserNotFoundException;
import cn.tedu.lingying.service.ex.UsernameDuplicateException;

@Service
public interface AccountService {
	
	
	/**
	 * 查询所有数据
	 * @return 返回得到的全部数据
	 */
	List<Account> getAllAccount();
	
	/**
	 * 得到所有公司名字
	 * @return
	 */
	List<Account> getCompany();
	
	
	
	
	/**
	 * 根据收支类型获取数据列表
	 * @param types 收支类型
	 * @return
	 */
	List<Account> findByTypes(String types);
	
	
	
	
	
	/**
	 * 插入客户数据（保存数据）
	 * @param account
	 * @return
	 */
	List<Account> insertkehu(Account account)throws UsernameDuplicateException, InsertException;
	
	
	
	/**
	 * 模糊查询
	 * @param company 公司名字
	 * @param starttime 开始时间
	 * @param endtime 结束时间
	 * @param types 收支类型
	 * @return 返回查询到的数据
	 */
	List<Account> findbyall(
			@Param("company") String company,
			@Param("starttime") String starttime,
			@Param("endtime") String endtime,
			@Param("types") String types
			);
	
	
	
	/**
	 * 模糊查询加分页
	 * @param company
	 * @param starttime
	 * @param endtime
	 * @param types
	 * @param page 当前页数
	 * @param limit 显示条数
	 * @return
	 */
	List<Account> listbylimit(
			@Param("company") String company,
			@Param("starttime") String starttime,
			@Param("endtime") String endtime,
			@Param("types") String types,
			@Param("page") int page, 
			@Param("limit") int limit
			);
	
	
	
	/**
	 * 根据ID修改客户信息
	 * @param id
	 * @param company
	 * @param starttime
	 * @param types
	 * @param money
	 * @param zhifutype
	 * @param waiter
	 * @param beizhu
	 * @return
	 * @throws UpdateException
	 */
	Integer update(
			@Param("id") Integer id
			,@Param("company") String company
			,@Param("starttime") String starttime
			,@Param("types") String types
			,@Param("money") Integer money
			,@Param("zhifutype") String zhifutype
			,@Param("waiter") String waiter
			,@Param("beizhu") String beizhu
			
			) throws UpdateException;
	
	
	
	
	/**
	 * 附件通过ID 查看数据详情
	 * @param ID
	 * @return
	 */
	Account chakanbyid(Integer id); 
	
	
	
	/**
	 * 查询有多少条数据
	 * @return
	 */
	Integer selectCounts();

	
	
	
	
	
	/**
	 * 上传修改图片
	 * @param id
	 * @param username
	 * @param avatar
	 * @throws UserNotFoundException 找不到地址
	 * @throws UpdateException上传图片失败
	 */
	void changeAvatar(Integer id,  String avatar) 
		    throws UserNotFoundException, UpdateException;
	
	

}
