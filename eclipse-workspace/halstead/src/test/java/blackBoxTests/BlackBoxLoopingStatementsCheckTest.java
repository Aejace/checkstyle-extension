package blackBoxTests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.DefaultConfiguration;
import com.puppycrawl.tools.checkstyle.DefaultContext;
import com.puppycrawl.tools.checkstyle.JavaParser;
import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.FileContents;
import com.puppycrawl.tools.checkstyle.api.FileText;
import com.puppycrawl.tools.checkstyle.api.LocalizedMessage;

import loopingStatementsPackage.LoopingStatementsCheck;

class BlackBoxLoopingStatementsCheckTest {

	@Test
	void test() throws IOException, CheckstyleException 
	{
		// Build File
		String filePath = "src/test/resources/blackBoxTestFiles/";
		File file = new File(filePath + "BlackBoxLoopingStatementsFile.java");
		FileText ft = new FileText(file,"UTF-8");
		FileContents fc = new FileContents(ft);
		
		// Fill AST with FileContents
		DetailAST root = JavaParser.parse(fc);
		
		// Initialize Intended Check
		LoopingStatementsCheck check = new LoopingStatementsCheck();
		
		// Configure Check
		check.configure(new DefaultConfiguration("Local"));
		check.contextualize(new DefaultContext());
		
		// Initialize Local Variables in Check
		check.beginTree(root);
		
		// Check initialization count is zero
		Hashtable<String,Integer> results = check.getResults();
		assertEquals(0, results.get("Looping statements count: "));
		
		// Visit Each Token in Tree
		walkTree(check,root);
		
		// Check results before calling finish tree and resetting the count
		results = check.getResults();
		assertEquals(3, results.get("Looping statements count: "));
		
		// Complete tree and display intended logs to user.
		check.finishTree(root);
		
		for(LocalizedMessage lm : check.getMessages()) {
			System.out.println(lm.getMessage());
		}
		
		// Verify clean up
		results = check.getResults();
		assertEquals(0, results.get("Looping statements count: "));
		System.out.println("LoopingStatementsCheck Done!");
		
	}
	
	private void walkTree(AbstractCheck check, DetailAST token) 
	{
		int[] defaultTokens = check.getDefaultTokens();
		while(token != null) 
		{
			int tokenType = token.getType();
			for(int i = 0; i < defaultTokens.length; ++i)
			{
				if (defaultTokens[i] == tokenType)
				{
					check.visitToken(token);
					break;
				}
			}
			
			walkTree(check, token.getFirstChild());
			token = token.getNextSibling();
		}
	}
}


