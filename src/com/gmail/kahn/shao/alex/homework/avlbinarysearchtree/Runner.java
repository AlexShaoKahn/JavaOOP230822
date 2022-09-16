package com.gmail.kahn.shao.alex.homework.avlbinarysearchtree;

import java.lang.reflect.Field;
import java.util.*;

public class Runner {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        var random = new Random();
        var scanner = new Scanner(System.in);
        var tree = new AvlBinarySearchTree<Integer>(BranchDifference.ONE);

        //Filling tree
        int[] randomArray = random.ints(10, 0, 20).toArray();
        for (int i = 0; i < randomArray.length; i++) {
            tree.add(randomArray[i]);
        }
        System.out.println("Auto added: " + Arrays.toString(randomArray));
        System.out.println(tree);

        //Adding elements
        int element = 500;
        System.out.println("Adding element " + element);
        tree.add(element);
        element = 200;
        System.out.println("Adding element " + element);
        tree.add(element);
        System.out.print("Enter element to add: ");
        element = scanner.nextInt();
        System.out.println(tree.add(element) ? "ok" : element + " already exists");
        System.out.println(tree);
        System.out.println();

        //Removing elements
        System.out.print("Enter element to remove: ");
        element = scanner.nextInt();
        System.out.println(tree.remove(element) ? "ok" : "not found");
        System.out.println(tree);
        System.out.println();

        //Contains
        System.out.print("Enter element to find: ");
        element = scanner.nextInt();
        System.out.println((tree.contains(element) ? "" : "not ") + "found");
        System.out.println();

        System.out.println("Longest branch: " + tree.getLongestBranch());
        System.out.println();

        scanner.close();

        //Iterable collection
        var nodes = new Nodes<Integer>();
        Arrays.stream(new Random().ints(10, 0, 100).toArray()).forEach(e -> nodes.add(e));
        for (Node<Integer> node : nodes) {
            System.out.print(node + " ");
        }
        System.out.println();
        nodes.forEach(e -> System.out.print(e + " "));
        System.out.println();
        System.out.println();

        //Tree 2 lists
        List<List<Integer>> treeList = tree2lists(tree);
        treeList.forEach(System.out::println);
    }

    private static List<List<Integer>> tree2lists(AvlBinarySearchTree<Integer> tree) throws NoSuchFieldException, IllegalAccessException {
        List<List<Integer>> treeList = new ArrayList<>();
        List<List<Node<Integer>>> nodesList = new ArrayList<>();

        Field root = tree.getClass().getDeclaredField("root");
        root.setAccessible(true);
        Object node = root.get(tree);

        Field element = node.getClass().getDeclaredField("element");
        element.setAccessible(true);

        treeList.add(new LinkedList<Integer>(Collections.singleton((Integer) element.get(node))));
        nodesList.add(new LinkedList<Node<Integer>>(Collections.singleton((Node<Integer>) node)));

        for (int i = 1; i < tree.getLongestBranch(); i++) {
            treeList.add(new LinkedList<>());
            nodesList.add(new LinkedList<>());
            for (Node<Integer> n : nodesList.get(i - 1)) {
                if (n.getLeft() != null) {
                    nodesList.get(i).add(n.getLeft());
                    treeList.get(i).add(n.getLeft().getElement());
                }
                if (n.getRight() != null) {
                    nodesList.get(i).add(n.getRight());
                    treeList.get(i).add(n.getRight().getElement());
                }

            }
        }
        return treeList;
    }
}
