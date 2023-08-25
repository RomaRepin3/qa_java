import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class FelineNoParamTest {
    @Spy
    Feline feline;

    @Test
    public void eatMeatValueEqualsTest() throws Exception {
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void eatMeatTimesCountTest() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void getFamilyValueEqualsTest() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
        Mockito.verify(feline, Mockito.times(1)).getFamily();
    }
    @Test
    public void getFamilyTimesCountTest() {
        Assert.assertEquals("Кошачьи", feline.getFamily());
        Mockito.verify(feline, Mockito.times(1)).getFamily();
    }

    @Test
    public void getKittensNoParamTest() {
        Assert.assertEquals(1, feline.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }
}
