import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    private final List<String> foods = List.of("Животные", "Птицы", "Рыба");

    @Mock
    Feline feline;

    Cat cat;

    @Before
    public void setUp() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(foods);
        cat = new Cat(feline);
    }

    @Test
    public void getSoundValueEqualsTest() {
        final String catSound = "Мяу";
        Assert.assertEquals(catSound, cat.getSound());
    }

    @Test
    public void getFoodValueEqualsTest() throws Exception {
        Assert.assertEquals(foods, cat.getFood());
    }

    @Test
    public void getFoodTimesCountTest() throws Exception {
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
}
