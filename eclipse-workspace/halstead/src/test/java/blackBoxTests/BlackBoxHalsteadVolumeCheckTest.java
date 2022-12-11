package blackBoxTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.puppycrawl.tools.checkstyle.api.CheckstyleException;

import halsteadVolumePackage.HalsteadVolumeCheck;

public class BlackBoxHalsteadVolumeCheckTest 
{
	@Test
	public void testMetric() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles/BlackBoxBasicMetricFile.java";
		HalsteadVolumeCheck check = new HalsteadVolumeCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(475, result);
	}
	
	@Test
	public void testMinimumVolume() throws IOException, CheckstyleException 
	{
		String filePath = "src/test/resources/blackBoxTestFiles/BlackBoxBasicFile.java";
		HalsteadVolumeCheck check = new HalsteadVolumeCheck();
		BlackBoxTestEngine engine = new BlackBoxTestEngine(check, filePath);
		Number result = engine.testFile();
		assertEquals(8, result);
	}

}
