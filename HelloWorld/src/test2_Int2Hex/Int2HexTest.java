package test2_Int2Hex;
import static org.junit.Assert.*;
import org.junit.Test;

/**��{@code Int2HexTest}����Ҫ��Int2Hex���е�Ԫ����
 * @author shizhp
 * @data 2015��12��14��
 */
public class Int2HexTest {
	private Int2Hex int2HexTest = new Int2Hex();
	/** ��Ҫ���Ը�����0���Լ��߽�ֵ */
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
