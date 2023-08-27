import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    public Feline feline;

    private final  int kittensCount = 1;
    private final List<String> foods = List.of("Животные", "Птицы", "Рыба");
    private final String sex;
    private final boolean hasMane;

    Lion lion;

    @Before
    public void setUp() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(kittensCount);
        Mockito.when(feline.getFood("Хищник")).thenReturn(foods);
        lion = new Lion(sex, feline);
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    public LionTest (String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Test
    public void getKittensCountValueEqualsTest() {
        Assert.assertEquals(kittensCount, lion.getKittens());
    }

    @Test
    public void getKittensCountTimesCountTest() {
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void doesHaveManeValueEqualsTest() {
        Assert.assertEquals(hasMane, lion.doesHaveMane());
    }

    @Test
    public void getFoodValueEqualsTest() throws Exception {
        Assert.assertEquals(foods, lion.getFood());
    }

    @Test
    public void getFoodTimesCountTest() throws Exception {
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }
}
