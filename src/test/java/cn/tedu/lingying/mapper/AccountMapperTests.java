package cn.tedu.lingying.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.lingying.entity.Account;
import cn.tedu.lingying.entity.User;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountMapperTests {
	
	@Resource
	private AccountMapper mapper;
	
	
	
	
	@Test
	public void getall() {
		List<Account> list = mapper.getAll();
		System.err.println("BEGIN:");
		for (Account item : list) {
			System.err.println(item);
		}
		System.err.println("END.");
	}
	
	
	
	//收支类型查询
	@Test
	public void findgetall() {
		Account account = new Account();
		//account.setTypes("shouru");
		String types = "收入";
		
		List<Account> find = mapper.find(types);
		 System.err.println("开始:");
			for (Account item : find) {
				System.err.println(item);
			}
			System.err.println("结束.");
		 
		 
	}
	
	
	
	
	//模糊查询
	@Test
	public void findall() {
//		Account account = new Account();
//		account.setTypes("收入");
//		account.setUsername("李白");
//		account.setStarttime(null);
//		account.setEndtime(null);
		
		String company =null;
		String starttime=null;
		String endtime="2019-09-10 13:38:19";
		String types = "收入";
		
		List<Account> find = mapper.findall(company, starttime, endtime, types);
		 System.err.println("开始1:");
			for (Account item : find) {
				System.err.println(item);
			}
			System.err.println("结束1.");
		 
		 
	}
	
	
	//模糊加分页
		@Test
		public void bylimit() {
			String company =null;
			String starttime=null;
			String endtime=null;
			String types =null;
			int page = 3;
			int limit =10;
			
			List<Account> find = mapper.bylimit(company, starttime, endtime, types, page, limit);
			 System.err.println("开始2:");
				for (Account item : find) {
					System.err.println(item);
				}
				System.err.println("结束2");
			 
			 
		}
	
	
	
	
	
	
	@Test
    public void addnew() {
       Account account = new Account();
       account.setCompany("唐僧");
       account.setStarttime("1998-07-07");
       account.setTypes("收入");
       account.setMoney(1080);
       account.setZhifutype("微信");
       account.setWaiter("三藏");
       account.setBeizhu("唐僧骑马咚那个咚");
       
       
        System.err.println(account);
        Integer rows = mapper.addlist(account);
		System.err.println("rows=" + rows);
    }
	
	@Test
	public void findByUsername() {
		String company = "领英";
		Account account = mapper.findbycompany(company);
		System.err.println(account);
	}
	
	
	/**
	 * 通过ID修改客户信息
	 */
	@Test
	public void updatelist() {
		Integer id = 26;
		String company ="麒麟1";
		String starttime = "2015-05-20";
		String types = "支出";
		Integer money = 5400;
		String zhifutype = "微信";
		String waiter = "小林";
		String beizhu = "啦啦啦啦啦";
		
		System.err.println("开始测试");
		Integer rows = mapper.updatelist(id, company, starttime, types, money, zhifutype, waiter, beizhu);
		System.err.println(rows);
		
	}
	
	
	/**
	 * 查询有多少条数据
	 */
	@Test
	public void selectCount(){
		Integer rows = mapper.selectCount();
		
		System.err.println("数量"+rows);
	}
	
	
	//修改头像
	@Test
	public void updateAvatar(){
		Integer id = 1;
		String avatar = "这是个头像";
		Integer rows = mapper.updateAvatar(id, avatar);
		
		System.err.println("数量"+rows);
	}
	
	
	

}
