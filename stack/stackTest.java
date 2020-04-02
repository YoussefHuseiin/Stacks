package eg.edu.alexu.csd.datastructure.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class stackTest {

	@Test
	void testStack() {
		stack s = new stack();
		s.push(1);
		s.push("a");
		s.push("c");
		assertEquals("c",s.pop());
		assertEquals("a",s.peek());
		assertEquals(2,s.size());
		assertFalse(s.isEmpty());
		assertThrows(NullPointerException.class,()->s.push(null));
		assertEquals("a",s.pop());
		assertEquals(1,s.pop());
        assertThrows(RuntimeException.class,()->s.peek());
        assertThrows(RuntimeException.class,()->s.pop());
        assertTrue(s.isEmpty());
        assertEquals(0,s.size());
        
}
}