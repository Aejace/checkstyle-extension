package blackBoxHalsteadOperatorsTests;

public class BlackBoxNestedIfElseFile 
{
	public void func(int i)
	{
		int zero;
		if (i < 0)
		{
			i++;
			if (i < 0)
			{
				func(i);
			}
			else
			{
				zero = i;
			}
			
		}
		else if (i > 0)
		{
			i--;
			if (i > 0)
			{
				func(i);
			}
			else
			{
				zero = i;
			}
		}
		else
		{
			zero = i
		}
	}
	
	public int func2()
	{
		return 10;
	}
	
	public void func3()
	{
		i = func(func2());
	}
}
