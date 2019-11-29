package cn.tedu.lingying.service;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tedu.lingying.entity.User;
import cn.tedu.lingying.service.ex.ServiceException;

import javax.annotation.Resource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

	@Resource
	private UserService service;
	
	
	@Test
	public void login() {
		try {
			String username = "root";
			String password = "1234";
			User user = service.login(username, password);
			System.err.println(user);
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
	
	
	
	 @Test
	    public void reg() {
	        try {
	            User user = new User();
	            user.setUsername("Service");
	            user.setPassword("1234");
	            service.reg(user);
	            System.err.println("OK");
	        } catch (ServiceException e) {
	            System.err.println(e.getClass().getName());
	            System.err.println(e.getMessage());
	        }
	    }


	    @Test
	    public void updatebystatus(){
			Integer id = 2;
			String status = "007";
			Integer rows = service.updateStatusbyId(id,status );
			System.err.println(rows);
		}
	
	
	
	
	
	
}
