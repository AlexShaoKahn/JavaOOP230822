package avlbinarysearchtree;

import com.gmail.kahn.shao.alex.homework.avlbinarysearchtree.AvlBinarySearchTree;
import com.gmail.kahn.shao.alex.homework.avlbinarysearchtree.BranchDifference;
import com.gmail.kahn.shao.alex.homework.avlbinarysearchtree.Node;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AvlBinarySearchTreeTest {
    AvlBinarySearchTree tree = new AvlBinarySearchTree<Integer>(BranchDifference.ONE);

    @Test
    public void addTest() {
        System.out.println("Inside add()");
        boolean result = tree.add(1);
        Assert.assertTrue(result);
    }

    @Test
    public void removeTest() {
        System.out.println("Inside remove()");
        tree.add(10);
        boolean result = tree.remove(10);
        Assert.assertTrue(result);
    }

    @Test
    public void containsTest() {
        System.out.println("Inside contains()");
        tree.add(2);
        boolean result = tree.contains(2);
        Assert.assertTrue(result);
    }

    @Test
    public void sizeTest() {
        System.out.println("Inside size()");
        int oldSize = tree.size();
        tree.add(3);
        int newSize = tree.size();
        Assert.assertEquals(oldSize + 1, newSize);
    }

//    @Test
//    public void getLevelTest() throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {
//        System.out.println("Inside getLevel()");
//        tree = new AvlBinarySearchTree<Integer>(BranchDifference.ONE);
//        Method method = tree.getClass().getMethod("getLevel", Node.class);
//        method.setAccessible(true);
//        Field field = tree.getClass().getField("root");
//        tree.add(1);
//        int oldLevel = (int) method.invoke(field);
//        tree.add(2);
//        int newLevel = (int) method.invoke(field);
//        Assert.assertEquals(oldLevel + 1, newLevel);
//    }
}
