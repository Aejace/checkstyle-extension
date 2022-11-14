package halsteadVolumePackage;

import java.util.HashMap;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;

import resources.TokenLists;

public class HalsteadVolumeCheck extends AbstractCheck {
	private String message = "Halstead Volume: ";
	private final int[] tokens;
	private HashMap<Integer, Integer> dictionary = new HashMap<Integer, Integer>();
	
	public HalsteadVolumeCheck()
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
		dictionary.put(key, dictionary.getOrDefault(key, 0) + 1);
	}
	
	@Override
	public void finishTree(DetailAST aAST)
	{
		int hVocab = dictionary.size();
		int hLength = 0;
		for (int value : dictionary.values()) {
		    hLength += value;
		}
		int logTwo = 0;
		while (hVocab > 0)
		{
			hVocab = hVocab >> 1;
			logTwo++;
		}
		int hVolume = hLength * logTwo;
		
		log(aAST.getLineNo(), message + hVolume + " -AJ");
		dictionary = new HashMap<Integer, Integer>();
	}
}
