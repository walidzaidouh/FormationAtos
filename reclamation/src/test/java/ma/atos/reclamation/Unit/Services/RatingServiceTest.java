package ma.atos.reclamation.Unit.Services;

import ma.atos.reclamation.Models.Rating;
import ma.atos.reclamation.Repositories.RatingRepository;
import ma.atos.reclamation.Services.RatingServiceImpl;
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
public class RatingServiceTest {
    @InjectMocks
    private RatingServiceImpl ratingService;
    @Mock
    private RatingRepository ratingRepository;
     public Rating rating;
     @Test
     @Before
     public void init() {
         rating = new Rating(
                 1L,
                 "Bien",
                 11D
                  );
     }

    @Test
    public void testFindAllRatingOk() {
        //Given
        List<Rating> list = new ArrayList<>();
        list.add(rating);

        //When
        when(ratingRepository.findAll()).thenReturn(list);

        //Then
        List<Rating> returnedList = ratingService.findAll();

        assertNotNull(returnedList);
        assertEquals(1, returnedList.size());
        assertEquals("Bien", returnedList.get(0).getCommentaire());
    }
    @Test
    public void testFindByIdOk() {
        //Given
        Optional<Rating> ratingOpt = Optional.of(rating);

        //When
        when(ratingRepository.findById(1L)).thenReturn(ratingOpt);

        //Then
        Optional<Rating> returned = ratingService.findById(1L);

        assertNotNull(returned);
        assertEquals(rating, returned.get());
        assertEquals("Bien", returned.get().getCommentaire());
        verify(ratingRepository, times(1)).findById(1L);
    }
    @Test
    public void testAddRatingOk(){
        //Given

        //When
        when(ratingRepository.save(rating)).thenReturn(rating);

        //Then
        Rating returned = ratingRepository.save(rating);

        assertNotNull(returned);
        assertEquals(rating, returned);
        assertEquals("Bien", returned.getCommentaire());
        verify(ratingRepository, times(1)).save(rating);
    }

    @Test
    public void testDeleteByIdOk() {
        //Then
        ratingService.deleteById(1L);

        verify(ratingRepository, times(1)).deleteById(1L);
    }
}
