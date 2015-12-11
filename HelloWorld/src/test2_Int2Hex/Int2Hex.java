package test2_Int2Hex;
/**
 * @ClassName: Int2Hex
 * @Discription: TODO(turn a int number into a Hex string)
 * @author shizhp
 * @date: 2015��12��11�� ����11:44:42 <br/>
 *
 */
public class Int2Hex {	

	/**
	 * @Title :num2Alpha
	 * @Description :TODO(������һ�仰�����������������)
	 * @para :@param number
	 * @para :@return
	 * @para :@throws Exception
	 * @return :char
	 * @throws
	 */
	private char num2Alpha(int number) throws Exception// ������ת��Ϊʮ������ĸ����
	{
		char alpha;
		if (number < 10) {
			alpha = (char) ('0' + number);
		} else {
			alpha = (char) ('A' + number - 10);
		}
		return alpha;

	}

	/**
	 * @Title :int2Hex
	 * @Description :TODO(implement the function int2Hex)
	 * @para :@param num
	 * @para :@return
	 * @return :String
	 * @throws
	 */
	public String int2Hex(int num) {
		StringBuilder res = new StringBuilder();
		if (num == 0) {
			res.append('0');
			return res.toString();
		}
		int tmp = 0;
		boolean isNegtive = (num < 0 ? true : false);
		if (isNegtive) {// �ж�����������Ƿ�Ϊ��������Ϊ�����ײ����-
			if (num == Integer.MIN_VALUE)//���ø���Ϊ�з���Int�͵�������������������⴦�����
				return "-80000000";
			num = -num;
		}
		char toHex;		
		while (num != 0) {// ��Ҫת�����̣��˴�������λ���൱�ڳ���16
			tmp = num & 0xf;
			toHex = num2Alpha(tmp);
			res.append(toHex);
			num >>= 4;
		}
		
		if (isNegtive) {// �ж�����������Ƿ�Ϊ��������Ϊ�����ײ����-
			res.append('-');
		}
		return res.reverse().toString();// ������λ�������ַ�ת�����
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = -256;
		Int2Hex int2HexTest = new Int2Hex();
		String hex = int2HexTest.int2Hex(num);
		System.out.println(hex);
	}

}
