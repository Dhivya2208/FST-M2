package junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Activity1 {
		
		static ArrayList<String> list;
		
	   @BeforeEach
		public void setup() {
			list = new ArrayList<String>();
			
			list.add("alpha");
			list.add("beta");
		}
		
	    @Test
		public void insertTest() {
			assertEquals(2, list.size(),"wrong Size");
			list.add(2, "new");
			assertEquals(3, list.size(),"wrong Size");
			
			assertEquals("alpha", list.get(0), "Wrong element");
	        assertEquals("beta", list.get(1), "Wrong element");
	        assertEquals("new", list.get(2), "Wrong element");
		}
		
		@Test
		public void replaceTest() {
			assertEquals(2, list.size(),"wrong Size");
			list.add(1, "new");
			
			assertEquals("alpha", list.get(0), "Wrong element");
	        assertEquals("new", list.get(1), "Wrong element");
		}
}
