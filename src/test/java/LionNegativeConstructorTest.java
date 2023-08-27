import com.example.Feline;
import com.example.Lion;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(Parameterized.class)
public class LionNegativeConstructorTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    public Feline feline;

    private final String invalidSex;

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {""},
                {"12345"},
                {"Samets"},
                {"Samka"},
                {" "},
                {"_"}
        };
    }

    public LionNegativeConstructorTest (String invalidSex) {
        this.invalidSex = invalidSex;
    }

    @Test(expected = Exception.class)
    public void lionConstructorNegativeTest() throws Exception {
        Lion lion = new Lion(invalidSex, feline);
    }
}
