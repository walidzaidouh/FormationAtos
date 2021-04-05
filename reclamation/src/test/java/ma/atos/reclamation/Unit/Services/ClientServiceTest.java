package ma.atos.reclamation.Unit.Services;

import ma.atos.reclamation.Models.Client;
import ma.atos.reclamation.Repositories.ClientRepository;
import ma.atos.reclamation.Services.ClientService;
import ma.atos.reclamation.Services.ClientServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {
    @InjectMocks
    private ClientServiceImpl clientService;
    @Mock
    private ClientRepository clientRepository;


    private Client client;

    @Before
    public void init() {
        client = new Client(1L, "BE777777", 14449976L, "10 BD Anfa");
    }

    @Test
    public void testFindAllClientOk() {
        //Given
        List<Client> list = new ArrayList<>();
        list.add(client);

        //When
        when(clientRepository.findAll()).thenReturn(list);

        //Then
        List<Client> returnedList = clientService.findAll();

        assertNotNull(returnedList);
        assertEquals(1, returnedList.size());

        assertEquals("BE777777", returnedList.get(0).getCin());
        verify(clientRepository, times(1)).findAll();
    }


}
