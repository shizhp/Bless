
public class Int2Hex {
	private static char num2Alpha(int number)//������ת��Ϊʮ������ĸ����
	{
		char alpha;
		if(number < 9)
		{
			alpha = (char)('0' + number);
		}
		else
		{
			alpha = (char)('A' + number-10);
		}
		return alpha;
			
	}
	
	public static String int2Hex(int num)
	{
		StringBuilder res = new StringBuilder();
		if(num == 0)
		{
			res.append('0');
			return res.toString();
		}
		int tmp = 0;
		boolean isNegtive = (num < 0 ? true : false );
		if(isNegtive)//�ж�����������Ƿ�Ϊ��������Ϊ�����ײ����-
		{
			num = -num;
			res.append('-');
		}
		char toHex;
		while(num != 0)//��Ҫת�����̣��˴�������λ���൱�ڳ���16
		{
			tmp = num % 16;
			toHex = num2Alpha(tmp);
			res.append(toHex);
			num >>= 4;			
		}		
		return res.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = -1;
		String hex = int2Hex(num);
		System.out.println(hex);

	}

}
