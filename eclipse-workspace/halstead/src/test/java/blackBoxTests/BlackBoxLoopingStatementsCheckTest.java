package blackBoxTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import loopingStatementsPackage.LoopingStatementsCheck;

class BlackBoxLoopingStatementsCheckTest
{
	@Test
	public void testNoLoops() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles/BlackBoxBasicFile.java";
		LoopingStatementsCheck check = new LoopingStatementsCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(0, result);
	}
	
	@Test
	public void testAllLoopTypes() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles//blackBoxLoopingTests/BlackBoxAllLoopingStatementsFile.java";
		LoopingStatementsCheck check = new LoopingStatementsCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(4, result);
	}
	
	@Test
	public void testNestedLoops() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles//blackBoxLoopingTests/BlackBoxNestedLoopingStatementsFile.java";
		LoopingStatementsCheck check = new LoopingStatementsCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(2, result);
	}
}