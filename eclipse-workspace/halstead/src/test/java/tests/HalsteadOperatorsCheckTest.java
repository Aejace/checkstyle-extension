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

import halsteadOperatorsPackage.HalsteadOperatorsCheck;
import resources.TokenLists;

class HalsteadOperatorsCheckTest {

	private int[] tokens;
	
	public HalsteadOperatorsCheckTest()
	{
		TokenLists tokenLists = new TokenLists();
		tokens = tokenLists.getOperators();
	}
	
	@Test
	void getDefaultTokensTest() {
		HalsteadOperatorsCheck spyCheck = spy(HalsteadOperatorsCheck.class);
		assertArrayEquals(tokens, spyCheck.getDefaultTokens()); 
	}
	
	@Test
	void getAcceptableTokensTest() {
		HalsteadOperatorsCheck spyCheck = spy(HalsteadOperatorsCheck.class);
		assertArrayEquals(tokens, spyCheck.getAcceptableTokens()); 
	}

	@Test
	void getRequiredTokensTest() {
		HalsteadOperatorsCheck spyCheck = spy(HalsteadOperatorsCheck.class);
		assertArrayEquals(tokens, spyCheck.getRequiredTokens()); 
	}

	@Test
	void beginTreeTest() {
		HalsteadOperatorsCheck spyCheck = spy(HalsteadOperatorsCheck.class);
		DetailAST mockRoot = mock(DetailAST.class);
		spyCheck.beginTree(mockRoot);
		verify(spyCheck, times(1)).beginTree(mockRoot);
	}
	
	@Test
	void visitTokenTest() {
		HalsteadOperatorsCheck spyCheck = spy(HalsteadOperatorsCheck.class);
		DetailAST mockToken = mock(DetailAST.class);
		spyCheck.visitToken(mockToken);
		verify(spyCheck, times(1)).visitToken(mockToken);
	}
	
	@Test
	void finishTreeTest() {
		HalsteadOperatorsCheck spyCheck = spy(HalsteadOperatorsCheck.class);
		DetailAST aAST = mock(DetailAST.class);
		doNothing().when(spyCheck).log(anyInt(), anyString());
		spyCheck.finishTree(aAST);
		verify(spyCheck, times(1)).finishTree(aAST);	
	}
}
