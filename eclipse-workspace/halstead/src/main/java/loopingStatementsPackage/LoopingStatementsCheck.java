package loopingStatementsPackage;

import java.util.Hashtable;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;

import resources.TokenLists;

public class LoopingStatementsCheck extends AbstractCheck {
	private int count = 0;
	private String message = "Looping statements count: ";
	private final int[] tokens;
	
	public LoopingStatementsCheck()
	{
		TokenLists tokenList = new TokenLists();
		tokens = tokenList.getLoopingStatements();
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

	public Hashtable<String, Integer> getResults() 
	{
		Hashtable<String, Integer> result = new Hashtable<String, Integer>();
		result.put(this.message, this.count);
		return result;
	}
}
