package test3_LevelTree;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;





/**
 * @ClassName: LevelTreeTest
 * @Discription: TODO(对返回树的某一层所有的 节点进行单元测试)
 * @author shizhp
 * @date: 2015年12月11日 下午2:11:00 <br/>
 *
 */
public class LevelTreeTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	

	/**
	 * @Title :testLevelofTreeTreeNodeInt
	 * @Description :TODO(单元测试的主题函数)
	 * @param :@throws Exception
	 * @return :void
	 * @throws
	 */
	@Test
	public void testLevelofTreeTreeNodeInt()throws Exception {
		
		LevelTree levelTreeTest = new LevelTree();
		String testTreeStr = "ABG##H##DC##F##";//对一棵形为A(B(G,H),D(C,F))的树进行测试
		/**
		 * 对空树进行测试：抛出异常
		 */
//		assertEquals("抛出异常",levelTreeTest.getTreeLevelStr(testTreeStr, 1));//空树，抛出异常
		
		/**
		 * 对一棵形为A(,)的树进行测试
		 * 第一层元素为"A"，输入其他层会抛出异常
		 */
		testTreeStr = "A##";//对一棵形为A(,)的树进行测试
		assertEquals("A",levelTreeTest.getTreeLevelStr(testTreeStr, 1));
//		assertEquals("抛出异常",levelTreeTest.getTreeLevelStr(testTreeStr, 2));
		
		/**
		 * 对一棵形为A(,B)的树进行测试
		 * 第一层元素为"A"，第二层元素为"B"输入其他层会抛出异常
		 */
		testTreeStr = "A#B##";//对一棵形为A(,B)的树进行测试
//		assertEquals("抛出异常",levelTreeTest.getTreeLevelStr(testTreeStr, 0));
		assertEquals("A",levelTreeTest.getTreeLevelStr(testTreeStr, 1));
		assertEquals("B",levelTreeTest.getTreeLevelStr(testTreeStr, 2));
//		assertEquals("抛出异常",levelTreeTest.getTreeLevelStr(testTreeStr, 3));
//		assertEquals("抛出异常",levelTreeTest.getTreeLevelStr(testTreeStr, 4));
		
		/**
		 * 对一棵形为A(B,)的树进行测试
		 * 第一层元素为"A"，第二层元素为"B"输入其他层会抛出异常
		 */
		testTreeStr = "AB###";//对一棵形为A(B,)的树进行测试
//		assertEquals("抛出异常",levelTreeTest.getTreeLevelStr(testTreeStr, 0));
		assertEquals("A",levelTreeTest.getTreeLevelStr(testTreeStr, 1));
		assertEquals("B",levelTreeTest.getTreeLevelStr(testTreeStr, 2));
//		assertEquals("抛出异常",levelTreeTest.getTreeLevelStr(testTreeStr, 3));
//		assertEquals("抛出异常",levelTreeTest.getTreeLevelStr(testTreeStr, 4));
		
		/**
		 * 对一棵形为A(B(G,H),D(C,F))的树进行测试
		 * 第一层元素为"A"，第二层元素为"BD"，第三层元素为"GHCF",输入其他层会抛出异常
		 */
		testTreeStr = "ABG##H##DC##F##";//对一棵形为A(B(G,H),D(C,F))的树进行测试
//		assertEquals("抛出异常",levelTreeTest.getTreeLevelStr(testTreeStr, 0));
		assertEquals("A",levelTreeTest.getTreeLevelStr(testTreeStr, 1));
		assertEquals("BD",levelTreeTest.getTreeLevelStr(testTreeStr, 2));
		assertEquals("GHCF",levelTreeTest.getTreeLevelStr(testTreeStr, 3));
//		assertEquals("抛出异常",levelTreeTest.getTreeLevelStr(testTreeStr, 4));

		

	}

}
