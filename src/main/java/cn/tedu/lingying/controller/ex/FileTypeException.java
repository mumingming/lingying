package cn.tedu.lingying.controller.ex;

/**
 * 上传的文件类型超出允许范围
 */
public class FileTypeException extends FileUploadException {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2592928448135718082L;

	public FileTypeException() {
		super();
	}

	public FileTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileTypeException(String message) {
		super(message);
	}

	public FileTypeException(Throwable cause) {
		super(cause);
	}

}
