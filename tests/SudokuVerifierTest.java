import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

//implement tests to test Sudokuverifier with boundary values.  Use templates from Task 1 to derive and document test cases.
	
// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
String c = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
String i = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
String b = "12345678991234567889123456778912345667891234556789123445678912334567891223456789-1";
String d = "117369825632158947958724316825437169791586432346912758289643571573291684164875293";
String e = "714369825632158947958724316825437169791586432346912758289643571573291684164875293";
String f = "017369825632158947958724316825437169791586432346912758289643571573291684164875293";
String g = "417369825632158947958724316825437169791586432346912758589643571273291684164875293";
String h = "Ω17369825632158947958724316825437169791586432346912758289643571573291684164875293";
String j = "a17369825632158947958724316825437169791586432346912758289643571573291684164875293";
String k = "147369825632158947958724316825437169791586432346912758289643571573291684164875293";
String l = "413769825632158947958724316825437169791586432346912758289643571573291684164875293";
String m = "617369825432158947958724316825437169791586432346912758289643571573291684164875293";
String n = "825437169632158947958724316417369825791586432346912758289643571573291684164875293";

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
	public void testLowBoundaryMinus() {
		int a = v.verify(b);
		assertEquals("A sudoku number cannot be below 1", a, -1);
	}
	
	@Test
	public void testSubGridIsValid() {
		int a = v.verify(d);
		assertEquals("A sudoku sub-grid cannot contain duplicate numbers", a, -2);
	}
	
	@Test
	public void testColumnIsValid() {
		int a = v.verify(e);
		assertEquals("A sudoku column cannot contain duplicate numbers", a, -4);
	}
	
	@Test
	public void testLowBoundaryWith0() {
		int a = v.verify(f);
		assertEquals("A sudoku number cannot be below 1", a, -1);
	}
	
	
	@Test
	public void testRowIsValid() {
		int a = v.verify(g);
		assertEquals("A sudoku row cannot contain duplicate numbers", a, -3);
	}
	
	@Test
	public void testIsStringOnlyNumbers() {
		int z = v.verify(j);
		assertEquals("A sudoku game should only contain numbers from 1 to 9. It cannot contain unicode or letters.", z, 1);
		int a = v.verify(h);
		assertEquals("A sudoku game should only contain numbers from 1 to 9. It cannot contain unicode or letters etc.", a, 1);
	}
	
	@Test
	public void testSwap1_2numbers() {
		int a = v.verify(k);
		assertEquals("A sudoku column cannot contain duplicate numbers", a, -4);
	}
	
	//@Test
	//public void testSwap3_4numbers() {
		//int a = v.verify(l);
		//assertEquals("A sudoku column cannot contain duplicate numbers", a, -4);
	//}
	
	@Test
	public void testSwap1_10numbers() {
		int a = v.verify(m);
		assertEquals("A sudoku row cannot contain duplicate numbers", a, -3);
	}
	
	@Test
	public void testSwap1_4rows() {
		int a = v.verify(n);
		assertEquals("A sudoku subgrid cannot contain duplicate numbers", a, -2);

	}
	
	
	

}

// When there are multiple failures, perhaps the verify method
// should return a list of error codes... Multiple failures very
// often occur when playing sudoku. E.g. a player is in violation
// of multiple rules at once due to the layout of the game.
