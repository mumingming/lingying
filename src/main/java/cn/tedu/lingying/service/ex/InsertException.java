package cn.tedu.lingying.service.ex;

/**
 * 插入数据异常
 */
public class InsertException extends ServiceException {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1452517938533933732L;

	public InsertException() {
		super();
	}

	public InsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InsertException(String message, Throwable cause) {
		super(message, cause);
	}

	public InsertException(String message) {
		super(message);
	}

	public InsertException(Throwable cause) {
		super(cause);
	}

}
