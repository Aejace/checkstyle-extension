package blackBoxTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import expressionsPackage.ExpressionsCheck;


public class BlackBoxExpressionsCheckTest
{
	@Test
	public void testNoExpressions() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles/BlackBoxBasicFile.java";
		ExpressionsCheck check = new ExpressionsCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(0, result);
	}
	
	@Test
	public void testUnaryOperators() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles/blackBoxExpressionTests/BlackBoxUnaryExpressionsFile.java";
		ExpressionsCheck check = new ExpressionsCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(1, result);
	}
	
	@Test
	public void testSubExpressions() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles/blackBoxExpressionTests/BlackBoxSubExpressionsFile.java";
		ExpressionsCheck check = new ExpressionsCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(1, result);
	}
	
	@Test
	public void testOperatorAssignmentExpressions() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles/blackBoxExpressionTests/BlackBoxOperatorAssignmentExpressionsFile.java";
		ExpressionsCheck check = new ExpressionsCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(3, result);
	}
}
