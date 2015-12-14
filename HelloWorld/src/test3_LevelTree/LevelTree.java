package test3_LevelTree;

import java.util.LinkedList;
import java.util.ListIterator;

/**��{@code LevelTree}����Ҫʵ��ͨ������һ����ʾ������������ַ�����
 * �����ʾ������������ַ���Ϊ"ABG##H##DC##F##"��������ʽΪA(B(G,H),D(C,F))
 * ��ָ��Ҫ���صĽڵ���������ظýڵ��������ݹ��ɵ��ַ���
 * Ҫע������ĺϷ����ж��Լ����Ĺ�������
 * @author shizhp
 * @data 2015��12��14��
 */
public class LevelTree {

	/** ��ʾ���ַ�����ʾ������Ϣ���±� */
	private int index = 0;
	/**����һ����ǰ��Ӧ��index��Ϊ0����ֹ�����Ա�ʾ�����ַ������в����ǳ����쳣 */
	public void setIndex() {
		index = 0;
	}

	/**�������Ľڵ� */
	public class TreeNode {
		private char elem;
		private TreeNode left;
		private TreeNode right;
	}
	/**����һ��������������ַ�����ʽ����������������ظ��ڵ�
	 * ע����쳣���ж��Լ����Ĺ������������õݹ鷽���ֱ𹹽���������������
	 * @param tree
	 * @return
	 * @throws Exception
	 */
	public TreeNode createTree(String tree) throws Exception {
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

	/**�������ĸ��ڵ㣬�������Ĳ���
	 * @param root
	 * @return
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
	/**�����ĵ�n������нڵ���������з���
	 * ע���쳣�Ĵ����Լ�����ĸ��ã�LinkedList��List������
	 * @param root
	 * @param level
	 * @return
	 * @throws Exception
	 */
	public LinkedList<TreeNode> levelofTree(TreeNode root, int level) throws Exception// ���ص�n��Ľڵ�����
	{		
		if (root == null) {
			throw new Exception("tree is empty");
		}
		int totalLevel = getTreeLevel(root);
		if (level <= 0 || level > totalLevel) {
			throw new Exception("the level is illegal:" + level + " the total level of the tree is:" + totalLevel);
		}
		LinkedList<TreeNode> linkList = new LinkedList<>();
		levelofTree1(root, level, linkList);
		return linkList;

	}

	/**ʵ�ֽ����ĵ�n������нڵ���������з���
	 * @param root
	 * @param level
	 * @param linkList
	 * @throws Exception
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

	/**�������нڵ���Ϣȡ���������ַ�����Ϣ
	 * ע����������÷�
	 * @param linkList
	 * @return
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
	/**�����ĵ�n��ڵ�������������
	 * @param preLevelTreeStr
	 * @param level
	 * @return
	 * @throws Exception
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
