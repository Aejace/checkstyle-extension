package blackBoxTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import halsteadOperandsPackage.HalsteadOperandsCheck;

public class BlackBoxHalsteadOperandsCheckTest 
{
	@Test
	public void testMetric() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles/BlackBoxBasicMetricFile.java";
		HalsteadOperandsCheck check = new HalsteadOperandsCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(56, result);
	}
	
	@Test
	public void testMinimumOperands() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles/BlackBoxBasicFile.java";
		HalsteadOperandsCheck check = new HalsteadOperandsCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(2, result);
	}
	
	@Test
	public void testUnaryOperands() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles/blackBoxHalsteadOperandsTests/BlackBoxUnaryOperandsFile.java";
		HalsteadOperandsCheck check = new HalsteadOperandsCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(6, result);
	}

}
