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
	 * @Description :TODO(����һ�����ĸ������ص�level���������нڵ���Ϣ)
	 * @para :@param root
	 * @para :@param level
	 * @para :@return
	 * @para :@throws Exception
	 * @return :String
	 * @throws
	 */
	public String levelofTree(TreeNode root, int level) throws Exception// ���ص�n��Ľڵ�����
	{
		StringBuilder res = new StringBuilder();
		if (root == null) {// �ж����Ƿ�Ϊ��
			throw new Exception("tree is empty");
		}
		int totalLevel = getTreeLevel(root);
		if (level <= 0 || level > totalLevel) {//�ж�����Ĳ����Ƿ�Ϸ�
			throw new Exception("the level is illegal:" + level + " the total level of the tree is:" + totalLevel);
		}
		levelofTree1(root, level, res);
		return res.toString();

	}

	/**
	 * @Title :levelofTree1
	 * @Description :TODO(ʵ�ַ��ص�level���������нڵ���Ϣ�Ĺ���)
	 * @para :@param root
	 * @para :@param level
	 * @para :@param res
	 * @para :@throws Exception
	 * @return :void
	 * @throws
	 */
	public void levelofTree1(TreeNode root, int level, StringBuilder res)throws Exception// ���ص�n��Ľڵ�����
	{
		if (level == 1) {// �����level�㣬���ظò������
			res.append(root.elem);
		} else {
			if (root.left != null) {
				res.append(levelofTree(root.left, level - 1));//�����������в���
			}
			if (root.right != null) {
				res.append(levelofTree(root.right, level - 1));//�����������в���
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
