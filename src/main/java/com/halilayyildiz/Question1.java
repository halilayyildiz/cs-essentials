package com.halilayyildiz;

public class Question1
{
    public int solution(int[] T)
    {
        if (T.length < 3)
        {
            return 1;
        }

        int[] rightMin = new int[T.length];

        for (int i = T.length - 1, min = T[T.length - 1]; i >= 0; i--)
        {
            if (T[i] < min)
            {
                min = T[i];
            }
            rightMin[i] = min;
        }

        for (int i = 0, max = T[0]; i < T.length; i++)
        {
            if (rightMin[i] > max)
            {
                return i;
            }
            else
            {
                max = Math.max(max, T[i]);
            }
        }

        return 0;
    }

    public static void main(String[] args)
    {
        System.out.println("Result: " + new Question1().solution(new int[]
        { 3, 3, 6, 0, 9 }));

        System.out.println("Result: " + new Question1().solution(new int[]
        { 3, 3, 6 }));

        System.out.println("Result: " + new Question1().solution(new int[]
        { 1, 3, 6 }));

        System.out.println("Result: " + new Question1().solution(new int[]
        { 1, 2 }));

        System.out.println("Result: " + new Question1().solution(new int[]
        { 1, -2, 6 }));

        System.out.println("Result: " + new Question1().solution(new int[]
        { 5, -2, 3, 8, 6 }));

        System.out.println("Result: " + new Question1().solution(new int[]
        { -5, -5, -5, -42, 6, 12 }));

    }

}
