package com.halilayyildiz;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Test1 {

    public static void main(String[] args) {
        // int result = new Test1().openLock(new String[] { "0201", "0101", "0102", "1212", "2002" }, "0202");
        // int result = new Test1().openLock(new String[] { "8888"}, "0009");
        int result = new Test1().openLock2(new String[] {"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888");
        System.out.println(result);
    }

    public int openLock(String[] deadends, String target) {
        String start = "0000";
        Set<String> dead = new HashSet();
        for (String d: deadends) dead.add(d);
        if (dead.contains(start)) return -1;
     
        Queue<String> queue = new LinkedList();
        queue.offer(start);        
     
        Set<String> visited = new HashSet();
        visited.add(start);
     
        int steps = 0;
        while (!queue.isEmpty()) {
          ++steps;
          int size = queue.size();
          for (int s = 0; s < size; ++s) {
            String node = queue.poll();
            for (int i = 0; i < 4; ++i) {
              for (int j = -1; j <= 1; j += 2) {
                char[] chars = node.toCharArray();
                chars[i] = (char)(((chars[i] - '0') + j + 10) % 10 + '0');
                String next = new String(chars);
                if (next.equals(target)) return steps;
                if (dead.contains(next) || visited.contains(next))
                    continue;
                visited.add(next);
                queue.offer(next);
              }
            }
          }
        }
        return -1;
      }

    public int openLock2(String[] deadends, String target) 
    {         
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        
        if(deads.contains(target) || deads.contains("0000"))
        {
            return -1;
        } 
        
        Queue<String> inputs = new LinkedList<>();
        inputs.add("0000");
        
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        
        int step = 0;
        while(!inputs.isEmpty())
        {
            step++;
            int size = inputs.size();
            for(int i=0; i < size; i++)
            {
                String input = inputs.poll();
                for(int j=0; j < 4; j++)
                {
                    for(int k=-1; k < 2; k+=2)
                    {
                        char[] chars = input.toCharArray();
                        chars[j] = (char)(((chars[j] - '0') + k + 10) % 10 + '0');
                        String newInput = new String(chars);
                        
                        if(target.equals(newInput))
                        {
                            return step;
                        }
                        if(!deads.contains(newInput) && !visited.contains(newInput) )
                        {
                            visited.add(newInput);
                            inputs.offer(newInput);
                        }
                    }
                }
            } 
        }
        return -1;
    }
}