package blackBoxTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import loopingStatementsPackage.LoopingStatementsCheck;

class BlackBoxLoopingStatementsCheckTest
{
	@Test
	void test() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles/BlackBoxLoopingStatementsFile.java";
		LoopingStatementsCheck check = new LoopingStatementsCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(3, result);
	}
}