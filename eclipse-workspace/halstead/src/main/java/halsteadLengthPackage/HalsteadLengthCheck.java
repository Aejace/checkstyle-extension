package halsteadLengthPackage;

import com.puppycrawl.tools.checkstyle.api.*;

public class HalsteadLengthCheck extends AbstractCheck 
{
	private int length = 0;
	private String message = "Halstead Length: ";
	
	int[] tokens = new int[] {TokenTypes.ARRAY_DECLARATOR,
			TokenTypes.ASSIGN,
			TokenTypes.BAND,
			TokenTypes.BAND_ASSIGN,
			TokenTypes.BNOT,
			TokenTypes.BOR,
			TokenTypes.BOR_ASSIGN,
			TokenTypes.BSR,
			TokenTypes.BSR_ASSIGN,
			TokenTypes.BXOR,
			TokenTypes.BXOR_ASSIGN,
			TokenTypes.COLON,
			TokenTypes.COMMA,
			TokenTypes.CTOR_CALL,
			TokenTypes.DEC,
			TokenTypes.DIV,
			TokenTypes.DIV_ASSIGN,
			TokenTypes.DOT,
			TokenTypes.DOUBLE_COLON,
			TokenTypes.EQUAL,
			TokenTypes.GE,
			TokenTypes.GT,
			TokenTypes.INC,
			TokenTypes.INDEX_OP,
			TokenTypes.INSTANCE_INIT,
			TokenTypes.LAMBDA,
			TokenTypes.LAND,
			TokenTypes.LCURLY,
			TokenTypes.LE,
			TokenTypes.LITERAL_ASSERT,
			TokenTypes.LITERAL_BREAK,
			TokenTypes.LITERAL_CASE,
			TokenTypes.LITERAL_CATCH,
			TokenTypes.LITERAL_CONTINUE,
			TokenTypes.LITERAL_DEFAULT,
			TokenTypes.LITERAL_DO,
			TokenTypes.LITERAL_FINALLY,
			TokenTypes.LITERAL_FOR,
			TokenTypes.LITERAL_IF,
			TokenTypes.LITERAL_INSTANCEOF,
			TokenTypes.LITERAL_RETURN,
			TokenTypes.LITERAL_SWITCH,
			TokenTypes.LITERAL_SYNCHRONIZED,
			TokenTypes.LITERAL_THROW,
			TokenTypes.LITERAL_TRY,
			TokenTypes.LITERAL_WHILE,
			TokenTypes.LNOT,
			TokenTypes.LOR,
			TokenTypes.LPAREN,
			TokenTypes.LT,
			TokenTypes.METHOD_CALL,
			TokenTypes.MINUS,
			TokenTypes.MINUS_ASSIGN,
			TokenTypes.MOD,
			TokenTypes.MOD_ASSIGN,
			TokenTypes.NOT_EQUAL,
			TokenTypes.PLUS,
			TokenTypes.PLUS_ASSIGN,
			TokenTypes.POST_DEC,
			TokenTypes.POST_INC,
			TokenTypes.QUESTION,
			TokenTypes.SEMI,
			TokenTypes.SL,
			TokenTypes.SL_ASSIGN,
			TokenTypes.SR,
			TokenTypes.SR_ASSIGN,
			TokenTypes.STAR,
			TokenTypes.STAR_ASSIGN,
			TokenTypes.SUPER_CTOR_CALL,
			TokenTypes.TYPE_EXTENSION_AND,
			TokenTypes.TYPECAST,
			TokenTypes.UNARY_MINUS,
			TokenTypes.UNARY_PLUS,
			TokenTypes.CHAR_LITERAL,
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
