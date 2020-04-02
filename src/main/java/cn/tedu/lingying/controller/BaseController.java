package cn.tedu.lingying.controller;

import cn.tedu.lingying.controller.ex.*;
import cn.tedu.lingying.service.ex.*;
import cn.tedu.lingying.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;


/**
 * 控制器类的基类
 */
public abstract class BaseController {

    /**
     * 操作结果的“成功”状态
     */
    public static final Integer SUCCESS = 2000;

    /**
     * 从Session中获取当前登录的用户的id
     * @param session
     * @return 当前登录的用户的id
     */
	/*protected final Integer getUidFromSession(HttpSession session) {
		return Integer.valueOf(session.getAttribute("uid").toString());
	}*/

    /**
     * 从Session中获取当前登录的用户名
     *
     * @param session
     * @return 当前登录的用户名
     */
    protected final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }

    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> jr = new JsonResult<>();
        jr.setMessage(e.getMessage());

        if (e instanceof UsernameDuplicateException) {
            // 4000-用户名冲突异常，例如注册时用户名已经被占用
            jr.setState(4000);
        } else if (e instanceof UserNotFoundException) {
            // 4001-用户数据不存在
            jr.setState(4001);
        } else if (e instanceof PasswordNotMatchException) {
            // 4002-验证密码失败
            jr.setState(4002);
        } else if (e instanceof InsertException) {
            // 5000-插入数据异常
            jr.setState(5000);
        } else if (e instanceof UpdateException) {
            // 5001-更新数据异常
            jr.setState(5001);
        } else if (e instanceof FileEmptyException) {
            // 6000-上传的文件为空，例如没有选择要上传的文件，或选择的文件是0字节的
            jr.setState(6000);
        } else if (e instanceof FileSizeException) {
            // 6001-上传的文件大小超出了限制
            jr.setState(6001);
        } else if (e instanceof FileTypeException) {
            // 6002-上传的文件类型超出允许范围
            jr.setState(6002);
        } else if (e instanceof FileUploadStateException) {
            // 6003-上传时文件状态异常，例如上传过程中源文件被移除，导致源文件不再被访问
            jr.setState(6003);
        } else if (e instanceof FileUploadIOException) {
            // 6004-上传文件时读写异常
            jr.setState(6004);
        }

        return jr;
    }

}









