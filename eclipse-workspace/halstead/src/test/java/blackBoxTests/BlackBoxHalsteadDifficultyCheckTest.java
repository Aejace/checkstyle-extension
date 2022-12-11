package blackBoxTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import halsteadDifficultyPackage.HalsteadDifficultyCheck;

public class BlackBoxHalsteadDifficultyCheckTest 
{
	@Test
	public void testRepeatedTokens() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles/blackBoxHalsteadDifficultyTests/BlackBoxRepeatedTokensFile.java";
		HalsteadDifficultyCheck check = new HalsteadDifficultyCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(9.0, result);
	}
	
	@Test
	public void testMinimumDifficulty() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles/BlackBoxBasicFile.java";
		HalsteadDifficultyCheck check = new HalsteadDifficultyCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(2.0, result);
	}
	
	@Test
	public void testMetric() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles/BlackBoxBasicMetricFile.java";
		HalsteadDifficultyCheck check = new HalsteadDifficultyCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(65.0, result);
	}


}
