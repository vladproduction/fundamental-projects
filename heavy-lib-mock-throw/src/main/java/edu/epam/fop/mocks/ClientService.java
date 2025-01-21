package edu.epam.fop.mocks;

import edu.epam.fop.mocks.client.ClientRepository;
import edu.epam.fop.mocks.client.ClientResponse;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public final class ClientService {

  private final ClientRepository client;

    public ClientService(ClientRepository client) {
        this.client = client;

        long definedId = client.definedId();

        when(client.findById(definedId)).thenThrow(new UnsupportedOperationException());
//        when(client.findById(anyLong())).thenReturn(null);

    }

    public ClientResponse search(long id) {
        return client.findById(id);
    }
}
