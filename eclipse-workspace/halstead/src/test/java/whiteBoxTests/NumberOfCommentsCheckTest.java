package whiteBoxTests;

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

import numberOfCommentsPackage.NumberOfCommentsCheck;
import resources.TokenLists;

class NumberOfCommentsCheckTest {

	private int[] tokens;
	
	public NumberOfCommentsCheckTest()
	{
		TokenLists tokenLists = new TokenLists();
		tokens = tokenLists.getComments();
	}
	
	@Test
	void getDefaultTokensTest() {
		NumberOfCommentsCheck spyCheck = spy(NumberOfCommentsCheck.class);
		assertArrayEquals(tokens, spyCheck.getDefaultTokens()); 
	}
	
	@Test
	void getAcceptableTokensTest() {
		NumberOfCommentsCheck spyCheck = spy(NumberOfCommentsCheck.class);
		assertArrayEquals(tokens, spyCheck.getAcceptableTokens()); 
	}

	@Test
	void getRequiredTokensTest() {
		NumberOfCommentsCheck spyCheck = spy(NumberOfCommentsCheck.class);
		assertArrayEquals(tokens, spyCheck.getRequiredTokens()); 
	}

	@Test
	void beginTreeTest() {
		NumberOfCommentsCheck spyCheck = spy(NumberOfCommentsCheck.class);
		DetailAST mockRoot = mock(DetailAST.class);
		spyCheck.beginTree(mockRoot);
		verify(spyCheck, times(1)).beginTree(mockRoot);
	}
	
	@Test
	void visitTokenTest() {
		NumberOfCommentsCheck spyCheck = spy(NumberOfCommentsCheck.class);
		DetailAST mockToken = mock(DetailAST.class);
		spyCheck.visitToken(mockToken);
		verify(spyCheck, times(1)).visitToken(mockToken);
	}
	
	@Test
	void finishTreeTest() {
		NumberOfCommentsCheck spyCheck = spy(NumberOfCommentsCheck.class);
		DetailAST aAST = mock(DetailAST.class);
		doNothing().when(spyCheck).log(anyInt(), anyString());
		spyCheck.finishTree(aAST);
		verify(spyCheck, times(1)).finishTree(aAST);	
	}
}
