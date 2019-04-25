package com.atix.monitoreo.messages;

public class MessageResponse implements com.atix.monitoreo.messages.Response {

    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }

    public MessageResponse() {
    }

    public MessageResponse(int numero) { this.message = String.valueOf(numero);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
