package is.ru.stringcalculator;

import java.util.List;
import java.util.ArrayList;


public class Calculator
{
	public static int add(String text)
	{
		if(text.equals(""))
		{
			return 0;
		}
		else
		{
			String numbers[] = text.split(",|\\n");
			check(numbers);
			return sum(numbers);
		}
	}

	private static int toInt(String number)
	{
		return Integer.parseInt(number);
	}

	private static int sum(String [] numbers)
	{
		int total = 0;
		for(String number : numbers)
		{
			total += toInt(number);
		}
		return total;
	}

	private static void check(String [] numbers)
	{
		List<Integer> negatives = new ArrayList<Integer>();
		for(String number : numbers)
		{
			if(toInt(number) < 0)
			{
				negatives.add(toInt(number));
			}
		}
		if(negatives.size() > 0)
		{
			String message = "Negatives not allowed: ";
			message += negatives.get(0);
			if(negatives.size() > 1)
			{
				for(int i = 1; i < negatives.size(); i++)
				{
					message += ", " + negatives.get(i);
				}
			}
			throw new IllegalArgumentException(message);
		}
	}
}