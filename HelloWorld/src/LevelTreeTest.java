import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;




/**
 * @ClassName: LevelTreeTest
 * @Discription: TODO(�Է�������ĳһ�����е� �ڵ���е�Ԫ����)
 * @author shizhp
 * @date: 2015��12��11�� ����2:11:00 <br/>
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
	 * @Description :TODO(��Ԫ���Ե����⺯��)
	 * @para :@throws Exception
	 * @return :void
	 * @throws
	 */
	@Test
	public void testLevelofTreeTreeNodeInt()throws Exception {
		
		LevelTree levelTreeTest = new LevelTree();
		String testTreeStr = "ABG##H##DC##F##";//��һ����ΪA(B(G,H),D(C,F))�������в���
		levelTreeTest.setIndex();
		LevelTree.TreeNode root = levelTreeTest.createTree(testTreeStr);
//		int totalLevel = levelTreeTest.getTreeLevel(root);
		
//		assertEquals("�׳��쳣",levelTreeTest.levelofTree(levelTreeTest.createTree(""), 1));//�������׳��쳣
		
		testTreeStr = "A##";//��һ����ΪA(,)�������в���
		levelTreeTest.setIndex();
		root = levelTreeTest.createTree(testTreeStr);
		assertEquals("A",levelTreeTest.levelofTree(root, 1));
		
		testTreeStr = "A#B##";//��һ����ΪA(,B)�������в���
		levelTreeTest.setIndex();
		root = levelTreeTest.createTree(testTreeStr);
//		assertEquals("�׳��쳣",levelTreeTest.levelofTree(root, 0));//������������׳��쳣
		assertEquals("A",levelTreeTest.levelofTree(root, 1));
		assertEquals("B",levelTreeTest.levelofTree(root, 2));
//		assertEquals("�׳��쳣",levelTreeTest.levelofTree(root, 3));//���������������ܲ������׳��쳣
//		assertEquals("�׳��쳣",levelTreeTest.levelofTree(root, 4));//���������������ܲ������׳��쳣
		
		testTreeStr = "AB###";//��һ����ΪA(,B(,C))�������в���
		levelTreeTest.setIndex();
		root = levelTreeTest.createTree(testTreeStr);
//		assertEquals("�׳��쳣",levelTreeTest.levelofTree(root, 0));//������������׳��쳣
		assertEquals("A",levelTreeTest.levelofTree(root, 1));
		assertEquals("B",levelTreeTest.levelofTree(root, 2));
//		assertEquals("�׳��쳣",levelTreeTest.levelofTree(root, 3));//���������������ܲ������׳��쳣
//		assertEquals("�׳��쳣",levelTreeTest.levelofTree(root, 4));//���������������ܲ������׳��쳣

		testTreeStr = "A#B#C##";//��һ����ΪA(,B(,C))�������в���
		levelTreeTest.setIndex();
		root = levelTreeTest.createTree(testTreeStr);
//		assertEquals("�׳��쳣",levelTreeTest.levelofTree(root, 0));//������������׳��쳣
		assertEquals("A",levelTreeTest.levelofTree(root, 1));
		assertEquals("B",levelTreeTest.levelofTree(root, 2));
		assertEquals("C",levelTreeTest.levelofTree(root, 3));
//		assertEquals("�׳��쳣",levelTreeTest.levelofTree(root, 4));//���������������ܲ������׳��쳣
		
		testTreeStr = "ABG##H##DC##F##";//��һ����ΪA(B(G,H),D(C,F))�������в���
		levelTreeTest.setIndex();
		root = levelTreeTest.createTree(testTreeStr);		
//		assertEquals("�׳��쳣",levelTreeTest.levelofTree(root, 0));//������������׳��쳣
		assertEquals("A",levelTreeTest.levelofTree(root, 1));
		assertEquals("BD",levelTreeTest.levelofTree(root, 2));
		assertEquals("GHCF",levelTreeTest.levelofTree(root, 3));
//		assertEquals("�׳��쳣",levelTreeTest.levelofTree(root, 4));//���������������ܲ������׳��쳣
		

	}

}
