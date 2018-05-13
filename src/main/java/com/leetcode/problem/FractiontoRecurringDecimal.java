package com.leetcode.problem;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FractiontoRecurringDecimal
{
    public String fractionToDecimal(int numerator, int denominator)
    {
        // NOT SOLVED :/
        
        int scale = 100;
        BigDecimal num1 = new BigDecimal(numerator);
        BigDecimal num2 = new BigDecimal(denominator);
        String resultStr = num1.divide(num2, scale, RoundingMode.DOWN).toString();

        System.out.print(resultStr + " \t\t\t");

        char lastChar = resultStr.charAt(resultStr.length() - 1);
        int endIdx = resultStr.length() - 1;
        for (int i = resultStr.length() - 1; i >= 0; i--)
        {
            if (resultStr.charAt(i) == lastChar)
            {
                endIdx = i;
            }
            else
            {
                if (resultStr.charAt(i) == '.')
                {
                    if (resultStr.charAt(endIdx) == '0')
                    {
                        return resultStr.substring(0, resultStr.indexOf('.'));
                    }
                }
                if (resultStr.charAt(i) != lastChar)
                {
                    if (endIdx == resultStr.length() - 1)
                    {
                        return resultStr;
                    }
                    if (lastChar == '0')
                    {
                        return resultStr.substring(0, endIdx);
                    }
                    else
                    {
                        return resultStr.substring(0, endIdx) + '(' + lastChar + ')';
                    }
                }
            }
        }

        return resultStr;
    }

    public static void main(String[] args)
    {
        System.out.println(new FractiontoRecurringDecimal().fractionToDecimal(13, 12));
        System.out.println(new FractiontoRecurringDecimal().fractionToDecimal(2, 1));
        System.out.println(new FractiontoRecurringDecimal().fractionToDecimal(2, 3));
        System.out.println(new FractiontoRecurringDecimal().fractionToDecimal(1, 2));
        System.out.println(new FractiontoRecurringDecimal().fractionToDecimal(1, 90));
        System.out.println(new FractiontoRecurringDecimal().fractionToDecimal(1, 99));
        System.out.println(new FractiontoRecurringDecimal().fractionToDecimal(5, 7));
    }
}
