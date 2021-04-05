package ma.atos.reclamation.Unit.Services;

import ma.atos.reclamation.Models.Reclamation;
import ma.atos.reclamation.Repositories.ReclamationRepository;
import ma.atos.reclamation.Services.ReclamationServiceImpl;
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
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ReclamationServiceTest {
    @InjectMocks
    private ReclamationServiceImpl reclamationService;
    @Mock
    private ReclamationRepository reclamationRepository;
    private Reclamation reclamation;

    @Before
    public void init() {
        reclamation = new Reclamation("XF555", "Urgent", Timestamp.from(Instant.now()), "Gestionnaire", "Body");
    }

    @Test
    public void testFindAllReclamationOk() {
        //Given
        List<Reclamation> list = new ArrayList<>();
        list.add(reclamation);

        //When
        when(reclamationRepository.findAll()).thenReturn(list);

        //Then
        List<Reclamation> returnedList = reclamationService.findAll();

        assertNotNull(returnedList);
        assertEquals(1, returnedList.size());

        assertEquals("XF555", returnedList.get(0).getReference());
        verify(reclamationRepository, times(1)).findAll();
    }
    @Test
    public void testFindReclamationById() {
        //Given
        Optional<Reclamation> reclamationOptional = Optional.of(reclamation);

        //When
        when(reclamationRepository.findById("XF555")).thenReturn(reclamationOptional);

        //Then
        Optional<Reclamation> returned = reclamationService.findById("XF555");

        assertNotNull(returned);
        //assertEquals(reclamation, returned.get());
        assertEquals("Urgent", returned.get().getPriority());
        verify(reclamationRepository, times(1)).findById("XF555");

    }


}
