package org.umg.jflex.lexer.pascal;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PascalLexerTest {
	private Logger logger = LoggerFactory.getLogger(PascalLexerTest.class);
	
	private LexicalAnalizer lexicalAnalizer;
	
	@Before
	public void setup() {
		lexicalAnalizer = new LexicalAnalizer();
	}
	
	@Test
	public void testSimplePascalProgram() throws Exception {

		File file = getSourceFiles("pascal-test.pas");
		List<Token> tokens = lexicalAnalizer.analizeFile(file);
		
		printResult(tokens);
		
		assertNotNull(tokens);
	}
	
	@Test
	public void testRawPascalTokens() throws Exception {

		File file = getSourceFiles("raw-pascal.pas");
		List<Token> tokens = lexicalAnalizer.analizeFile(file);
		
		printResult(tokens);
		
		assertNotNull(tokens);
	}
	
	@Test
	public void testProgramWithSpaces() throws Exception {

		File file = getSourceFiles("hola-mundo.pas");
		List<Token> tokens = lexicalAnalizer.analizeFile(file);
		
		printResult(tokens);
		
		assertNotNull(tokens);
	}

	private File getSourceFiles(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		return new File(classLoader.getResource("source-files/" + fileName).getFile());		
	}
	
	private void printResult(List<Token> tokens) {
		logger.info("Analysis result...");
		tokens.stream()
			.forEach((token) -> {
				logger.info(token.toString());
			});
	}
}
