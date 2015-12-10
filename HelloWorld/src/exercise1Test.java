import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class exercise1Test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		exercise1 exerTest = new exercise1();
		byte[] expBuff1 = {100,97,111,105,117,104,102,100,111,97,104,111,110,111,97,100,110,111,110};
		try {
			assertArrayEquals(expBuff1, exerTest.file2buf("D:/test1.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		byte[] expBuff2 = {};
		try {
			assertArrayEquals(expBuff2, exerTest.file2buf("D:/test2.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*byte[] expBuff3 = {};
		try {
			assertArrayEquals(expBuff3, exerTest.file2buf("D:/test3.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
}
