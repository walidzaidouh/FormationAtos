package ma.atos.reclamation.Unit.Services;

import ma.atos.reclamation.Models.Category;
import ma.atos.reclamation.Models.Client;
import ma.atos.reclamation.Repositories.CategoryRepository;
import ma.atos.reclamation.Repositories.ClientRepository;
import ma.atos.reclamation.Services.CategoryServiceImpl;
import ma.atos.reclamation.Services.ClientService;
import ma.atos.reclamation.Services.ClientServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {
    @InjectMocks
    private CategoryServiceImpl categoryService;
    @Mock
    private CategoryRepository categoryRepository;


    private Category category;

    @Before
    public void init() {
        category = new Category(1, "short", "long");
    }

    @Test
    public void testFindAllCategoryOk() {
        //Given
        List<Category> list = new ArrayList<>();
        list.add(category);

        //When
        when(categoryRepository.findAll()).thenReturn(list);

        //Then
        List<Category> returnedList = categoryService.findAll();

        assertNotNull(returnedList);
        assertEquals(1, returnedList.size());

        assertEquals("short", returnedList.get(0).getLabelShort());
        assertEquals("long", returnedList.get(0).getLabelLong());
        verify(categoryRepository, times(1)).findAll();
    }
}
