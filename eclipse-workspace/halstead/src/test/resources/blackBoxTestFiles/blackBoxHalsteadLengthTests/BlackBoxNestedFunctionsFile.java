package blackBoxHalsteadLengthTest;

public class BlackBoxNestedFunctionsFile 
{
	public int func1()
	{
		return 1;
	}
	
	public int func2(int i)
	{
		return i + 1;
	}
	
	public void func3()
	{
		int i = func2(func1());
	}
}
