package br.com.jefferson.picpaydesafiobackend.transaction;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TransactionExceptionHandler {

    @ExceptionHandler(InvalidTransactionException.class)
    public ResponseEntity<Object> handler(InvalidTransactionException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
