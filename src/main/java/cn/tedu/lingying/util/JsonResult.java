package cn.tedu.lingying.util;


/**
 * 向客户端响应操作结果的数据类型
 * 
 * @param <T> 向客户端响应的数据的类型
 */
public class JsonResult<T> {

	private Integer state;
	private String message;
	private T data;
	private int count;
	private String msg;
	
	

	public JsonResult(Integer state, String msg) {
		this.state = state;
		this.msg = msg;
	}





	public JsonResult(Integer state, T data, int count) {
		this.state = state;
		this.data = data;
		this.count = count;
	}
	
	

	

	public JsonResult(Integer state, T data, int count, String msg) {
		this.state = state;
		this.data = data;
		this.count = count;
		this.msg = msg;
	}





	public JsonResult(Integer state, T data, String msg) {
		this.state = state;
		this.data = data;
		this.msg = msg;
	}





	public JsonResult(String msg) {
		this.msg = msg;
	}





	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	public JsonResult() {
		super();
	}

	public JsonResult(Integer state) {
		super();
		this.state = state;
	}

	public JsonResult(Integer state, T data) {
		super();
		this.state = state;
		this.data = data;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
