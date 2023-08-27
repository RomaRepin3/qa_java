import com.example.Feline;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(Parameterized.class)
public class FelineWithParamTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Spy
    Feline feline;

    private final int kittensCount;

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {{-1}, {0}, {10}};
    }

    public FelineWithParamTest(int kittensCount) {
        this.kittensCount = kittensCount;
    }

    @Test
    public void getKittensWithParamValueEqualsTest() {
        Assert.assertEquals(kittensCount, feline.getKittens(kittensCount));
    }

    @Test
    public void getKittensWithParamTimesCountTest() {
        feline.getKittens(kittensCount);
        Mockito.verify(feline, Mockito.times(1)).getKittens(kittensCount);
    }

}
