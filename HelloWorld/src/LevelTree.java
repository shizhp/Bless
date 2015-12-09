
public class LevelTree {

	private class TreeNode//�������Ľڵ�
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
	public TreeNode CreateTree(String tree, int index)//���������������������
	{
		TreeNode root = new TreeNode();
		if(tree.isEmpty())
		{  
			return root;
		}
		if(index < tree.length())
		{
			root.elem = tree.charAt(index);
			if(tree.charAt(++index) != '#')//��������Ϊ�գ�����������
			{
				root.left = CreateTree(tree, index);
			}
			else
			{
				root.left = null;
			}
			if(tree.charAt(++index) != '#')//��������Ϊ�գ�����������
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
	public String LevelofTree(TreeNode root, int level)//���ص�n��Ľڵ�����
	{
		StringBuilder res = new StringBuilder();
		if(root == null || level <= 0)//��Ϊ�ջ�������������󣬷��ؿ�
			return res.toString();
		if(level == 1)
			res.append(root.elem);//�����level�㣬���ظò������
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
