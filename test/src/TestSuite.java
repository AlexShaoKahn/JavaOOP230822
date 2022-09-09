import org.junit.runner.RunWith;
import org.junit.runners.Suite;

public class TestSuite {
    @RunWith(Suite.class)

    @Suite.SuiteClasses({
            MyHashTableAddTest.class,
            MyHashTableAddAllTest.class,
            MyHashTableContainsTest.class,
            MyHashTableRemoveTest.class,
            MyHashTableSizeTest.class
    })

    public class JunitTestSuit {

    }
}
