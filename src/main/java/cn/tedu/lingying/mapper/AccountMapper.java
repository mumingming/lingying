package cn.tedu.lingying.mapper;

import cn.tedu.lingying.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {


    /**
     * 查询所有数据进行列表展示
     *
     * @return
     */
    List<Account> getAll();


    /**
     * 得到所有公司名字
     *
     * @return
     */
    List<Account> getCompany();


    /**
     * 根据收支类型 搜索
     *
     * @param map
     * @return
     */
    /* List<Account> find(Map<String,String> map);
     */

    List<Account> find(String types);


    /**
     * 模糊查询
     *
     * @return
     */
    List<Account> findall(
            @Param("company") String company,
            @Param("starttime") String starttime,
            @Param("endtime") String endtime,
            @Param("types") String types
    );


    /**
     * 模糊查询加分页
     *
     * @param company
     * @param starttime
     * @param endtime
     * @param types
     * @param page      当前页数
     * @param limit     显示条数
     * @return
     */
    List<Account> bylimit(
            @Param("company") String company,
            @Param("starttime") String starttime,
            @Param("endtime") String endtime,
            @Param("types") String types,
            @Param("page") int page,
            @Param("limit") int limit
    );


    /**
     * 用户数据添加（保存）
     *
     * @param account
     * @return
     */
    Integer addlist(Account account);

    //根据公司名字查询数据
    Account findbycompany(String company);


    /**
     * 附件根据ID更改用户信息
     *
     * @param id
     * @param company
     * @param starttime
     * @param types
     * @param money
     * @param zhifutype
     * @param waiter
     * @param beizhu
     * @return
     */
    Integer updatelist(
            @Param("id") Integer id
            , @Param("company") String company
            , @Param("starttime") String starttime
            , @Param("types") String types
            , @Param("money") Integer money
            , @Param("zhifutype") String zhifutype
            , @Param("waiter") String waiter
            , @Param("beizhu") String beizhu

    );


    /**
     * 附件通过ID 查看数据详情
     *
     * @param id
     * @return
     */
    Account findbyid(Integer id);


    /**
     * 查询有多少条数据
     *
     * @return
     */
    Integer selectCount();


    /**
     * 修改用户头像
     *
     * @param id
     * @param avatar
     * @return
     */
    Integer updateAvatar(
            @Param("id") Integer id,
            @Param("avatar") String avatar);


}
