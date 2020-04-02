package cn.tedu.lingying.mapper;

import cn.tedu.lingying.entity.Admin;
import cn.tedu.lingying.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {


    @Resource
    private UserMapper mapper;


    @Test
    public void addnew() {
        User user = new User();
        user.setUsername("root00011");
        user.setPassword("12345");
        System.err.println(user);
        Integer rows = mapper.insert(user);
        Integer id = user.getId();
        System.err.println(user);
        System.err.println(id);
    }


    /**
     * 普通用户根据用户名查询
     */
    @Test
    public void findByUsername() {
        String username = "王二";
        User user = mapper.findByUsername(username);
        System.err.println(user);
    }

    /**
     * 查找全部用户
     */
    @Test
    public void findAllUser() {
        List<User> list = mapper.getAllUser();
        for (User item : list) {
            System.err.println(item);
        }
    }


    /**
     * 修改用户身份权限
     */
    @Test
    public void updateStatus() {
        Integer id = 2;
        String status = "通过";
        Integer rows = mapper.updateStatus(id, status);
        System.err.println(rows);
    }


    /**
     * 管理员信息查询
     */
    @Test
    public void findByAdminname() {
        String username = "1";
        Admin admin = mapper.findByAdminname(username);
        System.err.println(admin);
    }

}
