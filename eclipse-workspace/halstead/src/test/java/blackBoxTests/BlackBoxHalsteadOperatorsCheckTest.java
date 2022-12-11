package blackBoxTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import halsteadOperatorsPackage.HalsteadOperatorsCheck;

public class BlackBoxHalsteadOperatorsCheckTest 
{
	@Test
	public void testMetric() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles/BlackBoxBasicMetricFile.java";
		HalsteadOperatorsCheck check = new HalsteadOperatorsCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(39, result);
	}
	
	@Test
	public void testMinimumOperators() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles/BlackBoxBasicFile.java";
		HalsteadOperatorsCheck check = new HalsteadOperatorsCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(2, result);
	}
	
	@Test
	public void testNestedIfElse() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles/blackBoxHalsteadOperatorsTests/BlackBoxNestedIfElseFile.java";
		HalsteadOperatorsCheck check = new HalsteadOperatorsCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(37, result);
	}

}
