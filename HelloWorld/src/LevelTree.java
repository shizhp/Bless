/**根据先序遍历构建一棵二叉树，并输出树的第level层所有的节点
 * 采用了对象复用的方法
 * @author shizhp
 * 20151209
 */
public class LevelTree {

	private int index=0;
	public void setIndex()
	{
		index = 0;
	}
	private class TreeNode//定义树的节点
	{
		private char elem;
		private TreeNode left;
		private TreeNode right;
		/*TreeNode()
		{
			elem = 0;
			left = null;
			right = null;
		}*/
	}
/*	private class NullTreeExcep extends Exception
	{
		NullTreeExcep(String str)
		{
		//	super.
		}
	}
*/	
	public TreeNode createTree(String tree)throws Exception//根据先序遍历构建二叉树
	{
		TreeNode root = new TreeNode();
		if(tree==null||tree=="")
		{  
			throw new Exception("the tree can't be null");
			//return root;
		}
		if(index < tree.length())
		{
			root.elem = tree.charAt(index);
			if(tree.charAt(++index) != '#')//左子树不为空，构建左子树
			{
				root.left = createTree(tree);
			}
			else
			{
				root.left = null;
			}
			if(tree.charAt(++index) != '#')//右子树不为空，构建右子树
			{
				root.right = createTree(tree);
			}
			else
			{
				root.right = null;
			}
		}		
		return root;		
	}
	public String levelofTree(TreeNode root, int level)throws Exception//返回第n层的节点数据
	{
		StringBuilder res = new StringBuilder();
		if(root == null)//树为空或者输入层数有误，返回空
		{
			throw new Exception("tree is empty");
		}
		if(level <= 0)
		{
			throw new Exception("the level is illegal:" + level);
		}
		levelofTree(root, level, res);	
		return res.toString();

	}
	
	public void levelofTree(TreeNode root, int level,StringBuilder res)throws Exception//返回第n层的节点数据
	{
		if(level == 1)//到达第level层，返回该层的数据
		{
			res.append(root.elem);
		}
		else
		{
			if(root.left != null)
			{
				res.append(levelofTree(root.left,level-1));
			}
			if(root.right != null)
			{
				res.append(levelofTree(root.right,level-1));
			}
		}	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		LevelTree tree = new LevelTree();
		String preLevelTree="ABG##H##DC##F##";
		TreeNode root;
		try {
			//root = tree.CreateTree("ABG##H##DC##F##");
			root = tree.createTree(preLevelTree);
			String levelElems = tree.levelofTree(root,0);
			System.out.println(levelElems);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			e.printStackTrace();
		}	
	}
}
