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

import linesOfCommentsPackage.LinesOfCommentsCheck;
import resources.TokenLists;

class LinesOfCommentsCheckTest {

	private int[] tokens;
	
	public LinesOfCommentsCheckTest()
	{
		TokenLists tokenLists = new TokenLists();
		tokens = tokenLists.getCommentLines();
	}
	
	@Test
	void getDefaultTokensTest() {
		LinesOfCommentsCheck spyCheck = spy(LinesOfCommentsCheck.class);
		assertArrayEquals(tokens, spyCheck.getDefaultTokens()); 
	}
	
	@Test
	void getAcceptableTokensTest() {
		LinesOfCommentsCheck spyCheck = spy(LinesOfCommentsCheck.class);
		assertArrayEquals(tokens, spyCheck.getAcceptableTokens()); 
	}

	@Test
	void getRequiredTokensTest() {
		LinesOfCommentsCheck spyCheck = spy(LinesOfCommentsCheck.class);
		assertArrayEquals(tokens, spyCheck.getRequiredTokens()); 
	}

	@Test
	void beginTreeTest() {
		LinesOfCommentsCheck spyCheck = spy(LinesOfCommentsCheck.class);
		DetailAST mockRoot = mock(DetailAST.class);
		spyCheck.beginTree(mockRoot);
		verify(spyCheck, times(1)).beginTree(mockRoot);
	}
	
	@Test
	void visitTokenTest() {
		LinesOfCommentsCheck spyCheck = spy(LinesOfCommentsCheck.class);
		DetailAST mockToken = mock(DetailAST.class);
		spyCheck.visitToken(mockToken);
		verify(spyCheck, times(1)).visitToken(mockToken);
	}
	
	@Test
	void finishTreeTest() {
		LinesOfCommentsCheck spyCheck = spy(LinesOfCommentsCheck.class);
		DetailAST aAST = mock(DetailAST.class);
		doNothing().when(spyCheck).log(anyInt(), anyString());
		spyCheck.finishTree(aAST);
		verify(spyCheck, times(1)).finishTree(aAST);	
	}
}
