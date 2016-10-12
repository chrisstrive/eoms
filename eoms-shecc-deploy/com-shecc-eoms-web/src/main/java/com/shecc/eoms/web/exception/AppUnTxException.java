package com.shecc.eoms.web.exception;

public class AppUnTxException extends AbstractException{
	private static final long serialVersionUID = 4306833053683004022L;

	public AppUnTxException() {
        super();
    }

    public AppUnTxException(String message) {
        super(message);
    }

    public AppUnTxException(Throwable cause) {
        super(cause);
    }

    public AppUnTxException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppUnTxException(String message,Object... arguments) {
        super(message);
        this.arguments=arguments;
    }
}
