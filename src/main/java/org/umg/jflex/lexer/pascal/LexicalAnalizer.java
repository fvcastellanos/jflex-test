package org.umg.jflex.lexer.pascal;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java_cup.runtime.Symbol;

public class LexicalAnalizer {
	
	private Logger logger = LoggerFactory.getLogger(LexicalAnalizer.class);
	
	public List<Token> analizeFile(File file) throws Exception {
		
		List<Token> tokens = new ArrayList<Token>();
		
		String fileName = file.getName();
		FileReader fileReader = null;
		
		try {
			logger.info("analyzing file: {}", fileName);
			fileReader = new FileReader(file);
			
			PascalLexer lexer = new PascalLexer(fileReader);
			
			Symbol symbol = lexer.next_token();
			
			while (symbol.sym != 0) {
				symbol = lexer.next_token();
				
				logger.info("token found: {}", symbol.value);
				tokens.add(new Token(symbol.sym, symbol.value!=null?symbol.value.toString():"", 
						symbol.right, symbol.left));
				
			}
		} catch (Exception ex) {
			logger.error("Unable to parse file: {}, {}", fileName, ex);
		} finally {
			if (fileReader != null) {
				fileReader.close();
			}
		}
		
		return(tokens);
	}
}
