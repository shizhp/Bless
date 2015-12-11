package test3_LevelTree;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @ClassName: LevelTree
 * @Discription: TODO(返回一棵树第n层所有的节点内容)
 * @author shizhp
 * @date: 2015年12月11日 下午12:02:10 <br/>
 *
 */
public class LevelTree {

	/**
	 * @Fields index :TODO(表示用字符串表示的树信息的下表)
	 */
	private int index = 0;

	/**
	 * @Title :setIndex
	 * @Description :TODO(构建一棵树前，应将index设为0，防止后续对表示树的字符串进行操作是出现异常)
	 * @para :
	 * @return :void
	 * @throws
	 */
	public void setIndex() {
		index = 0;
	}

	public class TreeNode {// 定义树的节点
		private char elem;
		private TreeNode left;
		private TreeNode right;
	}

	/**
	 * @Title :createTree
	 * @Description :TODO(使用先序遍历的字符串来构建树，字符串ABG##H##DC##F##表示树A(B(G,H),D(C,F))
	 * @para :@param tree
	 * @para :@return
	 * @para :@throws Exception
	 * @return :TreeNode
	 * @throws
	 */
	public TreeNode createTree(String tree) throws Exception {// 根据先序遍历构建二叉树
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
	/**
	 * @Title :getTreeLevel
	 * @Description :TODO(给定树的根，返回一棵树的层数)
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
	 * @Description :TODO(给定一棵树的根，返回第level层树的所有节点组成的链表)
	 * @para :@param root
	 * @para :@param level
	 * @para :@return
	 * @para :@throws Exception
	 * @return :String
	 * @throws
	 */
	public LinkedList<TreeNode> levelofTree(TreeNode root, int level) throws Exception// 返回第n层的节点数据
	{		
		if (root == null) {// 判断树是否为空
			throw new Exception("tree is empty");
		}
		int totalLevel = getTreeLevel(root);
		if (level <= 0 || level > totalLevel) {//判断输入的层数是否合法
			throw new Exception("the level is illegal:" + level + " the total level of the tree is:" + totalLevel);
		}
		LinkedList<TreeNode> linkList = new LinkedList<>();
		levelofTree1(root, level, linkList);
		return linkList;

	}

	/**
	 * @Title :levelofTree1
	 * @Description :TODO(实现返回第level层树的所有节点链表的功能)
	 * @para :@param root
	 * @para :@param level
	 * @para :@param res
	 * @para :@throws Exception
	 * @return :void
	 * @throws
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
	/**
	 * @Title :list2Str
	 * @Description :TODO(将链表中的所有树的节点的值取出放入字符串中返回)
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
		while(it.hasNext())//遍历整个链表
		{
			levelTreeStr.append(it.next().elem);
		}
		return levelTreeStr.toString();
	}
	/**
	 * @Title :getTreeLevelStr
	 * @Description :TODO(封装所有代码，输入表示树的先序遍历的字符串，返回第level层的所有节点值构成的字符串)
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
