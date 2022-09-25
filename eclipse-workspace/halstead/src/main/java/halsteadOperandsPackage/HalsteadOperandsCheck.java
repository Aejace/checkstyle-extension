package halsteadOperandsPackage;

import com.puppycrawl.tools.checkstyle.api.*;

public class HalsteadOperandsCheck extends AbstractCheck {

	private int count = 0;
	private String message = "Operands Count: ";
	
	int[] tokens = new int[] {TokenTypes.CHAR_LITERAL,
			TokenTypes.IDENT,
			TokenTypes.LITERAL_BOOLEAN,
			TokenTypes.LITERAL_BYTE,
			TokenTypes.LITERAL_CHAR,
			TokenTypes.LITERAL_DOUBLE,
			TokenTypes.LITERAL_FLOAT,
			TokenTypes.LITERAL_INT,
			TokenTypes.LITERAL_LONG,
			TokenTypes.LITERAL_SHORT,
			TokenTypes.LITERAL_VOID,
			TokenTypes.NUM_DOUBLE,
			TokenTypes.NUM_FLOAT,
			TokenTypes.NUM_INT,
			TokenTypes.NUM_LONG,
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
