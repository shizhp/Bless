package test3_LevelTree;

import java.util.LinkedList;
import java.util.ListIterator;

/**该{@code LevelTree}类主要实现通过给定一个表示树的先序遍历字符串，
 * 例如表示树的线序遍历字符串为"ABG##H##DC##F##"该树的形式为A(B(G,H),D(C,F))
 * 并指定要返回的节点层数，返回该节点所有数据构成的字符串
 * 要注意层数的合法性判断以及树的构建过程
 * @author shizhp
 * @data 2015年12月14日
 */
public class LevelTree {

	/** 表示用字符串表示的树信息的下表 */
	private int index = 0;
	/**构建一棵树前，应将index设为0，防止后续对表示树的字符串进行操作是出现异常 */
	public void setIndex() {
		index = 0;
	}

	/**定义树的节点 */
	public class TreeNode {
		private char elem;
		private TreeNode left;
		private TreeNode right;
	}
	/**给定一棵树的先序遍历字符串形式，构建这棵树并返回根节点
	 * 注意对异常的判断以及树的构建方法，采用递归方法分别构建左子树和右子树
	 * @param tree
	 * @return
	 * @throws Exception
	 */
	public TreeNode createTree(String tree) throws Exception {
		TreeNode root = new TreeNode();
		if (tree == null || tree == "") {//表示树的字符串为空，抛出异常
			throw new Exception("the tree can't be null");
		}
		if (index < tree.length()) {
			root.elem = tree.charAt(index);
			if (tree.charAt(++index) != '#') {// 左子树不为空，构建左子树
				root.left = createTree(tree);
			} else {
				root.left = null;
			}
			if (tree.charAt(++index) != '#') {// 右子树不为空，构建右子树
				root.right = createTree(tree);
			} else {
				root.right = null;
			}
		}
		return root;
	}	

	/**给定树的根节点，返回树的层数
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
	/**将树的第n层的所有节点放入链表中返回
	 * 注意异常的处理以及代码的复用，LinkedList与List的区别
	 * @param root
	 * @param level
	 * @return
	 * @throws Exception
	 */
	public LinkedList<TreeNode> levelofTree(TreeNode root, int level) throws Exception// 返回第n层的节点数据
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

	/**实现将树的第n层的所有节点放入链表中返回
	 * @param root
	 * @param level
	 * @param linkList
	 * @throws Exception
	 */
	public void levelofTree1(TreeNode root, int level, LinkedList<TreeNode> linkList)throws Exception// 返回第n层的节点数据
	{
		if (level == 1) {// 到达第level层，返回该层的数据
			linkList.add(root);
		} else {
			if (root.left != null) {
				levelofTree1(root.left, level - 1, linkList);//对左子树进行操作
			}
			if (root.right != null) {
				levelofTree1(root.right, level - 1, linkList);//对右子树进行操作
			}
		}
	}

	/**将链表中节点信息取出，返回字符串信息
	 * 注意迭代器的用法
	 * @param linkList
	 * @return
	 */
	public String list2Str(LinkedList<TreeNode> linkList)
	{
		if(linkList == null)
			return null;
		StringBuilder levelTreeStr = new StringBuilder();
		ListIterator<TreeNode> it = linkList.listIterator();
		while(it.hasNext())//遍历整个链表
		{
			levelTreeStr.append(it.next().elem);
		}
		return levelTreeStr.toString();
	}
	/**将树的第n层节点放入链表中输出
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
