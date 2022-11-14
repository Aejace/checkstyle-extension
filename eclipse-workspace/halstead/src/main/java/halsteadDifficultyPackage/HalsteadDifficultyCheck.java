package halsteadDifficultyPackage;

import java.util.HashMap;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;

import resources.TokenLists;

public class HalsteadDifficultyCheck extends AbstractCheck {
	
	private String message = "Halstead Difficulty: ";
	int[] operatorTokenTypes;
	int[] operandTokenTypes;
	private final int[] tokens;
	private HashMap<Integer, Integer> operatorDictionary = new HashMap<Integer, Integer>();
	private HashMap<Integer, Integer> operandDictionary = new HashMap<Integer, Integer>();
	
	public HalsteadDifficultyCheck()
	{
		TokenLists tokenList = new TokenLists();
		operatorTokenTypes = tokenList.getOperators();
		operandTokenTypes = tokenList.getOperands();
		tokens = new int[operatorTokenTypes.length + operandTokenTypes.length];
        int index = 0;
        for (int token : operatorTokenTypes) {
            tokens[index] = token;
            index++;
        }

        for (int token : operandTokenTypes) {
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
		operatorDictionary = new HashMap<Integer, Integer>();
		operandDictionary = new HashMap<Integer, Integer>();
	}
	
	@Override
	public void visitToken(DetailAST aAST) 
	{
		int key = aAST.getType();

		if(contains(key, operandTokenTypes))
		{
			operandDictionary.put(key, operandDictionary.getOrDefault(key, 0) + 1);
		}
		else
		{
			operatorDictionary.put(key, 1);
		}
	}
	
	@Override
	public void finishTree(DetailAST aAST)
	{
		int operands = 0;
		for (int value : operandDictionary.values()) 
		{
		    operands += value;
		} 
		
		int uniqueOperators = operatorDictionary.size();
		
		int uniqueOperands = operandDictionary.size();
		
		double hDifficulty = ((uniqueOperators / 2) * operands) / uniqueOperands;
		
		log(aAST.getLineNo(), message + hDifficulty + " -AJ");
		operatorDictionary = new HashMap<Integer, Integer>();
		operandDictionary = new HashMap<Integer, Integer>();
	}
	
	private boolean contains(int value, int[] array)
	{
		for(int i = 0; i < array.length; ++i)
		{
			if (value == array[i]) {
				return true;
			}
		}
		return false;
	}
	
}
