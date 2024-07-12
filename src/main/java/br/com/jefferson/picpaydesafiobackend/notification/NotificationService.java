package br.com.jefferson.picpaydesafiobackend.notification;

import org.springframework.stereotype.Service;

import br.com.jefferson.picpaydesafiobackend.transaction.Transaction;

@Service
public class NotificationService {
    private final NotificationProducer notificationProducer;
    

    public NotificationService(NotificationProducer notificationProducer){
        this.notificationProducer = notificationProducer;
        
    }

    public void notify(Transaction transaction){
        
        notificationProducer.sendNotification(transaction);
        
    }
}
