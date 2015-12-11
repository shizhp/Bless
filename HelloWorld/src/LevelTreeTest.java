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
	}

	/**
	 * @Title :testLevelofTreeTreeNodeInt
	 * @Description :TODO(单元测试的主题函数)
	 * @para :@throws Exception
	 * @return :void
	 * @throws
	 */
	@Test
	public void testLevelofTreeTreeNodeInt()throws Exception {
		
		LevelTree levelTreeTest = new LevelTree();
		String testTreeStr = "ABG##H##DC##F##";//对一棵形为A(B(G,H),D(C,F))的树进行测试
		levelTreeTest.setIndex();
		LevelTree.TreeNode root = levelTreeTest.createTree(testTreeStr);
//		int totalLevel = levelTreeTest.getTreeLevel(root);
		
//		assertEquals("抛出异常",levelTreeTest.levelofTree(levelTreeTest.createTree(""), 1));//空树，抛出异常
		
		testTreeStr = "A##";//对一棵形为A(,)的树进行测试
		levelTreeTest.setIndex();
		root = levelTreeTest.createTree(testTreeStr);
		assertEquals("A",levelTreeTest.levelofTree(root, 1));
		
		testTreeStr = "A#B##";//对一棵形为A(,B)的树进行测试
		levelTreeTest.setIndex();
		root = levelTreeTest.createTree(testTreeStr);
//		assertEquals("抛出异常",levelTreeTest.levelofTree(root, 0));//输入层数错误，抛出异常
		assertEquals("A",levelTreeTest.levelofTree(root, 1));
		assertEquals("B",levelTreeTest.levelofTree(root, 2));
//		assertEquals("抛出异常",levelTreeTest.levelofTree(root, 3));//层数超出了树的总层数，抛出异常
//		assertEquals("抛出异常",levelTreeTest.levelofTree(root, 4));//层数超出了树的总层数，抛出异常
		
		testTreeStr = "AB###";//对一棵形为A(,B(,C))的树进行测试
		levelTreeTest.setIndex();
		root = levelTreeTest.createTree(testTreeStr);
//		assertEquals("抛出异常",levelTreeTest.levelofTree(root, 0));//输入层数错误，抛出异常
		assertEquals("A",levelTreeTest.levelofTree(root, 1));
		assertEquals("B",levelTreeTest.levelofTree(root, 2));
//		assertEquals("抛出异常",levelTreeTest.levelofTree(root, 3));//层数超出了树的总层数，抛出异常
//		assertEquals("抛出异常",levelTreeTest.levelofTree(root, 4));//层数超出了树的总层数，抛出异常

		testTreeStr = "A#B#C##";//对一棵形为A(,B(,C))的树进行测试
		levelTreeTest.setIndex();
		root = levelTreeTest.createTree(testTreeStr);
//		assertEquals("抛出异常",levelTreeTest.levelofTree(root, 0));//输入层数错误，抛出异常
		assertEquals("A",levelTreeTest.levelofTree(root, 1));
		assertEquals("B",levelTreeTest.levelofTree(root, 2));
		assertEquals("C",levelTreeTest.levelofTree(root, 3));
//		assertEquals("抛出异常",levelTreeTest.levelofTree(root, 4));//层数超出了树的总层数，抛出异常
		
		testTreeStr = "ABG##H##DC##F##";//对一棵形为A(B(G,H),D(C,F))的树进行测试
		levelTreeTest.setIndex();
		root = levelTreeTest.createTree(testTreeStr);		
//		assertEquals("抛出异常",levelTreeTest.levelofTree(root, 0));//输入层数错误，抛出异常
		assertEquals("A",levelTreeTest.levelofTree(root, 1));
		assertEquals("BD",levelTreeTest.levelofTree(root, 2));
		assertEquals("GHCF",levelTreeTest.levelofTree(root, 3));
//		assertEquals("抛出异常",levelTreeTest.levelofTree(root, 4));//层数超出了树的总层数，抛出异常
		

	}

}
