package ma.atos.reclamation.Unit.Controllers;

import ma.atos.reclamation.Services.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource
public class ClientControllerTest{

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientServiceImpl clientService;
    @Test
    public void testGetClients() throws Exception {
        mockMvc.perform(get("/clients"))
                .andExpect(status().isOk());
    }
}
