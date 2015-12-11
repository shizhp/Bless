package test3_LevelTree;
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
	

	/**
	 * @Title :testLevelofTreeTreeNodeInt
	 * @Description :TODO(��Ԫ���Ե����⺯��)
	 * @param :@throws Exception
	 * @return :void
	 * @throws
	 */
	@Test
	public void testLevelofTreeTreeNodeInt()throws Exception {
		
		LevelTree levelTreeTest = new LevelTree();
		String testTreeStr = "ABG##H##DC##F##";//��һ����ΪA(B(G,H),D(C,F))�������в���
		/**
		 * �Կ������в��ԣ��׳��쳣
		 */
//		assertEquals("�׳��쳣",levelTreeTest.getTreeLevelStr(testTreeStr, 1));//�������׳��쳣
		
		/**
		 * ��һ����ΪA(,)�������в���
		 * ��һ��Ԫ��Ϊ"A"��������������׳��쳣
		 */
		testTreeStr = "A##";//��һ����ΪA(,)�������в���
		assertEquals("A",levelTreeTest.getTreeLevelStr(testTreeStr, 1));
//		assertEquals("�׳��쳣",levelTreeTest.getTreeLevelStr(testTreeStr, 2));
		
		/**
		 * ��һ����ΪA(,B)�������в���
		 * ��һ��Ԫ��Ϊ"A"���ڶ���Ԫ��Ϊ"B"������������׳��쳣
		 */
		testTreeStr = "A#B##";//��һ����ΪA(,B)�������в���
//		assertEquals("�׳��쳣",levelTreeTest.getTreeLevelStr(testTreeStr, 0));
		assertEquals("A",levelTreeTest.getTreeLevelStr(testTreeStr, 1));
		assertEquals("B",levelTreeTest.getTreeLevelStr(testTreeStr, 2));
//		assertEquals("�׳��쳣",levelTreeTest.getTreeLevelStr(testTreeStr, 3));
//		assertEquals("�׳��쳣",levelTreeTest.getTreeLevelStr(testTreeStr, 4));
		
		/**
		 * ��һ����ΪA(B,)�������в���
		 * ��һ��Ԫ��Ϊ"A"���ڶ���Ԫ��Ϊ"B"������������׳��쳣
		 */
		testTreeStr = "AB###";//��һ����ΪA(B,)�������в���
//		assertEquals("�׳��쳣",levelTreeTest.getTreeLevelStr(testTreeStr, 0));
		assertEquals("A",levelTreeTest.getTreeLevelStr(testTreeStr, 1));
		assertEquals("B",levelTreeTest.getTreeLevelStr(testTreeStr, 2));
//		assertEquals("�׳��쳣",levelTreeTest.getTreeLevelStr(testTreeStr, 3));
//		assertEquals("�׳��쳣",levelTreeTest.getTreeLevelStr(testTreeStr, 4));
		
		/**
		 * ��һ����ΪA(B(G,H),D(C,F))�������в���
		 * ��һ��Ԫ��Ϊ"A"���ڶ���Ԫ��Ϊ"BD"��������Ԫ��Ϊ"GHCF",������������׳��쳣
		 */
		testTreeStr = "ABG##H##DC##F##";//��һ����ΪA(B(G,H),D(C,F))�������в���
//		assertEquals("�׳��쳣",levelTreeTest.getTreeLevelStr(testTreeStr, 0));
		assertEquals("A",levelTreeTest.getTreeLevelStr(testTreeStr, 1));
		assertEquals("BD",levelTreeTest.getTreeLevelStr(testTreeStr, 2));
		assertEquals("GHCF",levelTreeTest.getTreeLevelStr(testTreeStr, 3));
//		assertEquals("�׳��쳣",levelTreeTest.getTreeLevelStr(testTreeStr, 4));

		

	}

}
