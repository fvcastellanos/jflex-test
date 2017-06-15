package org.umg.jflex.converter;

import java.io.File;

public class JFlexConverter {

	public static void main(String [] args) {
		
		JFlexConverter flexConverter = new JFlexConverter();
	
        File jflexFile = flexConverter.getFlexFile("pascal.jflex");
        JFlex.Main.generate(jflexFile);
    }
	
	public File getFlexFile(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		return new File(classLoader.getResource("flex-files/" + fileName).getFile());		
	}
}
