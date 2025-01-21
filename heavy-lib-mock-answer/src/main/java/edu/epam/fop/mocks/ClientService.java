package edu.epam.fop.mocks;

import edu.epam.fop.mocks.client.ClientRepository;
import edu.epam.fop.mocks.client.ClientResponse;

import static org.mockito.Mockito.when;

public final class ClientService {

    private final ClientRepository client;

    public ClientService(ClientRepository client) {
        this.client = client;
        long definedId = client.definedId();

        when(client.findById(definedId)).thenAnswer(invocationOnMock -> {
            long id = invocationOnMock.getArgument(0);

            if(id == definedId){
                if(id % 2 == 0){ // even
                    return new ClientResponse(definedId, "Louisa", "Rodriguez");
                }else { // odd
                    return new ClientResponse(definedId, "Lou", "Tenat");
                }
            }

            return null;
        });

    }

    public ClientResponse search(long id) {
        return client.findById(id);
    }
}

/*
 * If the ID is odd, the ClientResponse must have:
 * id = definedId()
 * name = Lou
 * surname = Tenat
 * If the ID is even, the ClientResponse must have:
 * id = definedId()
 * name = Louisa
 * surname = Rodriguez
 * */
