package blackBoxTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import halsteadVocabularyPackage.HalsteadVocabularyCheck;

public class BlackBoxHalsteadVocabularyCheckTest 
{
	@Test
	public void testMetric() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles/BlackBoxBasicMetricFile.java";
		HalsteadVocabularyCheck check = new HalsteadVocabularyCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(20, result);
	}
	
	@Test
	public void testMinimumVocabulary() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles/BlackBoxBasicFile.java";
		HalsteadVocabularyCheck check = new HalsteadVocabularyCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(3, result);
	}
}
