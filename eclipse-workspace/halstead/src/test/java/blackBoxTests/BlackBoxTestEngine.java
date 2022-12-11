package blackBoxTests;

import java.io.File;
import java.io.IOException;

import com.puppycrawl.tools.checkstyle.DefaultConfiguration;
import com.puppycrawl.tools.checkstyle.DefaultContext;
import com.puppycrawl.tools.checkstyle.JavaParser;
import com.puppycrawl.tools.checkstyle.JavaParser.Options;
import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.CheckstyleException;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.FileContents;
import com.puppycrawl.tools.checkstyle.api.FileText;
import com.puppycrawl.tools.checkstyle.api.LocalizedMessage;

import basicCountingPackage.BasicCountingCheck;

public class BlackBoxTestEngine 
{
	private BasicCountingCheck check;
	private DetailAST root;
	
	public BlackBoxTestEngine(BasicCountingCheck check, String filePath) throws CheckstyleException, IOException
	{
		this.check = check;
		File file = new File(filePath);
		FileText ft = new FileText(file,"UTF-8");
		FileContents fc = new FileContents(ft);
		
		if (check.isCommentNodesRequired()) 
		{
			 root = JavaParser.parseFile(file, Options.WITH_COMMENTS);
		} 
		else 
		{
			 root = JavaParser.parse(fc);
		}
		
		// Configure Check
		this.check.configure(new DefaultConfiguration("Local"));
		this.check.contextualize(new DefaultContext());
	}
	
	public Number testFile()
	{
		// Initialize Local Variables in Check
		check.beginTree(root);
		
		// Visit Each Token in Tree
		walkTree(check,root);
		
		
		// Complete tree and display intended logs to user.
		check.finishTree(root);
		
		// Check results
		Number results = check.getResult();
		
		// Print message
		for(LocalizedMessage lm : check.getMessages()) {
			System.out.println(lm.getMessage());
		}
		
		// Return count from after walking the tree
		return results;
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
