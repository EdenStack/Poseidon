package com.tneciv.poseidon.common;

public class ApplicationException extends RuntimeException {

    private static final long serialVersionUID = -8823232859182991704L;

    public ApplicationException() {
        super();
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationException(Throwable cause) {
        super(cause);
    }
}
