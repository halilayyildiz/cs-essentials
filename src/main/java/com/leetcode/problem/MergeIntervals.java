package com.leetcode.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MergeIntervals
{
    public class Interval
    {
        int start;
        int end;

        Interval()
        {
            start = 0;
            end = 0;
        }

        public Interval(int s, int e)
        {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals)
    {
        if (intervals.isEmpty())
        {
            return new ArrayList<>();
        }

        List<Interval> result = new ArrayList<>();
        Set<Long> set = new HashSet<>();

        for (Interval in : intervals)
        {
            for (long i = in.start * 2; i <= in.end * 2; i++)
            {
                set.add(i);
            }
        }

        ArrayList<Long> list = new ArrayList<>(set);
        Collections.sort(list);

        long start = list.get(0);
        long end = list.get(0);
        for (int i = 1; i < list.size(); i++)
        {
            if (list.get(i) == list.get(i - 1) + 1)
            {
                if (i == list.size() - 1)
                {
                    result.add(new Interval((int) (start / 2), (int) (list.get(i) / 2)));
                    break;
                }
                else
                {
                    end = list.get(i);
                    continue;
                }
            }
            else
            {
                result.add(new Interval((int) (start / 2), (int) (end / 2)));
                start = list.get(i);
                end = list.get(i);

                if (i == list.size() - 1)
                {
                    result.add(new Interval((int) (start / 2), (int) (end / 2)));
                }
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        MergeIntervals test = new MergeIntervals();

        List<Interval> intervals = new ArrayList<>();
        intervals.add(test.new Interval(2, 3));
        intervals.add(test.new Interval(5, 5));
        intervals.add(test.new Interval(2, 2));
        intervals.add(test.new Interval(3, 4));
        intervals.add(test.new Interval(3, 4));

        List<Interval> result = test.merge(intervals);
        result.stream().forEach(interval -> System.out.println("[" + interval.start + "," + interval.end + "]"));
    }
}
