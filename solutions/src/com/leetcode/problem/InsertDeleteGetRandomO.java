package com.leetcode.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandomO
{

    class Node
    {
        Node before = null;
        Node next = null;
        int data;

        public Node(int d)
        {
            data = d;
        }
    }

    private Node lastNode = null;

    private Map<Integer, Node> map = new HashMap<>();
    private List<Node> list = new ArrayList<>();

    public boolean insert(int val)
    {
        boolean notContains = !map.containsKey(val);

        if (notContains)
        {
            Node node = new Node(val);
            if (lastNode == null)
            {
                lastNode = node;
            }
            else
            {
                lastNode.next = node;
                node.before = lastNode;
                lastNode = node;
            }

            map.put(val, node);
            list.add(node);
        }

        return notContains;
    }

    public boolean remove(int val)
    {
        boolean containsNode = map.containsKey(val);
        if (containsNode)
        {
            Node node = map.get(val);
            if (node.before != null && node.next != null)
            {
                node.before.next = node.next;
                node.next.before = node.before;
            }
            else if (node.before == null && node.next != null)
            {
                node.next.before = null;
            }
            else if (node.before != null && node.next == null)
            {
                node.before.next = null;
                lastNode = node.before;
            }
            else if (node.before == null && node.next == null)
            {
                lastNode = null;
            }

            // replace with the last element in the list, remove last is O(1)
            node.data = list.get(list.size() - 1).data;
            map.replace(node.data, node);
            list.remove(list.size() - 1);

            map.remove(val);
        }
        return containsNode;
    }

    public int getRandom()
    {
        if (!list.isEmpty())
        {
            int nextInt = new Random().nextInt(list.size());
            return list.get(nextInt).data;
        }
        return 0;
    }

    public static void main(String[] args)
    {
        InsertDeleteGetRandomO test = new InsertDeleteGetRandomO();

        test.insert(1);
        test.insert(10);
        test.insert(20);
        test.insert(30);

        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
    }
}
