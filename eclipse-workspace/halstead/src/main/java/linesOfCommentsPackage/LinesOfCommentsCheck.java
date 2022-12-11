package linesOfCommentsPackage;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import basicCountingPackage.BasicCountingCheck;
import resources.TokenLists;

public class LinesOfCommentsCheck extends BasicCountingCheck 
{
	private int count = 0;
	private String message = "Line of comments count: ";
	private final int[] tokens;
	private int BeginningLineNumber = 0;
	
	public LinesOfCommentsCheck()
	{
		TokenLists tokenList = new TokenLists();
		tokens = tokenList.getCommentLines();
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
		if (aAST.getType() == TokenTypes.BLOCK_COMMENT_BEGIN)
		{
			this.BeginningLineNumber = aAST.getLineNo();
		}
		else if (aAST.getType() == TokenTypes.BLOCK_COMMENT_END)
		{
			count += aAST.getLineNo() - this.BeginningLineNumber - 1;
		}
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
