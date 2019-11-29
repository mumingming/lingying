package cn.tedu.lingying.controller.ex;

public class FileUploadException extends RuntimeException{
	
	/**
	 * 上传文件的异常的基类
	 */
	private static final long serialVersionUID = 908573164289047314L;
	
	public FileUploadException() {
		super();
	}

	public FileUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileUploadException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileUploadException(String message) {
		super(message);
	}

	public FileUploadException(Throwable cause) {
		super(cause);
	}
	

}
