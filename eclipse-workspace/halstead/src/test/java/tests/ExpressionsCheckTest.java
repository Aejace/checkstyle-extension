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

import expressionsPackage.ExpressionsCheck;
import resources.TokenLists;

class ExpressionsCheckTest {
	private int[] tokens;
	
	public ExpressionsCheckTest()
	{
		TokenLists tokenLists = new TokenLists();
		tokens = tokenLists.getExpressions();
	}
	
	@Test
	void getDefaultTokensTest() {
		ExpressionsCheck spyCheck = spy(ExpressionsCheck.class);
		assertArrayEquals(tokens, spyCheck.getDefaultTokens()); 
	}
	
	@Test
	void getAcceptableTokensTest() {
		ExpressionsCheck spyCheck = spy(ExpressionsCheck.class);
		assertArrayEquals(tokens, spyCheck.getAcceptableTokens()); 
	}

	@Test
	void getRequiredTokensTest() {
		ExpressionsCheck spyCheck = spy(ExpressionsCheck.class);
		assertArrayEquals(tokens, spyCheck.getRequiredTokens()); 
	}

	@Test
	void beginTreeTest() {
		ExpressionsCheck spyCheck = spy(ExpressionsCheck.class);
		DetailAST mockRoot = mock(DetailAST.class);
		spyCheck.beginTree(mockRoot);
		verify(spyCheck, times(1)).beginTree(mockRoot);
	}
	
	@Test
	void visitTokenTest() {
		ExpressionsCheck spyCheck = spy(ExpressionsCheck.class);
		DetailAST mockToken = mock(DetailAST.class);
		spyCheck.visitToken(mockToken);
		verify(spyCheck, times(1)).visitToken(mockToken);
	}
	
	@Test
	void finishTreeTest() {
		ExpressionsCheck spyCheck = spy(ExpressionsCheck.class);
		DetailAST aAST = mock(DetailAST.class);
		doNothing().when(spyCheck).log(anyInt(), anyString());
		spyCheck.finishTree(aAST);
		verify(spyCheck, times(1)).finishTree(aAST);	
	}
}
