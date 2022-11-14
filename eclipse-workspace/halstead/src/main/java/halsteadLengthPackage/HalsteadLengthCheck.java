package halsteadLengthPackage;

import com.puppycrawl.tools.checkstyle.api.*;

import resources.TokenLists;

public class HalsteadLengthCheck extends AbstractCheck 
{
	private int length = 0;
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
		length = 0;
	}
	
	@Override
	public void visitToken(DetailAST aAST) 
	{
		length++;
	}
	
	@Override
	public void finishTree(DetailAST aAST)
	{
		log(aAST.getLineNo(), message + length + " -AJ");
		length = 0;
	}
}
