package cn.tedu.lingying.service.ex;

/**
 * 业务异常，是业务层抛出的异常的基类
 */
public class ServiceException extends RuntimeException {


    /**
     *
     */
    private static final long serialVersionUID = -595905878545800731L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

}
