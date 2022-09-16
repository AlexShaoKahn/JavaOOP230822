package myhashtable;

import com.gmail.kahn.shao.alex.homework.myhashtable.MyHashTable;
import org.junit.Assert;
import org.junit.Test;

public class MyHashTableAddTest {
    MyHashTable myHashTable = new MyHashTable();

    @Test
    public void testAdd() {
        System.out.println("Inside testAdd()");
        Object o = new Object();
        int oldSize = myHashTable.size();
        boolean added = myHashTable.add(o);
        int newSize = myHashTable.size();
        boolean notExists = myHashTable.add(o);
        Assert.assertTrue(added);
        Assert.assertFalse(notExists);
        Assert.assertEquals(oldSize + 1, newSize);
    }
}
