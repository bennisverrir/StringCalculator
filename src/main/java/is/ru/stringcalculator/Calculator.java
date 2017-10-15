package is.ru.stringcalculator;

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
			for(String number : numbers)
			{
				if(Integer.parseInt(number) < 0)
				{
					throw new IllegalArgumentException();
				}
			}
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
}