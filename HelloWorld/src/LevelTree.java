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
	 * @Description :TODO(给定一棵树的根，返回第level层树的所有节点信息)
	 * @para :@param root
	 * @para :@param level
	 * @para :@return
	 * @para :@throws Exception
	 * @return :String
	 * @throws
	 */
	public String levelofTree(TreeNode root, int level) throws Exception// 返回第n层的节点数据
	{
		StringBuilder res = new StringBuilder();
		if (root == null) {// 判断树是否为空
			throw new Exception("tree is empty");
		}
		int totalLevel = getTreeLevel(root);
		if (level <= 0 || level > totalLevel) {//判断输入的层数是否合法
			throw new Exception("the level is illegal:" + level + " the total level of the tree is:" + totalLevel);
		}
		levelofTree1(root, level, res);
		return res.toString();

	}

	/**
	 * @Title :levelofTree1
	 * @Description :TODO(实现返回第level层树的所有节点信息的功能)
	 * @para :@param root
	 * @para :@param level
	 * @para :@param res
	 * @para :@throws Exception
	 * @return :void
	 * @throws
	 */
	public void levelofTree1(TreeNode root, int level, StringBuilder res)throws Exception// 返回第n层的节点数据
	{
		if (level == 1) {// 到达第level层，返回该层的数据
			res.append(root.elem);
		} else {
			if (root.left != null) {
				res.append(levelofTree(root.left, level - 1));//对左子树进行操作
			}
			if (root.right != null) {
				res.append(levelofTree(root.right, level - 1));//对右子树进行操作
			}
		}
	}

	public static void main(String[] args) {
		LevelTree tree = new LevelTree();
		String preLevelTree;
//		preLevelTree = "ABG##H##DC##F##";
		preLevelTree = "A##";
		TreeNode root;
		try {
			// root = tree.CreateTree("ABG##H##DC##F##");
			root = tree.createTree(preLevelTree);
			String levelElems = tree.levelofTree(root, 1);
			System.out.println(levelElems);
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
}
