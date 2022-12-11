package blackBoxTestFiles;

public class BlackBoxLoopingStatementsFile 
{
	public void myFunct()
	{	
		int i = 0;
		do
		{
			++i;
		}
		while (i < 10);
		
		i = 0;
		while (i < 10)
		{
			++i;
		}
		
		int sum = 0;
		for (int i = 0; i < 10; ++i)
		{
			sum = sum + i;
		}
		
		sum = 0;
		int[] nums = {1,2,3,4};
		
		for( int num : nums)
		{
			sum += 1;
		}
	}
}
