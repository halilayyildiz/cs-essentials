package com.leetcode.problem;

import java.util.Stack;

public class LargestRectangleinHistogram
{
    private class Pair
    {
        int val, index;

        public Pair(int index, int val)
        {
            this.index = index;
            this.val = val;
        }
    }

    public int largestRectangleArea(int[] heights)
    {
        int maxArea = 0;
        Stack<Pair> stack = new Stack<>();

        if (heights.length == 0)
        {
            return 0;
        }

        for (int i = 0; i < heights.length; i++)
        {
            if (stack.isEmpty())
            {
                stack.push(new Pair(i, heights[i]));
            }
            else
            {
                Pair pairOnTop = stack.peek();
                if (heights[i] >= pairOnTop.val)
                {
                    stack.push(new Pair(i, heights[i]));
                }
                else
                {
                    Pair lastPoped = null;
                    while (!stack.empty())
                    {
                        pairOnTop = stack.peek();
                        if (pairOnTop.val > heights[i])
                        {
                            pairOnTop = stack.pop();
                            maxArea = Math.max(maxArea, pairOnTop.val * (i - pairOnTop.index));
                            lastPoped = pairOnTop;
                        }
                        else
                        {
                            break;
                        }
                    }
                    if (heights[i] > 0 && lastPoped != null)
                    {
                        stack.push(new Pair(lastPoped.index, heights[i]));
                    }
                }
            }

            if ((i == heights.length - 1))
            {
                while (!stack.empty())
                {
                    Pair pairOnTop = stack.pop();
                    maxArea = Math.max(maxArea, pairOnTop.val * (i + 1 - pairOnTop.index));
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args)
    {
        int[] heights5 = { 3, 6, 5, 7, 4, 8, 1, 0 };
        System.out.println(new LargestRectangleinHistogram().largestRectangleArea(heights5));
        int[] heights = { 1, 2, 1 };
        System.out.println(new LargestRectangleinHistogram().largestRectangleArea(heights));
        int[] heights2 = { 2, 1, 5, 6, 2, 3 };
        System.out.println(new LargestRectangleinHistogram().largestRectangleArea(heights2));
        int[] heights3 = { 2, 1, 2 };
        System.out.println(new LargestRectangleinHistogram().largestRectangleArea(heights3));
        int[] heights4 = { 4, 2, 0, 3, 2, 5 };
        System.out.println(new LargestRectangleinHistogram().largestRectangleArea(heights4));
    }
}
