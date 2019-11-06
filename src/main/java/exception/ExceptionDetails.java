package exception;

import java.util.Date;

public class ExceptionDetails {
	private Date date;
	
	
	
	public ExceptionDetails(Date date, String message, String details) {
		super();
		this.date = date;
		this.message = message;
		this.details = details;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	private String message;
	
	
	private String details;
}
