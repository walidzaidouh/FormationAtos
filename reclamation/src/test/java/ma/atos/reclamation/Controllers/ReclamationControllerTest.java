package ma.atos.reclamation.Controllers;

import ma.atos.reclamation.Services.ReclamationService;
import ma.atos.reclamation.Services.ReclamationServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class ReclamationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReclamationServiceImpl reclamationService;
    @Test
    public void testGetReclamations() throws Exception {
        mockMvc.perform(get("/reclamations"))
                .andExpect(status().isOk());
    }
}
