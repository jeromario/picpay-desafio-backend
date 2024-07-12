package br.com.jefferson.picpaydesafiobackend.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties.Transaction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;



@Service
public class NotificationConsumer {
    private RestClient restClient;
    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationConsumer.class);

    public NotificationConsumer(RestClient.Builder builder){
        this.restClient = builder.baseUrl("https://util.devi.tools/api/v1/notify").build();
    }

    @KafkaListener(topics = "transaction-notification", groupId = "picpay-desafio-backend")
    public void receiveNotification(Transaction transaction){
        LOGGER.info("Notifying transaction {}...",transaction);
        var response = restClient.get().retrieve().toEntity(Notification.class);

        if (response.getStatusCode().isError() || !response.getBody().isAuthorized()) {
            throw new NotificationException("Error sending notification");
            
        }
        LOGGER.info("Notification has been sent {}...", response.getBody());
    }

}
