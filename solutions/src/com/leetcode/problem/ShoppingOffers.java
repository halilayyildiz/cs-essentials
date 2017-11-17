package com.leetcode.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingOffers
{
	Map<Integer, Integer>	priceMap		= new HashMap<>();
	Map<Integer, Integer>	itemMap			= new HashMap<>();
	List<SpecialOffer>		specialOffers	= new ArrayList<>();

	private class SpecialOffer
	{
		int				discount;
		List<Integer>	items;
		int				price;
	}

	public int tryShopping(Map<Integer, Integer> itemMap)
	{
		int res = Integer.MAX_VALUE;

		for (SpecialOffer offer : specialOffers)
		{
			Map<Integer, Integer> map = new HashMap<>(itemMap);

			boolean valid = true;
			List<Integer> items = offer.items;
			for (int i = 0; i < items.size(); i++)
			{
				int value = map.get(i) - items.get(i);
				if (value < 0)
				{
					valid = false;
					break;
				}
				map.put(i, value);
			}

			if (valid)
			{
				res = Math.min(res, offer.price + tryShopping(map));
			}
		}

		int standardPrice = 0;
		for (Integer key : itemMap.keySet())
		{
			standardPrice += itemMap.get(key) * priceMap.get(key);
		}
		res = Math.min(res, standardPrice);

		return res;
	}

	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs)
	{
		if (price.isEmpty() || needs.isEmpty())
		{
			return 0;
		}

		for (int i = 0; i < price.size(); i++)
		{
			priceMap.put(i, price.get(i));
			itemMap.put(i, needs.get(i));
		}

		for (int i = 0; i < special.size(); i++)
		{
			List<Integer> specialList = special.get(i);

			SpecialOffer offer = new SpecialOffer();
			offer.items = specialList.subList(0, specialList.size() - 1);
			offer.price = specialList.get(specialList.size() - 1);

			for (int j = 0, sum = 0; j < specialList.size(); j++)
			{
				if (j != specialList.size() - 1)
				{
					sum += specialList.get(j) * priceMap.get(j);
				}
				else
				{
					offer.discount = sum - specialList.get(j);
				}
			}
			if (offer.discount > 0)
			{
				specialOffers.add(offer);
			}
		}

		return tryShopping(itemMap);
	}

	public static void main(String[] args)
	{
		List<Integer> price2 = new ArrayList<>();
		price2.add(2);
		price2.add(5);

		List<List<Integer>> specialItems2 = new ArrayList<>();
		List<Integer> specialItem21 = new ArrayList<>();
		specialItem21.add(3);
		specialItem21.add(0);
		specialItem21.add(5);
		specialItems2.add(specialItem21);
		List<Integer> specialItem22 = new ArrayList<>();
		specialItem22.add(1);
		specialItem22.add(2);
		specialItem22.add(10);
		specialItems2.add(specialItem22);

		List<Integer> needs2 = new ArrayList<>();
		needs2.add(3);
		needs2.add(2);

		int totalPay2 = new ShoppingOffers().shoppingOffers(price2, specialItems2, needs2);
		System.out.println(totalPay2);

		List<Integer> price1 = new ArrayList<>();
		price1.add(2);
		price1.add(3);
		price1.add(4);

		List<List<Integer>> specialItems1 = new ArrayList<>();
		List<Integer> specialItem1 = new ArrayList<>();
		specialItem1.add(1);
		specialItem1.add(1);
		specialItem1.add(0);
		specialItem1.add(4);
		specialItems1.add(specialItem1);
		List<Integer> specialItem2 = new ArrayList<>();
		specialItem2.add(2);
		specialItem2.add(2);
		specialItem2.add(1);
		specialItem2.add(9);
		specialItems1.add(specialItem2);

		List<Integer> needs1 = new ArrayList<>();
		needs1.add(1);
		needs1.add(2);
		needs1.add(1);

		int totalPay1 = new ShoppingOffers().shoppingOffers(price1, specialItems1, needs1);
		System.out.println(totalPay1);

	}
}
