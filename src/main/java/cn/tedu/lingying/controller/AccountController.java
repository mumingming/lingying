package cn.tedu.lingying.controller;

import cn.tedu.lingying.entity.Account;
import cn.tedu.lingying.service.AccountService;
import cn.tedu.lingying.service.ex.UpdateException;
import cn.tedu.lingying.util.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController

public class AccountController extends BaseController {


    @Resource
    private AccountService service;


    //得到全部数据sss
    @RequestMapping(value = ("/web/getall"), method = RequestMethod.GET)
    public JsonResult<List<Account>> getAllAccount() {
        // 调用业务层对象获取数据
        List<Account> data = service.getAllAccount();
        // 返回
        return new JsonResult<>(SUCCESS, data);
    }


    //得到公司数据
    @RequestMapping(value = ("/web/company"), method = RequestMethod.GET)
    public JsonResult<List<Account>> getCompany() {
        // 调用业务层对象获取数据
        List<Account> data = service.getCompany();
        // 返回
        return new JsonResult<>(SUCCESS, data);
    }


    //根据收支类型查询
    @RequestMapping(value = ("/web/types"), method = RequestMethod.GET)
    public JsonResult<List<Account>> getByTypes(String types) {

        // 调用业务层对象获取数据
        List<Account> data = service.findByTypes(types);

        // 返回
        return new JsonResult<>(SUCCESS, data);
    }


    @RequestMapping("/web/add")
    public JsonResult<Void> insertkehu(Account account) {
        System.out.println("注册");
        // 执行注册
        service.insertkehu(account);
        // 响应操作成功
        return new JsonResult<Void>(SUCCESS);
    }


    @RequestMapping(value = ("/web/mohu"), method = RequestMethod.GET)
    public JsonResult<List<Account>> findbyall(
            @Param("company") String company,
            @Param("starttime") String starttime,
            @Param("endtime") String endtime,
            @Param("types") String types
    ) {

        // 调用业务层对象获取数据
        List<Account> data = service.findbyall(company, starttime, endtime, types);

        // 返回
        return new JsonResult<>(SUCCESS, data);
    }


    //模糊加分页
    @RequestMapping(value = ("/web/limit"), method = RequestMethod.GET)
    public JsonResult<List<Account>> listbylimit(
            @Param("company") String company,
            @Param("starttime") String starttime,
            @Param("endtime") String endtime,
            @Param("types") String types,
            @Param("page") int page,
            @Param("limit") int limit
    ) {
        // 调用业务层对象获取数据   模糊查询加分页
        List<Account> data = service.listbylimit(company, starttime, endtime, types, page, limit);
        //查询数据总数量
        Integer count = service.selectCounts();
        //调用下边方法进行合计计算
        String msg = Heji(data);
        System.err.println(msg);
        //System.err.println(count);
        // 返回
        //return new JsonResult<>(SUCCESS,data,count);
        return new JsonResult<>(SUCCESS, data, count, msg);
    }
	
	/*//模糊加分页
		@RequestMapping(value=("/web/limit"),method = RequestMethod.GET)
		public JsonResult<List<Account>> listbylimit(
				@Param("company") String company,
				@Param("starttime") String starttime,
				@Param("endtime") String endtime,
				@Param("types") String types,
				@Param("page") int page, 
				@Param("limit") int limit
				) {
			
			if((company!=null & company!="" ) || (starttime!=null & starttime!="") 
					|| ( endtime!=null & endtime!="") || ( types!=null & types!="")) {

				// 调用业务层对象获取数据   模糊查询加分页
				List<Account> data = service.listbylimit(company, starttime, endtime, types, page, limit);
				//查询数据总数量
				Integer count = service.selectCounts();
				//调用下边方法进行合计计算
				String msg = Heji(data);
				System.err.println(msg);
				//System.err.println(count);
				// 返回
				//return new JsonResult<>(SUCCESS,data,count);
				return new JsonResult<>(SUCCESS,data,count,msg);
				
			}else {
				List<Account> data = service.listbylimit(company, starttime, endtime, types, page, limit);
				//查询数据总数量
				Integer count = service.selectCounts();
				//调用下边方法进行合计计算
				String msg = Heji(data);
				System.err.println(msg);
				//System.err.println(count);
				// 返回
				//return new JsonResult<>(SUCCESS,data,count);
				return new JsonResult<>(SUCCESS,data,count,msg);
			}
			
			
		}
	*/


    @RequestMapping("/web/update")
    public JsonResult<Void> update(
            @Param("id") Integer id
            , @Param("company") String company
            , @Param("starttime") String starttime
            , @Param("types") String types
            , @Param("money") Integer money
            , @Param("zhifutype") String zhifutype
            , @Param("waiter") String waiter
            , @Param("beizhu") String beizhu

    ) throws UpdateException {

        // 执行注册
        service.update(id, company, starttime, types, money, zhifutype, waiter, beizhu);
        // 响应操作成功
        return new JsonResult<Void>(SUCCESS);
    }


    /**
     * 附件根据用户ID查看该用户数据详情
     *
     * @param
     * @return
     */
    @RequestMapping(value = ("/web/chakan"), method = RequestMethod.GET)
    public JsonResult<Account> chakanbyid(Integer id) {

        // 调用业务层对象获取数据
        Account data = service.chakanbyid(id);

        // 返回
        return new JsonResult<>(SUCCESS, data);
    }


    /**
     * 查询有多少条数据
     *
     * @param <T>
     * @return
     */
    @RequestMapping(value = ("/web/count"), method = RequestMethod.GET)
    public JsonResult<Object> selectCounts() {
        // 调用业务层对象获取数据
        Integer count = service.selectCounts();
        // 返回
        return new JsonResult<>(SUCCESS, count);
    }


    //计算总计
    @RequestMapping(value = ("/web/total"), method = RequestMethod.GET)
    public JsonResult<Object> total(String types) {
        List<Account> data = service.findByTypes(types);
        //List<Account> data = service.getAllAccount();
        String msg = Heji(data);
        int count = 0;
        return new JsonResult<>(SUCCESS, data, msg);
    }


    private String Heji(List<Account> data) {
        Integer shouru = 0;
        Integer zhichu = 0;
        Integer total = 0;
        try {
            for (Account account : data) {
                if ("支出".equals(account.getTypes())) {
                    int zhi = Integer.valueOf(account.getMoney());
                    System.err.println(zhi);
                    zhichu = zhi + zhichu;
                } else {
                    int shou = Integer.valueOf(account.getMoney());
                    System.err.println(shou);
                    shouru = shouru + shou;
                }

                total = shouru - zhichu;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String msg = " 总收入:  " + shouru + "元" + "     —" + "      总支出: " + zhichu + "元" + "     =" + "    合计:   " + total + "元";


        return msg;
    }
	
	
	
	/*@RequestMapping(value=("/web/heji"),method = RequestMethod.GET)
	public  JsonResult<Object> hi(List<Account> data){
		List<Account> data1 = service.getAllAccount();
		Integer shouru = 0;
		Integer zhichu = 0;
		Integer total = 0;
		try {
			for (Account account : data1) {
				if("支出".equals(account.getTypes())){
					int zhi = Integer.valueOf(account.getMoney());
					System.err.println(zhi);
					zhichu = zhi+zhichu;
				}else{
					int shou= Integer.valueOf(account.getMoney());
					System.err.println(shou);
					shouru = shouru +shou;
				}
			
			total = shouru - zhichu;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String msg ="  收入: "+shouru+"元"+"   —"+ "    支出: "+zhichu+"元"+"   ="+"   合计: "+total+"元";
		
		
		
		return new JsonResult<>(SUCCESS,data1,msg);
		
		
	}*/


}
