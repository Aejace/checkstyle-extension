package whiteBoxTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

import halsteadDifficultyPackage.HalsteadDifficultyCheck;

import resources.TokenLists;

class HalsteadDifficultyCheckTest {

	private int[] tokens;
	
	public HalsteadDifficultyCheckTest()
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
		HalsteadDifficultyCheck spyCheck = spy(HalsteadDifficultyCheck.class);
		assertArrayEquals(tokens, spyCheck.getDefaultTokens()); 
	}
	
	@Test
	void getAcceptableTokensTest() {
		HalsteadDifficultyCheck spyCheck = spy(HalsteadDifficultyCheck.class);
		assertArrayEquals(tokens, spyCheck.getAcceptableTokens()); 
	}

	@Test
	void getRequiredTokensTest() {
		HalsteadDifficultyCheck spyCheck = spy(HalsteadDifficultyCheck.class);
		assertArrayEquals(tokens, spyCheck.getRequiredTokens()); 
	}

	@Test
	void beginTreeTest() {
		HalsteadDifficultyCheck spyCheck = spy(HalsteadDifficultyCheck.class);
		DetailAST mockRoot = mock(DetailAST.class);
		spyCheck.beginTree(mockRoot);
		verify(spyCheck, times(1)).beginTree(mockRoot);
	}
	
	@Test
	void visitTokenTest() {
		HalsteadDifficultyCheck spyCheck = spy(HalsteadDifficultyCheck.class);
		DetailAST mockToken = mock(DetailAST.class);
		spyCheck.visitToken(mockToken);
		verify(spyCheck, times(1)).visitToken(mockToken);
	}
	
	@Test
	void finishTreeTest() {
		HalsteadDifficultyCheck spyCheck = spy(HalsteadDifficultyCheck.class);
		DetailAST aAST = mock(DetailAST.class);
		spyCheck.visitToken(aAST);
		when(aAST.getType()).thenReturn(TokenTypes.NUM_INT);
		spyCheck.visitToken(aAST);
		doNothing().when(spyCheck).log(anyInt(), anyString());
		spyCheck.finishTree(aAST);
		verify(spyCheck, times(1)).finishTree(aAST);	
	}

}
