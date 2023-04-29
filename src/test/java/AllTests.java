import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                BookDeleteTest.class,
                BookGetTest.class,
                BookPostTest.class,
                BookPutTest.class,
        })
public class AllTests {
}