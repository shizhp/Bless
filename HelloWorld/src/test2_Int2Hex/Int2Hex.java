package test2_Int2Hex;

/**��{@code Int2Hex}����Ҫʵ�ֽ�int������ת��Ϊʮ�������ַ������
 * @author shizhp
 * @data 2015��12��14��
 */
public class Int2Hex {		
	/**��1-16��ת��Ϊʮ�����Ʊ�ʾ1-9��A-B
	 * ת��Ч�ʸ���
	 * @param number
	 * @return
	 * @throws Exception
	 */
	private char num2Alpha(int number)// ������ת��Ϊʮ������ĸ����
	{
		char[] n2A = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		return n2A[number];

	}

	/**��һ��int������ת��Ϊʮ�������ַ��������
	 * ����int2Hex(-256) = "-256"; 
	 * ע����Сֵ�Ĵ����Լ������������������ʹ����߳��������Ч��
	 * @param num
	 * @return
	 */
	public String int2Hex(int num) {
		StringBuilder res = new StringBuilder();
		if (num == 0) {
			res.append('0');
			return res.toString();
		}
		int tmp = 0;
		boolean isNegtive = (num < 0 ? true : false);
		if (isNegtive) {
			if (num == Integer.MIN_VALUE)//���ø���Ϊ�з���Int�͵�������������������⴦�����
				return "-80000000";
			num = -num;
		}
		char toHex;		
		while (num != 0) {
			tmp = num & 0xf;
			toHex = num2Alpha(tmp);
			res.append(toHex);
			num >>= 4;
		}
		
		if (isNegtive) {
			res.append('-');
		}
		return res.reverse().toString();
	}
	/**����Ч��ת������
	 * @param num
	 * @return
	 */
	public String int2Hex2(int num) {
		if (num == 0) {
			return "0";
		}
		int tmp = 0;
		boolean isNegtive = (num < 0 ? true : false);
		if (isNegtive) {
			if (num == Integer.MIN_VALUE)//���ø���Ϊ�з���Int�͵�������������������⴦�����
				return "-80000000";
			num = -num;
		}
		char[] toHex = new char[9];
		int i = 8;
		while (num != 0) {
			tmp = num & 0xf;
			toHex[i--] = num2Alpha(tmp);
			num >>= 4;
		}
		
		if (isNegtive) {
			toHex[i] = '-';
			//return new String(toHex, i, toHex.length - i);
		}
		else{
			i++;
		}
		return new String(toHex, i, toHex.length - i);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 256;
		Int2Hex int2HexTest = new Int2Hex();
		String hex = int2HexTest.int2Hex2(num);
		System.out.println(hex);
	}

}
