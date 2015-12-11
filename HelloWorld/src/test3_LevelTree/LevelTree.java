package test3_LevelTree;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @ClassName: LevelTree
 * @Discription: TODO(����һ������n�����еĽڵ�����)
 * @author shizhp
 * @date: 2015��12��11�� ����12:02:10 <br/>
 *
 */
public class LevelTree {

	/**
	 * @Fields index :TODO(��ʾ���ַ�����ʾ������Ϣ���±�)
	 */
	private int index = 0;

	/**
	 * @Title :setIndex
	 * @Description :TODO(����һ����ǰ��Ӧ��index��Ϊ0����ֹ�����Ա�ʾ�����ַ������в����ǳ����쳣)
	 * @para :
	 * @return :void
	 * @throws
	 */
	public void setIndex() {
		index = 0;
	}

	public class TreeNode {// �������Ľڵ�
		private char elem;
		private TreeNode left;
		private TreeNode right;
	}

	/**
	 * @Title :createTree
	 * @Description :TODO(ʹ������������ַ��������������ַ���ABG##H##DC##F##��ʾ��A(B(G,H),D(C,F))
	 * @para :@param tree
	 * @para :@return
	 * @para :@throws Exception
	 * @return :TreeNode
	 * @throws
	 */
	public TreeNode createTree(String tree) throws Exception {// ���������������������
		TreeNode root = new TreeNode();
		if (tree == null || tree == "") {//��ʾ�����ַ���Ϊ�գ��׳��쳣
			throw new Exception("the tree can't be null");
		}
		if (index < tree.length()) {
			root.elem = tree.charAt(index);
			if (tree.charAt(++index) != '#') {// ��������Ϊ�գ�����������
				root.left = createTree(tree);
			} else {
				root.left = null;
			}
			if (tree.charAt(++index) != '#') {// ��������Ϊ�գ�����������
				root.right = createTree(tree);
			} else {
				root.right = null;
			}
		}
		return root;
	}	
	/**
	 * @Title :getTreeLevel
	 * @Description :TODO(�������ĸ�������һ�����Ĳ���)
	 * @para :@param root
	 * @para :@return
	 * @return :int
	 * @throws
	 */
	public int getTreeLevel(TreeNode root)
	{
		if(root == null)
			return 0;
		int totalLevel = 0;
		int leftTotalLevel = 0;
		int rightTotalLevel = 0;
		if(root.left != null)
		{
			leftTotalLevel = getTreeLevel(root.left);
		}
		if(root.right != null)
		{
			rightTotalLevel = getTreeLevel(root.right);
		}
		totalLevel = leftTotalLevel > rightTotalLevel ? leftTotalLevel : rightTotalLevel;
		return totalLevel+1;
	}
	/**
	 * @Title :levelofTree
	 * @Description :TODO(����һ�����ĸ������ص�level���������нڵ���ɵ�����)
	 * @para :@param root
	 * @para :@param level
	 * @para :@return
	 * @para :@throws Exception
	 * @return :String
	 * @throws
	 */
	public LinkedList<TreeNode> levelofTree(TreeNode root, int level) throws Exception// ���ص�n��Ľڵ�����
	{		
		if (root == null) {// �ж����Ƿ�Ϊ��
			throw new Exception("tree is empty");
		}
		int totalLevel = getTreeLevel(root);
		if (level <= 0 || level > totalLevel) {//�ж�����Ĳ����Ƿ�Ϸ�
			throw new Exception("the level is illegal:" + level + " the total level of the tree is:" + totalLevel);
		}
		LinkedList<TreeNode> linkList = new LinkedList<>();
		levelofTree1(root, level, linkList);
		return linkList;

	}

	/**
	 * @Title :levelofTree1
	 * @Description :TODO(ʵ�ַ��ص�level���������нڵ�����Ĺ���)
	 * @para :@param root
	 * @para :@param level
	 * @para :@param res
	 * @para :@throws Exception
	 * @return :void
	 * @throws
	 */
	public void levelofTree1(TreeNode root, int level, LinkedList<TreeNode> linkList)throws Exception// ���ص�n��Ľڵ�����
	{
		if (level == 1) {// �����level�㣬���ظò������
			linkList.add(root);
		} else {
			if (root.left != null) {
				levelofTree1(root.left, level - 1, linkList);//�����������в���
			}
			if (root.right != null) {
				levelofTree1(root.right, level - 1, linkList);//�����������в���
			}
		}
	}
	/**
	 * @Title :list2Str
	 * @Description :TODO(�������е��������Ľڵ��ֵȡ�������ַ����з���)
	 * @para :@param linkList
	 * @para :@return
	 * @return :String
	 * @throws
	 */
	public String list2Str(LinkedList<TreeNode> linkList)
	{
		if(linkList == null)
			return null;
		StringBuilder levelTreeStr = new StringBuilder();
		ListIterator<TreeNode> it = linkList.listIterator();
		while(it.hasNext())//������������
		{
			levelTreeStr.append(it.next().elem);
		}
		return levelTreeStr.toString();
	}
	/**
	 * @Title :getTreeLevelStr
	 * @Description :TODO(��װ���д��룬�����ʾ��������������ַ��������ص�level������нڵ�ֵ���ɵ��ַ���)
	 * @para :@param preLevelTreeStr
	 * @para :@param level
	 * @para :@return
	 * @para :@throws Exception
	 * @return :String
	 * @throws
	 */
	public String getTreeLevelStr(String preLevelTreeStr,int level) throws Exception{
		setIndex();
		TreeNode root = createTree(preLevelTreeStr);
		LinkedList<TreeNode> linkList  = levelofTree(root, level);
		String levelElem = list2Str(linkList);
		return levelElem;
	}
	public static void main(String[] args) throws Exception {
		LevelTree tree = new LevelTree();
		String preLevelTree = "ABG##H##DC##F##";
		int level = 3;
		String levelElem = tree.getTreeLevelStr(preLevelTree, level);
		System.out.println(levelElem);
	}
}
