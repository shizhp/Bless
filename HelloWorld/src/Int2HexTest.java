import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @ClassName: Int2HexTest
 * @Discription: TODO(这里用一句话描述这个类的作用)
 * @author shizhp
 * @date: 2015年12月11日 上午11:53:31 <br/>
 *
 */
public class Int2HexTest {

	private Int2Hex int2HexTest = new Int2Hex();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * @Title :testInt2Hex
	 * @Description :TODO(implete the junit of int2Hex,consider the boundary/0/negtive special case  )
	 * @para :
	 * @return :void
	 * @throws
	 */
	@Test
	public void testInt2Hex() {
		assertEquals("0", int2HexTest.int2Hex(0));//考虑0的特殊情况
		assertEquals("1", int2HexTest.int2Hex(1));//一位数边界测试
		assertEquals("-1", int2HexTest.int2Hex(-1));//负数一位数边界测试
		assertEquals("9", int2HexTest.int2Hex(9));//一位数边界测试
		assertEquals("-9", int2HexTest.int2Hex(-9));//负数一位数边界测试
		assertEquals("A", int2HexTest.int2Hex(10));//一位数边界转换测试
		assertEquals("-A", int2HexTest.int2Hex(-10));//负数一位数边界测试
		assertEquals("F", int2HexTest.int2Hex(15));//一位十六进制边界测试
		assertEquals("-F", int2HexTest.int2Hex(-15));//负数一位十六进制边界测试
		assertEquals("10", int2HexTest.int2Hex(16));//两位十六进制边界测试
		assertEquals("-10", int2HexTest.int2Hex(-16));//负数两位位十六进制边界测试
		assertEquals("FF", int2HexTest.int2Hex(255));//两位十六进制边界测试
		assertEquals("-FF", int2HexTest.int2Hex(-255));//负数两位十六进制边界测试
		assertEquals("100", int2HexTest.int2Hex(256));//三位十六进制边界测试
		assertEquals("-100", int2HexTest.int2Hex(-256));//负数三位十六进制边界测试
		assertEquals("7FFFFFFF", int2HexTest.int2Hex(Integer.MAX_VALUE));//边界值最大值测试2147483647
		assertEquals("-80000000", int2HexTest.int2Hex(Integer.MIN_VALUE));//负数边界值最小值测试-2147483648
	}

}
