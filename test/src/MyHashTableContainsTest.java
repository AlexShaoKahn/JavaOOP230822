import com.gmail.kahn.shao.alex.homework.myhashtable.MyHashTable;
import org.junit.Assert;
import org.junit.Test;

public class MyHashTableContainsTest {
    MyHashTable myHashTable = new MyHashTable<Integer>();

    @Test
    public void testContains() {
        System.out.println("Inside testContains()");
        Object o = new Object();
        myHashTable.add(o);
        boolean contains = myHashTable.contains(o);
        boolean notContains = myHashTable.contains(new Object());
        Assert.assertTrue(contains);
        Assert.assertFalse(notContains);
    }
}
