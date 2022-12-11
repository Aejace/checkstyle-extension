package blackBoxTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import halsteadEffortPackage.HalsteadEffortCheck;

public class BlackBoxHalsteadEffortCheckTest 
{
	@Test
	public void testMetric() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles/BlackBoxBasicMetricFile.java";
		HalsteadEffortCheck check = new HalsteadEffortCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(30875.0, result);
	}
	
	@Test
	public void testMinimumEffort() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles/BlackBoxBasicFile.java";
		HalsteadEffortCheck check = new HalsteadEffortCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(16.0, result);
	}
}
