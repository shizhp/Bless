
public class LevelTree {

	private class TreeNode//定义树的节点
	{
		char elem;
		TreeNode left;
		TreeNode right;
		/*TreeNode()
		{
			elem = 0;
			left = null;
			right = null;
		}*/
	}
	public TreeNode CreateTree(String tree, int index)//根据先序遍历构建二叉树
	{
		TreeNode root = new TreeNode();
		if(tree.isEmpty())
		{  
			return root;
		}
		if(index < tree.length())
		{
			root.elem = tree.charAt(index);
			if(tree.charAt(++index) != '#')//左子树不为空，构建左子树
			{
				root.left = CreateTree(tree, index);
			}
			else
			{
				root.left = null;
			}
			if(tree.charAt(++index) != '#')//右子树不为空，构建右子树
			{
				root.right = CreateTree(tree, index);
			}
			else
			{
				root.right = null;
			}
		}		
		return root;		
	}
	public String LevelofTree(TreeNode root, int level)//返回第n层的节点数据
	{
		StringBuilder res = new StringBuilder();
		if(root == null || level <= 0)//树为空或者输入层数有误，返回空
			return res.toString();
		if(level == 1)
			res.append(root.elem);//到达第level层，返回该层的数据
		if(root.left != null)
		{
			res.append(LevelofTree(root.left,level-1));
		}
		if(root.right != null)
		{
			res.append(LevelofTree(root.right,level-1));
		}
		return res.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LevelTree tree = new LevelTree();
		TreeNode root = tree.CreateTree("ABG##H##DC##F##",0);
		String levelElems = tree.LevelofTree(root,3);
		System.out.println(levelElems);
		
	}

}
