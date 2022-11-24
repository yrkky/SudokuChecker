import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

//implement tests to test Sudokuverifier with boundary values.  Use templates from Task 1 to derive and document test cases.
	
// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
String c = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
String i = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";

String withSpace = "                                                                                 ";
String repeatingDigit = "123456789123456789123456789123456789123456789123456789123456789123456789123456789";
String negativeNumbers = "-4-1-7-3-6-9-8-2-5-6-3-2-1-5-8-9-4-7-9-5-8-7-2-4-3-1-6-8-2-5-4-3-7-1-6-9-7-9-1-5-8-6-4-3-2-3-4-6-9-1-2-7-5-8-2-8-9-6-4-3-5-7-1-5-7-3-2-9-1-6-8-4-1-6-4-8-7-5-2-9-3";
String invalidDigit = "000000000000000000000000000000000000000000000000000000000000000000000000000000000";
String withExponent = "173698256321589479587243168254371697915864323469127582896435715732916841648752e-10";
String withCharacters = "417E69825632158947958724316825437L6979158643234691275828964357157329I684164875293";
String tooLong = "4173698256321589479587243168254371697915864323469127582896435715732916841648752932";
String tooShort = "41736982563215894795872431682543716979158643234691275828964357157329168416487529";
String repeatingGlobalGridRow = "417469825632158947958723316825437169791586432346912758289643571573291684164875293";
String repeatingGlobalGridColumn = "417369825632158947958724316825437169791586432346912758289643571573291684461875293";
String naughtyUnicode1 = "Ω≈ç√∫˜µ≤≥Ω≈ç√∫˜µ≤≥Ω≈ç√∫˜µ≤≥Ω≈ç√∫˜µ≤≥Ω≈ç√∫˜µ≤≥Ω≈ç√∫˜µ≤≥Ω≈ç√∫˜µ≤≥Ω≈ç√∫˜µ≤≥Ω≈ç√∫˜µ≤≥";
String naughtyUnicode2 = "ด้้้้้็็็็็้้้้้็็็็็้้้้้้้้็็็็็้้้้้็็็็็้้้้้้้้็็็็็้้้้้็็็็็้้้้้้้้็็"+ "\r\n";
String naughtyUnicodeNumbers1 = "１２３１２３１２３１２３１２３１２３１２３１２３１２３１２３１２３１２３１２３１２３１２３１２３１２３１２３１２３１２３１２３１２３１２３１２３１２３１２３１２３";
String naughtyUnicodeNumbers2 = "١٢٣١٢٣١٢٣١٢٣١٢٣١٢٣١٢٣١٢٣١٢٣١٢٣١٢٣١٢٣١٢٣١٢٣١٢٣١٢٣١٢٣١٢٣١٢٣١٢٣١٢٣١٢٣١٢٣١٢٣١٢٣١٢٣١٢٣";
String emojis = "❤💔💌💕💞💓💗💖💘💝💟💜💛💚💙❤💔💌💕💞💓💗💖💘💝💟💜💛💚💙❤💔💌💕💞💓💖💘💟💜💛💙";


SudokuVerifier v = new SudokuVerifier();

	@Test
	public void testCorrectString() {
		int a = v.verify(c);
		assertEquals("correct string", a, 0);
	}

	@Test
	public void testIncorrectString() {
		int a = v.verify(i);
		assertEquals("incorrect string", a, -2);
		
	}
	
	@Test
	public void testRepeatedDigit() {
		int a = v.verify(repeatingDigit);
		assertEquals("incorrect string", a, -2);
	}
	
	@Test
	public void testWhitespace() {
		int a = v.verify(withSpace);
		assertEquals("incorrect string", a, 1);
	}
	
	@Test
	public void testNegativeNumbers() {
		int a = v.verify(negativeNumbers);
		assertEquals("incorrect string", a, -1);
	}
	
	@Test
	public void testTooLong() {
		int a = v.verify(tooLong);
		assertEquals("incorrect string", a, -1);
	}
	
	@Test 
	public void testTooShort() {
		int a = v.verify(tooShort);
		assertEquals("incorrect string", a, -1);
	}
	
	@Test
	public void testWithCharacters() throws NumberFormatException  {
		int a = v.verify(withCharacters);
		assertEquals("incorrect string", a, 1);
	}

	@Test
	public void testInvalidDigit() {
		int a = v.verify(invalidDigit);
		assertEquals("incorrect string", a, -1);
	}
	
	@Test
	public void testWithExponent() {
		int a = v.verify(invalidDigit);
		assertEquals("incorrect string", a, -1);
	}
	
	@Test
	public void testRepeatingDigitRow() {
		int a = v.verify(repeatingGlobalGridRow);
		assertEquals("incorrect string", a, -3);
	}
	
	@Test
	public void testRepeatingDigitColumn() {
		int a = v.verify(repeatingGlobalGridColumn);
		assertEquals("incorrect string", a, -4);
	}
	
	@Test
	public void testNaughtyUnicode1() {
		int a = v.verify(naughtyUnicode1);
		assertEquals("incorrect string", a, 1);
	}
	
	@Test
	public void testNaughtyUnicode2() {
		int a = v.verify(naughtyUnicode2);
		assertEquals("incorrect string", a, -1);
	}
	
	@Test
	public void testNaughtyUnicodeNumbers1() {
		int a = v.verify(naughtyUnicodeNumbers1);
		assertEquals("incorrect string", a, -2);
	}
	
	@Test
	public void testNaughtyUnicodeNumbers2() {
		int a = v.verify(naughtyUnicodeNumbers2);
		assertEquals("incorrect string", a, -2);
	}
	
	@Test
	public void testEmojis() {
		int a = v.verify(emojis);
		assertEquals("incorrect string", a, 1);
	}
	
}
