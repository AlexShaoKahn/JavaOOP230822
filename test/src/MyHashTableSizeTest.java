import com.gmail.kahn.shao.alex.homework.myhashtable.MyHashTable;
import org.junit.Assert;
import org.junit.Test;

public class MyHashTableSizeTest {
    MyHashTable myHashTable = new MyHashTable<Integer>();

    @Test
    public void testSize() {
        System.out.println("Inside testSize()");
        myHashTable.addAll(new Object[]{new Object(), new Object(), new Object()});
        int expectedSize = 3;
        int size = myHashTable.size();
        Assert.assertEquals(expectedSize, size);
    }
}
