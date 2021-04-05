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
import java.util.Optional;

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
        category = new Category(1L, "short", "long");
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

    @Test
    public void testFindByIdOk() {
        //Given
        Optional<Category> categoryOptional = Optional.of(category);

        //When
        when(categoryRepository.findById(1L)).thenReturn(categoryOptional);

        //Then
        Optional<Category> returned = categoryService.findById(1L);

        assertNotNull(returned);
        assertEquals("short", returned.get().getLabelLong());
        verify(categoryRepository, times(1)).findById(1L);
    }


    @Test
    public void testFindByIdWithIdNullOk() {
        //Given
        Optional<Category> categoryOptional = Optional.empty();

        //Then
        Optional<Category> returned = categoryService.findById(null);

        assertEquals(Optional.empty(), returned);
        verify(categoryRepository, times(0)).findById(null);
    }


    @Test
    public void testAddCategoryOk(){
        //Given

        //When
        when(categoryRepository.save(category)).thenReturn(category);

        //Then
        Category returned = categoryRepository.save(category);

        assertNotNull(returned);
        assertEquals(category, returned);
        assertEquals("1", returned.getId());
        verify(categoryRepository, times(1)).save(category);
    }


    @Test
    public void testDeleteByIdOk() {
        //Then
        categoryService.deleteById(1L);

        verify(categoryRepository, times(1)).deleteById(1L);
    }


    @Test
    public void testUpdateOk() {
        //Given
        Category c = new Category(
                2L,
                "toto",
                "fofo"

        );



        //When
        when(categoryRepository.save(c)).thenReturn(c);

        //Then
        Category returned = categoryService.update(2L, c );

        assertNotNull(returned);
        assertEquals(c, returned);
        assertEquals("fofo", returned.getLabelLong());
        verify(categoryRepository, times(1)).save(c);
    }


}
