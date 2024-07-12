package br.com.jefferson.picpaydesafiobackend.authorization;

public record Authorization(
    String status,
    Data data
) {
    public boolean isAuthorized(){
        return data.authorization();
    }
}

record Data(
    boolean authorization
) {

}
