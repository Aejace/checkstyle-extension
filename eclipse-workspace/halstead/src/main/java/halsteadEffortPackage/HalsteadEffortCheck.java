package halsteadEffortPackage;

import java.util.HashMap;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import basicCountingPackage.BasicCountingCheck;
import resources.TokenLists;

public class HalsteadEffortCheck extends BasicCountingCheck 
{
	private String message = "Halstead Effort: ";
	int[] operatorTokenTypes;
	int[] operandTokenTypes;
	private final int[] tokens;
	private HashMap<Integer, Integer> operatorDictionary = new HashMap<Integer, Integer>();
	private HashMap<Integer, Integer> operandDictionary = new HashMap<Integer, Integer>();
	
	public HalsteadEffortCheck()
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
			operatorDictionary.put(key, operatorDictionary.getOrDefault(key, 0) + 1);
		}
	}
	
	@Override
	public void finishTree(DetailAST aAST)
	{
		int operators = 0;
		for (int value : operatorDictionary.values()) 
		{
		    operators += value;
		}
		
		int operands = 0;
		for (int value : operandDictionary.values()) 
		{
		    operands += value;
		}
		
		int uniqueOperators = operatorDictionary.size();
		
		int uniqueOperands = operandDictionary.size();
		
		int hLength = operators + operands;
		
		int hVocab = uniqueOperators + uniqueOperands;
		
		int logTwo = 0;
		while (hVocab > 0)
		{
			hVocab = hVocab >> 1;
			logTwo++;
		}
		int hVolume = hLength * logTwo;
		
		double hDifficulty = ((uniqueOperators / 2) * operands) / uniqueOperands;
		
		double hEffort = hDifficulty * hVolume;
		
		result = hEffort;
		log(aAST.getLineNo(), message + hEffort + " -AJ");
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
