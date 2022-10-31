package com.websocket.web_socket_02.DTO;

public class MessageDTO {

    private String sender;
    private String type;
    private String message;
    

    public MessageDTO(String sender, String type, String message){
        this.sender = sender;
        this.type = type;
        this.message = message;
    }

    public MessageDTO(String sender) {
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
