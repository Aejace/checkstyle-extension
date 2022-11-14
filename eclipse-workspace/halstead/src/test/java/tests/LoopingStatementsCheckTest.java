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

import loopingStatementsPackage.LoopingStatementsCheck;
import resources.TokenLists;

class LoopingStatementsCheckTest {

	private int[] tokens;
	
	public LoopingStatementsCheckTest()
	{
		TokenLists tokenLists = new TokenLists();
		tokens = tokenLists.getLoopingStatements();
	}
	
	@Test
	void getDefaultTokensTest() {
		LoopingStatementsCheck spyCheck = spy(LoopingStatementsCheck.class);
		assertArrayEquals(tokens, spyCheck.getDefaultTokens()); 
	}
	
	@Test
	void getAcceptableTokensTest() {
		LoopingStatementsCheck spyCheck = spy(LoopingStatementsCheck.class);
		assertArrayEquals(tokens, spyCheck.getAcceptableTokens()); 
	}

	@Test
	void getRequiredTokensTest() {
		LoopingStatementsCheck spyCheck = spy(LoopingStatementsCheck.class);
		assertArrayEquals(tokens, spyCheck.getRequiredTokens()); 
	}

	@Test
	void beginTreeTest() {
		LoopingStatementsCheck spyCheck = spy(LoopingStatementsCheck.class);
		DetailAST mockRoot = mock(DetailAST.class);
		spyCheck.beginTree(mockRoot);
		verify(spyCheck, times(1)).beginTree(mockRoot);
	}
	
	@Test
	void visitTokenTest() {
		LoopingStatementsCheck spyCheck = spy(LoopingStatementsCheck.class);
		DetailAST mockToken = mock(DetailAST.class);
		spyCheck.visitToken(mockToken);
		verify(spyCheck, times(1)).visitToken(mockToken);
	}
	
	@Test
	void finishTreeTest() {
		LoopingStatementsCheck spyCheck = spy(LoopingStatementsCheck.class);
		DetailAST aAST = mock(DetailAST.class);
		doNothing().when(spyCheck).log(anyInt(), anyString());
		spyCheck.finishTree(aAST);
		verify(spyCheck, times(1)).finishTree(aAST);	
	}
}
