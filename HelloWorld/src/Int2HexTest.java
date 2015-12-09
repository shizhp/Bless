import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Int2HexTest {
	
	private Int2Hex int2HexTest = new Int2Hex();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInt2Hex() {
		assertEquals("0", int2HexTest.int2Hex(0));//
		assertEquals("1", int2HexTest.int2Hex(1));
		assertEquals("-1", int2HexTest.int2Hex(-1));
		assertEquals("F", int2HexTest.int2Hex(15));
		assertEquals("-F", int2HexTest.int2Hex(-15));
		assertEquals("FF", int2HexTest.int2Hex(255));
		assertEquals("-FF", int2HexTest.int2Hex(-255));
		assertEquals("100", int2HexTest.int2Hex(256));
		assertEquals("-100", int2HexTest.int2Hex(-256));
		assertEquals("-100", int2HexTest.int2Hex(-256));
		//fail("Not yet implemented");
	}

}
