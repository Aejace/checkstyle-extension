package numberOfCommentsPackage;

import com.puppycrawl.tools.checkstyle.api.DetailAST;

import basicCountingPackage.BasicCountingCheck;
import resources.TokenLists;

public class NumberOfCommentsCheck extends BasicCountingCheck 
{	
	private int count = 0;
	private String message = "Comments Count: ";
	private final int[] tokens;
	
	
	public NumberOfCommentsCheck()
	{
		TokenLists tokenList = new TokenLists();
		tokens = tokenList.getComments();
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
	
	@Override
	public boolean isCommentNodesRequired() {
        return true;
    }
}
