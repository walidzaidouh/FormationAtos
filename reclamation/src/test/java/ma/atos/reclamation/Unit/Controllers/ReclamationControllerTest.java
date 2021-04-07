package ma.atos.reclamation.Unit.Controllers;

import ma.atos.reclamation.Controllers.ReclamationController;
import ma.atos.reclamation.Models.Reclamation;
import ma.atos.reclamation.Repositories.ReclamationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ReclamationControllerTest {
    /*@InjectMocks
    ReclamationController reclamationController;

    @Mock
    private ReclamationRepository reclamationRepository;
    private Reclamation reclamation;

    @Test
    public void testFindAll() {
        // given
        Reclamation reclamation1 = new Reclamation("XF555", "Urgent", Timestamp.from(Instant.now()), "Gestionnaire", "Body");
        //Given
        List<Reclamation> list = new ArrayList<>();
        list.add(reclamation1);

        //When
        when(reclamationRepository.findAll()).thenReturn(list);
        //Then
        List<Reclamation> returnedList = reclamationController.findAll();

        assertNotNull(returnedList);
        //Assertions.assertEquals(1, returnedList.size());

    }*/
}
