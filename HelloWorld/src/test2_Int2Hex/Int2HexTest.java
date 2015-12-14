package test2_Int2Hex;
import static org.junit.Assert.*;
import org.junit.Test;

/**该{@code Int2HexTest}类主要对Int2Hex进行单元测试
 * @author shizhp
 * @data 2015年12月14日
 */
public class Int2HexTest {
	private Int2Hex int2HexTest = new Int2Hex();
	/** 主要测试负数，0，以及边界值 */
	@Test
	public void testInt2Hex() {
		assertEquals("0", int2HexTest.int2Hex(0));
		assertEquals("1", int2HexTest.int2Hex(1));
		assertEquals("-1", int2HexTest.int2Hex(-1));
		assertEquals("9", int2HexTest.int2Hex(9));
		assertEquals("-9", int2HexTest.int2Hex(-9));
		assertEquals("A", int2HexTest.int2Hex(10));
		assertEquals("-A", int2HexTest.int2Hex(-10));
		assertEquals("F", int2HexTest.int2Hex(15));
		assertEquals("-F", int2HexTest.int2Hex(-15));
		assertEquals("10", int2HexTest.int2Hex(16));
		assertEquals("-10", int2HexTest.int2Hex(-16));
		assertEquals("FF", int2HexTest.int2Hex(255));
		assertEquals("-FF", int2HexTest.int2Hex(-255));
		assertEquals("100", int2HexTest.int2Hex(256));
		assertEquals("-100", int2HexTest.int2Hex(-256));
		assertEquals("7FFFFFFF", int2HexTest.int2Hex(Integer.MAX_VALUE));
		assertEquals("-80000000", int2HexTest.int2Hex(Integer.MIN_VALUE));
	}
	@Test
	public void testInt2Hex2() {
		assertEquals("0", int2HexTest.int2Hex2(0));
		assertEquals("1", int2HexTest.int2Hex2(1));
		assertEquals("-1", int2HexTest.int2Hex2(-1));
		assertEquals("9", int2HexTest.int2Hex2(9));
		assertEquals("-9", int2HexTest.int2Hex2(-9));
		assertEquals("A", int2HexTest.int2Hex2(10));
		assertEquals("-A", int2HexTest.int2Hex2(-10));
		assertEquals("F", int2HexTest.int2Hex2(15));
		assertEquals("-F", int2HexTest.int2Hex2(-15));
		assertEquals("10", int2HexTest.int2Hex2(16));
		assertEquals("-10", int2HexTest.int2Hex2(-16));
		assertEquals("FF", int2HexTest.int2Hex2(255));
		assertEquals("-FF", int2HexTest.int2Hex2(-255));
		assertEquals("100", int2HexTest.int2Hex2(256));
		assertEquals("-100", int2HexTest.int2Hex2(-256));
		assertEquals("7FFFFFFF", int2HexTest.int2Hex2(Integer.MAX_VALUE));
		assertEquals("-80000000", int2HexTest.int2Hex2(Integer.MIN_VALUE));
	}
}
