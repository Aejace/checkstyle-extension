package halsteadLengthPackage;

import com.puppycrawl.tools.checkstyle.api.*;

import basicCountingPackage.BasicCountingCheck;
import resources.TokenLists;

public class HalsteadLengthCheck extends BasicCountingCheck 
{
	private int count = 0;
	private String message = "Halstead Length: ";
	private final int[] tokens;
	
	public HalsteadLengthCheck()
	{
		TokenLists tokenList = new TokenLists();
		int[] operators = tokenList.getOperators();
		int[] operands = tokenList.getOperands();
		tokens = new int[operators.length + operands.length];
        int index = 0;
        for (int token : operators) {
            tokens[index] = token;
            index++;
        }

        for (int token : operands) {
            tokens[index] = token;
            index++;
        }
	}
	
	
	@Override
	public int[] getDefaultTokens() 
	{
		return tokens;
	}

	@Override
	public int[] getAcceptableTokens() 
	{
		return tokens;
	}

	@Override
	public int[] getRequiredTokens() 
	{
		return tokens;
	}
	
	@Override
	public void beginTree(DetailAST root)
	{
		count = 0;
	}
	
	@Override
	public void visitToken(DetailAST aAST) 
	{
		count++;
	}
	
	@Override
	public void finishTree(DetailAST aAST)
	{
		result = count;
		log(aAST.getLineNo(), message + count + " -AJ");
		count = 0;
	}
}
