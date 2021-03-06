package ma.atos.reclamation.Unit.Services;
import ma.atos.reclamation.models.Category;
import ma.atos.reclamation.repositories.CategoryRepository;
import ma.atos.reclamation.services.CategoryServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
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


    public Category category;


    @Before
    public void init() {
        category = new Category(
                1L,
                "short",
                "long"
        );
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
        Optional<Category> categoryOpt = Optional.of(category);

        //When
        when(categoryRepository.findById(1L)).thenReturn(categoryOpt);

        //Then
        Optional<Category> returned = categoryService.findById(1L);

        assertNotNull(returned);
        assertEquals(returned.get(), category);
        assertEquals("short", returned.get().getLabelShort());
        verify(categoryRepository, times(1)).findById(1L);
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

        assertEquals("short", returned.getLabelShort());
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
