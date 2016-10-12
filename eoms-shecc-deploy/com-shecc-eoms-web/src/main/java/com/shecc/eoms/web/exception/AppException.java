package com.shecc.eoms.web.exception;

public class AppException extends AbstractException{
	private static final long serialVersionUID = -6284445529172952686L;

	public AppException() {
        super();
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(Throwable cause) {
        super(cause);
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(String message,Object... arguments) {
        super(message);
        this.arguments=arguments;
    }

}
