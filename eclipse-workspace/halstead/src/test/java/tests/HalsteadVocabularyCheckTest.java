package tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.DetailAST;

import halsteadVocabularyPackage.HalsteadVocabularyCheck;
import resources.TokenLists;

class HalsteadVocabularyCheckTest {

	private int[] tokens;
	
	public HalsteadVocabularyCheckTest()
	{
		TokenLists tokenLists = new TokenLists();
		int[] operators = tokenLists.getOperators();
		int[] operands = tokenLists.getOperands();
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
	
	@Test
	void getDefaultTokensTest() {
		HalsteadVocabularyCheck spyCheck = spy(HalsteadVocabularyCheck.class);
		assertArrayEquals(tokens, spyCheck.getDefaultTokens()); 
	}
	
	@Test
	void getAcceptableTokensTest() {
		HalsteadVocabularyCheck spyCheck = spy(HalsteadVocabularyCheck.class);
		assertArrayEquals(tokens, spyCheck.getAcceptableTokens()); 
	}

	@Test
	void getRequiredTokensTest() {
		HalsteadVocabularyCheck spyCheck = spy(HalsteadVocabularyCheck.class);
		assertArrayEquals(tokens, spyCheck.getRequiredTokens()); 
	}

	@Test
	void beginTreeTest() {
		HalsteadVocabularyCheck spyCheck = spy(HalsteadVocabularyCheck.class);
		DetailAST mockRoot = mock(DetailAST.class);
		spyCheck.beginTree(mockRoot);
		verify(spyCheck, times(1)).beginTree(mockRoot);
	}
	
	@Test
	void visitTokenTest() {
		HalsteadVocabularyCheck spyCheck = spy(HalsteadVocabularyCheck.class);
		DetailAST mockToken = mock(DetailAST.class);
		spyCheck.visitToken(mockToken);
		verify(spyCheck, times(1)).visitToken(mockToken);
	}
	
	@Test
	void finishTreeTest() {
		HalsteadVocabularyCheck spyCheck = spy(HalsteadVocabularyCheck.class);
		DetailAST aAST = mock(DetailAST.class);
		doNothing().when(spyCheck).log(anyInt(), anyString());
		spyCheck.finishTree(aAST);
		verify(spyCheck, times(1)).finishTree(aAST);	
	}
}
