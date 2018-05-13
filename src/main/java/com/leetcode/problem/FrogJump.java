package com.leetcode.problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class FrogJump
{
    class Jump
    {
        int pos;
        int len;

        public Jump(int pos, int len)
        {
            this.pos = pos;
            this.len = len;
        }

        @Override
        public boolean equals(Object obj)
        {
            Jump other = (Jump) obj;
            return (this.pos == other.pos && this.len == other.len);
        }

        @Override
        public int hashCode()
        {
            return Objects.hash(this.pos, this.len);
        }
    }

    public boolean canCross(int[] stones)
    {
        if (stones.length < 2 || stones[1] != 1)
        {
            return false;
        }

        Map<Integer, Set<Integer>> visited = new HashMap<>();

        Set<Integer> stoneSet = new HashSet<>();
        for (int i = 0; i < stones.length; i++)
        {
            stoneSet.add(stones[i]);
            visited.put(stones[i], new HashSet<>());
        }

        Set<Jump> jumps = new HashSet<>();
        jumps.add(new Jump(0, 0));

        while (!jumps.isEmpty())
        {
            Set<Jump> newJumps = new HashSet<>();
            for (Jump jump : jumps)
            {
                if (jump.pos == stones[stones.length - 1])
                {
                    return true;
                }

                visited.get(jump.pos).add(jump.len);

                int nextPos = jump.pos + jump.len;
                if (stoneSet.contains(nextPos) && !visited.get(nextPos).contains(jump.len))
                {
                    newJumps.add(new Jump(nextPos, jump.len));
                }
                if (jump.len > 1 && stoneSet.contains(nextPos - 1) && !visited.get(nextPos - 1).contains(jump.len - 1))
                {
                    newJumps.add(new Jump(nextPos - 1, jump.len - 1));
                }
                if (stoneSet.contains(nextPos + 1) && !visited.get(nextPos + 1).contains(jump.len + 2))
                {
                    newJumps.add(new Jump(nextPos + 1, jump.len + 1));
                }
            }
            jumps = newJumps;
        }

        return false;
    }

    public static void main(String[] args)
    {
        int[] stones = { 0, 1, 3, 5, 6, 8, 12, 17 };
        System.out.println(new FrogJump().canCross(stones));

        int[] stones2 = { 0, 1, 2, 3, 4, 8, 9, 11 };
        System.out.println(new FrogJump().canCross(stones2));
    }
}
