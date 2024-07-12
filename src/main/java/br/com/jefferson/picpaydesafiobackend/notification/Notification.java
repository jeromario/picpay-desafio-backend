package br.com.jefferson.picpaydesafiobackend.notification;

public record Notification(
    String status,
    Data data
) {
    public boolean isAuthorized(){
        return status.equalsIgnoreCase("fail");
    }

}

record Data(
    String message
) {

}