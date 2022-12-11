package blackBoxTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import linesOfCommentsPackage.LinesOfCommentsCheck;

public class BlackBoxLinesOfCommentsCheckTest 
{
	@Test
	public void testMetric() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles/BlackBoxBasicMetricFile.java";
		LinesOfCommentsCheck check = new LinesOfCommentsCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(3, result);
	}
	
	@Test
	public void testNoLines() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles/BlackBoxBasicFile.java";
		LinesOfCommentsCheck check = new LinesOfCommentsCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(0, result);
	}
	
	@Test
	public void testComments() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles/blackBoxCommentTests/BlackBoxCommentTestFile.java";
		LinesOfCommentsCheck check = new LinesOfCommentsCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(7, result);
	}
}
