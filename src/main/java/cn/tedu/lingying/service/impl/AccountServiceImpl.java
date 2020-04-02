package cn.tedu.lingying.service.impl;

import cn.tedu.lingying.entity.Account;
import cn.tedu.lingying.mapper.AccountMapper;
import cn.tedu.lingying.service.AccountService;
import cn.tedu.lingying.service.ex.InsertException;
import cn.tedu.lingying.service.ex.UpdateException;
import cn.tedu.lingying.service.ex.UserNotFoundException;
import cn.tedu.lingying.service.ex.UsernameDuplicateException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {


    @Resource
    private AccountMapper mapper;


    /**
     * 获取列表数据查询
     */
    @Override
    public List<Account> getAllAccount() {

        return mapper.getAll();
    }

    @Override
    public List<Account> getCompany() {
        return mapper.getCompany();
    }


    /**
     * 根据收支类型获取数据列表
     */
    @Override
    public List<Account> findByTypes(String types) {
        System.out.println("类型：" + types);

        return mapper.find(types);
    }


    @Override
    public List<Account> insertkehu(Account account) throws UsernameDuplicateException, InsertException {

        String company = account.getCompany();
        // 根据以上用户名查询用户数据
        Account result = mapper.findbycompany(company);
        // 判断查询结果是否不为null
        if (result != null) {
            throw new UsernameDuplicateException(
                    "注册失败！尝试注册的客户公司名(" + company + ")已经被占用！");
        }
        // 执行注册
        Integer rows = mapper.addlist(account);
        if (rows != 1) {
            throw new InsertException(
                    "注册失败！插入用户数据时出现未知错误！");
        }
        return null;


    }


    /**
     * 模糊查询
     */
    @Override
    public List<Account> findbyall(String company, String starttime, String endtime, String types) {

        return mapper.findall(company, starttime, endtime, types);
    }


    //模糊加分页
    @Override
    public List<Account> listbylimit(String company, String starttime, String endtime, String types, int page,
                                     int limit) {
        page = (page - 1) * limit;
        return mapper.bylimit(company, starttime, endtime, types, page, limit);
    }


    /**
     * 根据ID修改客户信息
     */
    @Override
    public Integer update(Integer id, String company, String starttime, String types, Integer money, String zhifutype,
                          String waiter, String beizhu) throws UpdateException {

        Integer rows = mapper.updatelist(id, company, starttime, types, money, zhifutype, waiter, beizhu);
        if (rows != 1) {
            throw new UpdateException("修改失败，出现未知错我，请重新尝试");
        }
        return rows;
    }


    @Override
    public Account chakanbyid(Integer id) {

        return mapper.findbyid(id);
    }


    /**
     * 查询有多少条数据
     *
     * @return
     */
    @Override
    public Integer selectCounts() {
        return mapper.selectCount();
    }


    @Override
    public void changeAvatar(Integer id, String avatar) throws UserNotFoundException, UpdateException {
        // 根据参数uid查询用户数据
        Account result = mapper.findbyid(id);
        // 判断查询结果是否为null
        if (result == null) {
            // 抛出：UserNotFoundException
            throw new UserNotFoundException(
                    "上传头像失败！用户名不存在！");
        }
        // 执行更新头像，并获取返回的受影响的行数
        Integer rows = mapper.updateAvatar(id, avatar);
        // 判断受影响的行数是否不为1
        if (rows != 1) {
            // 抛出：UpdateException
            throw new UpdateException(
                    "上传头像失败！上传头像时出现未知错误，请重新尝试！");
        }

    }


}
