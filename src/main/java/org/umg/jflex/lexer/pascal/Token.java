package org.umg.jflex.lexer.pascal;

public class Token {
	
	private int id;
	private String value;
	private int column;
	private int line;
	private PascalSymbol pascalSymbol;
	
	public Token(int number, String value, int column, int line) {
		this.id = number;
		this.value = value;
		this.column = column;
		this.line = line;
		this.pascalSymbol = PascalSymbolProvider.getPascalSymbolForId(number);
	}

	public int getId() {
		return id;
	}

	public String getValue() {
		return value;
	}

	public int getColumn() {
		return column;
	}

	public int getLine() {
		return line;
	}

	public PascalSymbol getPascalSymbol() {
		return pascalSymbol;
	}
	
	@Override
	public String toString() {
		return "Token [type=" + pascalSymbol.name() + ", id=" + id + 
				", value=" + value + ", column=" + column + ", line=" + line + "]";
	}

	
	
}
