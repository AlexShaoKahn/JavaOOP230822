import com.gmail.kahn.shao.alex.homework.myhashtable.MyHashTable;
import org.junit.Assert;
import org.junit.Test;

public class MyHashTableRemoveTest {
    MyHashTable myHashTable = new MyHashTable();

    @Test
    public void testRemove() {
        System.out.println("Inside testRemove()");
        Object o = new Object();
        myHashTable.add(o);
        int oldSize = myHashTable.size();
        boolean removed = myHashTable.remove(o);
        boolean notExists = myHashTable.remove(new Object());
        int newSize = myHashTable.size();
        Assert.assertTrue(removed);
        Assert.assertFalse(notExists);
        Assert.assertEquals(oldSize - 1, newSize);
    }
}
