import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @ClassName: Int2HexTest
 * @Discription: TODO(������һ�仰��������������)
 * @author shizhp
 * @date: 2015��12��11�� ����11:53:31 <br/>
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
		assertEquals("0", int2HexTest.int2Hex(0));//����0���������
		assertEquals("1", int2HexTest.int2Hex(1));//һλ���߽����
		assertEquals("-1", int2HexTest.int2Hex(-1));//����һλ���߽����
		assertEquals("9", int2HexTest.int2Hex(9));//һλ���߽����
		assertEquals("-9", int2HexTest.int2Hex(-9));//����һλ���߽����
		assertEquals("A", int2HexTest.int2Hex(10));//һλ���߽�ת������
		assertEquals("-A", int2HexTest.int2Hex(-10));//����һλ���߽����
		assertEquals("F", int2HexTest.int2Hex(15));//һλʮ�����Ʊ߽����
		assertEquals("-F", int2HexTest.int2Hex(-15));//����һλʮ�����Ʊ߽����
		assertEquals("10", int2HexTest.int2Hex(16));//��λʮ�����Ʊ߽����
		assertEquals("-10", int2HexTest.int2Hex(-16));//������λλʮ�����Ʊ߽����
		assertEquals("FF", int2HexTest.int2Hex(255));//��λʮ�����Ʊ߽����
		assertEquals("-FF", int2HexTest.int2Hex(-255));//������λʮ�����Ʊ߽����
		assertEquals("100", int2HexTest.int2Hex(256));//��λʮ�����Ʊ߽����
		assertEquals("-100", int2HexTest.int2Hex(-256));//������λʮ�����Ʊ߽����
		assertEquals("7FFFFFFF", int2HexTest.int2Hex(Integer.MAX_VALUE));//�߽�ֵ���ֵ����2147483647
		assertEquals("-80000000", int2HexTest.int2Hex(Integer.MIN_VALUE));//�����߽�ֵ��Сֵ����-2147483648
	}

}
