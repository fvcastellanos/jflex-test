package org.umg.jflex.lexer.pascal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PascalSymbolProvider {

	private static Map<Integer, PascalSymbol> symbolMap;

	public static PascalSymbol getPascalSymbolForId(int id) {
		if (symbolMap == null) {
			symbolMap = buildMap();
		}
		
		if (symbolMap.containsKey(id)) {
			return symbolMap.get(id);
		}
		
		return PascalSymbol.UNDEFINED;
	}
	
	private static Map<Integer, PascalSymbol> buildMap() {
		Map<Integer, PascalSymbol> map = new HashMap<>();
		
		Arrays.asList(PascalSymbol.values())
			.stream()
			.forEach(symbol -> {
				map.put(symbol.getValue(), symbol);
			});
		
		return map;
	}
}
