package halsteadOperatorsPackage;

import com.puppycrawl.tools.checkstyle.api.*;

import resources.TokenLists;

public class HalsteadOperatorsCheck extends AbstractCheck 
{

	private int count = 0;
	private String message = "Operator Count: ";
	private final int[] tokens;
	
	public HalsteadOperatorsCheck()
	{
		TokenLists tokenList = new TokenLists();
		tokens = tokenList.getOperators();
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
		log(aAST.getLineNo(), message + count + " -AJ");
		count = 0;
	}
}
