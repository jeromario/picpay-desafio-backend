package br.com.jefferson.picpaydesafiobackend.authorization;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import br.com.jefferson.picpaydesafiobackend.transaction.Transaction;
import br.com.jefferson.picpaydesafiobackend.transaction.UnauthorizedTransactionException;

@Service
public class AuthorizerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizerService.class);
    private RestClient restClient;

    public AuthorizerService(RestClient.Builder builder){
        this.restClient = builder
            .baseUrl("https://util.devi.tools/api/v2/authorize").build();
    }

    public void authorize(Transaction transaction){
        LOGGER.info("Authorizing transaction {}", transaction);
        var response = restClient.get().retrieve().toEntity(Authorization.class);

        if (response.getStatusCode().isError() || !response.getBody().isAuthorized()) {
            throw new UnauthorizedTransactionException("Unauthorized transaction!");
            
        }
        LOGGER.info("Transaction authorize", transaction);
    }

}
