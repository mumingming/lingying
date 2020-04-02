package cn.tedu.lingying.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mysql.cj.xdevapi.Result;

import cn.tedu.lingying.entity.Account;
import cn.tedu.lingying.entity.User;
import cn.tedu.lingying.service.ex.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTests {


    @Autowired
    private AccountService service;


    @Test
    public void getAllAccount() {
        List<Account> list = service.getAllAccount();
        System.err.println("BEGIN:");
        for (Account item : list) {
            System.err.println(item);
        }
        System.err.println("END.");
    }


    @Test
    public void findByTypes() {
        String types = "收入";
        List<Account> find = service.findByTypes(types);
        System.err.println("开始1:");
        for (Account item : find) {
            System.err.println(item);
        }
        System.err.println("结束1：");
    }


    @Test
    public void findall() {
        String company = null;
        String starttime = "2018-09-20 13:38:19";
        String endtime = "2019-09-00 13:38:19";
        String types = "收入";
        int page = 0;
        int limit = 0;
        List<Account> find = service.listbylimit(company, starttime, endtime, types, page, limit);
        System.err.println("开始1:");
        for (Account item : find) {
            System.err.println(item);
        }
        System.err.println("结束1.");


    }


    @Test
    public void insertkehu() {
        try {
            Account account = new Account();
            account.setCompany("饿了吗");
            account.setTypes("收入");
            account.setMoney(1800);

            service.insertkehu(account);
            System.err.println("OK");
        } catch (ServiceException e) {
            System.err.println(e.getClass().getName());
            System.err.println(e.getMessage());
        }
    }


    /**
     * 附件根据用户ID查看数据详情
     */
    @Test
    public void chakan() {

        Integer id = 1;
        Account data = service.chakanbyid(id);
        System.err.println(data);
    }


    /**
     * 上传头像
     */
    @Test
    public void changeAvatar() {
        try {
            Integer id = 1;
            String avatar = "这是一个新头像的路径";
            service.changeAvatar(id, avatar);
            System.err.println("OK.");
        } catch (ServiceException e) {
            System.err.println(e.getClass().getName());
            System.err.println(e.getMessage());
        }
    }


}
