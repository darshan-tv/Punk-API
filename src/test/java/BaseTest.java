import org.testng.annotations.BeforeSuite;
import utils.Constants;

public class BaseTest {
    @BeforeSuite
    public static void loadConfig() {
        new Constants();
    }
}
