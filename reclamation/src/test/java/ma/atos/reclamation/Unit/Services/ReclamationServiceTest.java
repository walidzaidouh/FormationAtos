package ma.atos.reclamation.Unit.Services;

import ma.atos.reclamation.Models.Reclamation;
import ma.atos.reclamation.Repositories.ReclamationRepository;
import ma.atos.reclamation.Services.ReclamationService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class ReclamationServiceTest {
    @InjectMocks
    private ReclamationService reclamationService;
    @Mock
    private ReclamationRepository reclamationRepository;
    private Reclamation reclamation;
    @Before
    public void init() {
        Date date_now = new Date();
        reclamation = new Reclamation("XF555", "Urgent", date_now, "Gestionaire", "Body");
    }

    }
