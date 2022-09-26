package halsteadOperandsPackage;

import com.puppycrawl.tools.checkstyle.api.*;

public class HalsteadOperandsCheck extends AbstractCheck {

	private int count = 0;
	private String message = "Operands Count: ";
	
	int[] tokens = new int[] {TokenTypes.CHAR_LITERAL,
			TokenTypes.EMPTY_STAT,
			TokenTypes.EXPR,
			TokenTypes.FOR_CONDITION,
			TokenTypes.FOR_INIT,
			TokenTypes.FOR_ITERATOR,
			TokenTypes.IDENT,
			TokenTypes.LABELED_STAT,
			TokenTypes.METHOD_REF,
			TokenTypes.NUM_DOUBLE,
			TokenTypes.NUM_FLOAT,
			TokenTypes.NUM_INT,
			TokenTypes.NUM_LONG,
			TokenTypes.RESOURCE,
			TokenTypes.STRING_LITERAL};
	
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
		log(aAST.getLineNo(), message + count);
		count = 0;
	}

}
