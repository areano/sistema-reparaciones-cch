package com.uade.seminario.tpo.exceptions;

public class DataAccessLayerException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -900558474212240559L;

	public DataAccessLayerException() {
    }

    public DataAccessLayerException(String message) {
        super(message);
    }

    public DataAccessLayerException(Throwable cause) {
        super(cause);
    }

    public DataAccessLayerException(String message, Throwable cause) {
        super(message, cause);
    }
}
