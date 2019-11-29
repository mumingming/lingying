package cn.tedu.lingying.service.ex;

/**
 * 登录验证未审批提示
 */
public class LoginException  extends ServiceException {

    public LoginException() {
        super();
    }

    public LoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginException(String message) {
        super(message);
    }

    public LoginException(Throwable cause) {
        super(cause);
    }
}
