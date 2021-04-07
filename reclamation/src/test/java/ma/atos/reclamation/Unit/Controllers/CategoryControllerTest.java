package ma.atos.reclamation.Unit.Controllers;

import ma.atos.reclamation.Services.CategoryServiceImpl;
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

/*@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource*/
public class CategoryControllerTest{

    /*@Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryServiceImpl categoryService;
    @Test
    public void testGetCategories() throws Exception {
        mockMvc.perform(get("/categories"))
                .andExpect(status().isOk());
    }*/
}