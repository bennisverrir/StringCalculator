package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest
{
	//Step 1
	@Test
	public void testEmptyString()
	{
		assertEquals(0, Calculator.add(""));
	}
	@Test
	public void testOneNumber()
	{
		assertEquals(1, Calculator.add("1"));
	}
	@Test
	public void testTwoNumbers()
	{
		assertEquals(3, Calculator.add("1,2"));
	}

	//Step 2
	@Test
	public void testMultibleNumbers()
	{
		assertEquals(6, Calculator.add("1,2,3"));
	}

	//Step 3
	@Test
	public void testNewLine()
	{
		assertEquals(6, Calculator.add("1\n2,3"));
	}

	//Step 4
	@Test(expected = IllegalArgumentException.class)
    public final void testNegativeNumber()
    {
        Calculator.add("-1,2");
    }
    @Test
    public void testNegativeNumberMessage()
    {
        try
        {
            Calculator.add("-1,2");
        }
        catch (RuntimeException exception)
        {
            assertEquals("Negatives not allowed: -1", exception.getMessage());
        }
    }
    @Test
    public void testMultibleNegativeNumbersMessage()
    {
        try
        {
            Calculator.add("2,-4,3,-5");
        }
        catch (RuntimeException exception)
        {
            assertEquals("Negatives not allowed: -4, -5", exception.getMessage());
        }
    }

    //Step 5
    @Test
    public void testLargerthan1k()
    {
    	assertEquals(2, Calculator.add("1001,2"));
    }

    //step 6
    @Test
    public void testCustomDelimeter()
    {
    	assertEquals(3, Calculator.add("//;\n1;2"));
    }

}