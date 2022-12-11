package blackBoxLoopingTests;

public class BlackBoxNestedLoopingStatementsFile 
{
	public void func()
	{
		int i = 0;
		int sum = 0;
		while (i < 10)
		{
			for (int j = 0; j < 10; j ++)
			{
				sum = sum + i + j;
			}
		}
	}
}
