package ma.atos.reclamation.Unit.Controllers;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


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
