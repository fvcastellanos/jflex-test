package org.umg.jflex.lexer.pascal;

public enum PascalSymbol {

	AP(512),
	DIVIDE(18),
	CHAR(37),
	SEMI(19),
	INT(35),
	ARRAY(3),
	LESS(27),
	MINUS(17),
	AND(2),
	TYPE(13),
	OR(9),
	COMMA(20),
	BEGIN(4),
	PLUS(16),
	IF(7),
	DOT(33),
	OF(8),
	EOF(0),
	GTR(26),
	error(1),
	PROGRAM(10),
	LEFT_BRKT(23),
	RT_PAREN(22),
	IDENT(34),
	EQ(25),
	ASSMNT(32),
	REAL(36),
	TIMES(15),
	COLON(31),
	ELSE(5),
	NOT_EQ(30),
	LESS_EQ(28),
	RT_BRKT(24),
	THEN(12),
	END(6),
	LEFT_PAREN(21),
	GTR_EQ(29),
	VAR(14),
	PROCEDURE(11),
	UNDEFINED(1000);
	
	private int value;
	
	private PascalSymbol(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
}
