import static org.junit.Assert.*;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @ClassName: File2BufTest
 * @Discription: TODO(File2Buf junit)
 * @author shizhp
 * @date: 2015年12月11日 上午11:35:38 <br/>
 *
 */
public class File2BufTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	/**
	 * @Title :test
	 * @Description :TODO(这里用一句话描述这个方法的作用)
	 * @para :@throws IOException
	 * @return :void
	 * @throws
	 */
	@Test	
	public void test() throws IOException {
		File2Buf exerTest = new File2Buf();
		byte[] expBuff1 = {100,97,111,105,117,104,102,100,111,97,104,111,110,111,97,100,110,111,110};
		assertArrayEquals(expBuff1, exerTest.file2Buf("D:/test1.txt"));
		byte[] expBuff2 = {};
		assertArrayEquals(expBuff2, exerTest.file2Buf("D:/test2.txt"));
		/*byte[] expBuff3 = {};
		try {
			assertArrayEquals(expBuff3, exerTest.file2buf("D:/test3.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
}
