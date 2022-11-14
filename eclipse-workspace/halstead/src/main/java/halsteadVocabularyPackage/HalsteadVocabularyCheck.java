package halsteadVocabularyPackage;

import java.util.HashMap;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;

import resources.TokenLists;

public class HalsteadVocabularyCheck extends AbstractCheck {

	private String message = "Halstead Vocabulary: ";
	private final int[] tokens;
	private HashMap<Integer, Integer> dictionary = new HashMap<Integer, Integer>();
	
	public HalsteadVocabularyCheck()
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
		dictionary = new HashMap<Integer, Integer>();
	}
	
	@Override
	public void visitToken(DetailAST aAST) 
	{
		int key = aAST.getType();
		dictionary.put(key, 1);
	}
	
	@Override
	public void finishTree(DetailAST aAST)
	{
		int count = dictionary.size();
		log(aAST.getLineNo(), message + count + " -AJ");
		dictionary = new HashMap<Integer, Integer>();
	}
}
