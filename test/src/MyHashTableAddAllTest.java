import com.gmail.kahn.shao.alex.homework.myhashtable.MyHashTable;
import org.junit.Assert;
import org.junit.Test;

public class MyHashTableAddAllTest {
    MyHashTable myHashTable = new MyHashTable();

    @Test
    public void testAddAll() {
        System.out.println("Inside testAddAll()");
        int oldSize = myHashTable.size();
        boolean result = myHashTable.addAll(new Object[]{new Object(), new Object()});
        int newSize = myHashTable.size();
        Assert.assertTrue(result);
        Assert.assertEquals(oldSize + 2, newSize);
    }
}
