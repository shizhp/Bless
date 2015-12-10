/**��int������ת��ΪHex�ַ���
 * @author shizhp
 * 20151209
 */
//import java.util.*;
public class Int2Hex {
	private char num2Alpha(int number)//������ת��Ϊʮ������ĸ����
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
	
	public String int2Hex(int num)
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
			if(num == Integer.MIN_VALUE)
				return "-80000000";
			num = -num;
		}
		char toHex;
		while(num != 0)//��Ҫת�����̣��˴�������λ���൱�ڳ���16
		{
			tmp = num % 16;
			toHex = num2Alpha(tmp);
			res.append(toHex);
			num >>= 4;			
		}
		if(isNegtive)//�ж�����������Ƿ�Ϊ��������Ϊ�����ײ����-
		{
			res.append('-');
		}
		return res.reverse().toString();//������λ�������ַ�ת�����
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = -256;
		Int2Hex int2HexTest = new Int2Hex();
		String hex = int2HexTest.int2Hex(num);
		System.out.println(hex);
	}

}
