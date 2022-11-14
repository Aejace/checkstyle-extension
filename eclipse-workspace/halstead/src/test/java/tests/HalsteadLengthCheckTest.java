package tests;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import com.puppycrawl.tools.checkstyle.api.DetailAST;

import halsteadLengthPackage.HalsteadLengthCheck;
import resources.TokenLists;

class HalsteadLengthCheckTest {

	private int[] tokens;
	
	public HalsteadLengthCheckTest()
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
		HalsteadLengthCheck spyCheck = spy(HalsteadLengthCheck.class);
		assertArrayEquals(tokens, spyCheck.getDefaultTokens()); 
	}
	
	@Test
	void getAcceptableTokensTest() {
		HalsteadLengthCheck spyCheck = spy(HalsteadLengthCheck.class);
		assertArrayEquals(tokens, spyCheck.getAcceptableTokens()); 
	}

	@Test
	void getRequiredTokensTest() {
		HalsteadLengthCheck spyCheck = spy(HalsteadLengthCheck.class);
		assertArrayEquals(tokens, spyCheck.getRequiredTokens()); 
	}

	@Test
	void beginTreeTest() {
		HalsteadLengthCheck spyCheck = spy(HalsteadLengthCheck.class);
		DetailAST mockRoot = mock(DetailAST.class);
		spyCheck.beginTree(mockRoot);
		verify(spyCheck, times(1)).beginTree(mockRoot);
	}
	
	@Test
	void visitTokenTest() {
		HalsteadLengthCheck spyCheck = spy(HalsteadLengthCheck.class);
		DetailAST mockToken = mock(DetailAST.class);
		spyCheck.visitToken(mockToken);
		verify(spyCheck, times(1)).visitToken(mockToken);
	}
	
	@Test
	void finishTreeTest() {
		HalsteadLengthCheck spyCheck = spy(HalsteadLengthCheck.class);
		DetailAST aAST = mock(DetailAST.class);
		doNothing().when(spyCheck).log(anyInt(), anyString());
		spyCheck.finishTree(aAST);
		verify(spyCheck, times(1)).finishTree(aAST);	
	}
}
