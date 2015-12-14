package test2_Int2Hex;

/**该{@code Int2Hex}类主要实现将int型整数转换为十六进制字符串输出
 * @author shizhp
 * @data 2015年12月14日
 */
public class Int2Hex {		
	/**将1-16，转换为十六进制表示1-9，A-B
	 * 转换效率更高
	 * @param number
	 * @return
	 * @throws Exception
	 */
	private char num2Alpha(int number)// 将数字转换为十进制字母返回
	{
		char[] n2A = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		return n2A[number];

	}

	/**将一个int整型数转换为十六进制字符串输出，
	 * 例如int2Hex(-256) = "-256"; 
	 * 注意最小值的处理以及与运算与右移运算的使用提高程序的运行效率
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
			if (num == Integer.MIN_VALUE)//若该负数为有符号Int型的最大负数，将该特例特殊处理输出
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
	/**更高效的转换方法
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
			if (num == Integer.MIN_VALUE)//若该负数为有符号Int型的最大负数，将该特例特殊处理输出
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
