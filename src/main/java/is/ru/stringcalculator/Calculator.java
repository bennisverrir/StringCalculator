package is.ru.stringcalculator;

import java.util.List;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;


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
			String[] extracted = extractDelimeter(text);

			String numbers[] = extracted[1].split(extracted[0]);
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
			if(toInt(number) < 1000)
			{
				total += toInt(number);
			}
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

	private static String[] extractDelimeter(String text)
	{
		String defaultDelimeter = ",|\\n";
		if(text.startsWith("//"))
		{
			String[] extracted = text.split("\n", 2);
			extracted[0] = extracted[0].replace("//","");
			extracted[0] = StringUtils.replaceOnce(extracted[0], "\n","");
			extracted[0] = extracted[0] + "|" + defaultDelimeter;
			return extracted;
		}
		else
		{
			String[] temp = new String[2];
			temp[0] = defaultDelimeter;
			temp[1] = text;
			return temp;
		}
	}
}