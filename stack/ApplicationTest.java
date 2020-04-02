package eg.edu.alexu.csd.datastructure.stack;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;

class ApplicationTest {
 @Test
 void TestApplication() {
	 Application test = new Application();
	 assertEquals("2 3 4 * +",test.infixToPostfix("2 + 3 * 4"));
	 assertEquals("a b * 5 +",test.infixToPostfix("a * b + 5"));
	 assertEquals("1 2 + 7 *",test.infixToPostfix("(1 + 2) * 7"));
	 assertEquals("a b * c /",test.infixToPostfix("a * b / c"));
	 assertEquals("a b c - d + / e a - * c *",test.infixToPostfix("(a / (b - c + d)) * (e - a) * c"));
	 assertEquals("a b / c - d e * + a c * -",test.infixToPostfix("a / b - c + d * e - a * c"));
	 assertEquals("0 20 - 6 +",test.infixToPostfix("-20+6"));
	 assertEquals("0 7 - 0 2 - / 7 2 / +",test.infixToPostfix("(-7/-2)+(7/2)"));
	 assertEquals("a b 0 c - - d + / e a - * c *",test.infixToPostfix("(a/ (b - -c + d)) * (e -a)*c"));
	 assertEquals("20 2 6 * 16 4 - / +",test.infixToPostfix("20+2*6/(16-4)"));
	 assertEquals("0 1 - 0 2 - + 4 * 3 +",test.infixToPostfix("(-1+-2)*4+3"));
	 assertEquals("4 0 30 - 0 50 - * 0 7 - 0 6 - * + *",test.infixToPostfix("4*( -30 * -50 + -7 * -6)"));
	 assertThrows(RuntimeException.class,()->test.infixToPostfix("ab +c / 5"));
	 assertThrows(RuntimeException.class,()->test.infixToPostfix("a5 +2 / 1"));
	 assertThrows(RuntimeException.class,()->test.infixToPostfix("3b +c / 11"));
	 assertEquals(8,test.evaluate("6 2 / 3 - 4 2 * +"));
	 assertEquals(14,test.evaluate("2 3 4 * +"));
	 assertEquals(21,test.evaluate("1 2 + 7 *"));
	 assertEquals(-14,test.evaluate("0 20 - 6 +"));
	 assertEquals(7,test.evaluate("0 7 - 0 2 - / 7 2 / +"));
	 assertEquals(-9,test.evaluate("0 1 - 0 2 - + 4 * 3 +"));
	 assertThrows(RuntimeException.class,()->test.evaluate("a b 5 * +"));
	 assertThrows(EmptyStackException.class,()->test.evaluate("2 3 * + 4 -"));
	 
	 

	 
 }

}
