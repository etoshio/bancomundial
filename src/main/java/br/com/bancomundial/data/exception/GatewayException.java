package br.com.bancomundial.data.exception;

public class GatewayException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public GatewayException() {
        super("Problema de acesso ao servidor.");
    }
    public GatewayException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public GatewayException(final String message) {
        super(message);
    }

    public GatewayException(final Throwable cause) {
        super(cause);
    }
}
