package com.shecc.eoms.web.exception;

public abstract class AbstractException extends Exception {
	private static final long serialVersionUID = -2184047757819573417L;
	protected Object[] arguments;

    public AbstractException() {
        super();
    }

    public AbstractException(String message) {
        super(message);
    }

    public AbstractException(Throwable cause) {
        super(cause);
    }

    public AbstractException(String message, Throwable cause) {
        super(message, cause);
    }

    public AbstractException(String message, Object... arguments) {
        super(message);
        this.arguments=arguments;
    }

    /**
     * @return Returns the arguments.
     */
    public Object[] getArguments() {
        return arguments;
    }

    /**
     * @param arguments
     *            The arguments to set.
     */
    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }
}