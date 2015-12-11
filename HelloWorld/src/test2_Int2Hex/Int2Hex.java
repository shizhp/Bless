package test2_Int2Hex;
/**
 * @ClassName: Int2Hex
 * @Discription: TODO(turn a int number into a Hex string)
 * @author shizhp
 * @date: 2015年12月11日 上午11:44:42 <br/>
 *
 */
public class Int2Hex {	

	/**
	 * @Title :num2Alpha
	 * @Description :TODO(这里用一句话描述这个方法的作用)
	 * @para :@param number
	 * @para :@return
	 * @para :@throws Exception
	 * @return :char
	 * @throws
	 */
	private char num2Alpha(int number) throws Exception// 将数字转换为十进制字母返回
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
		if (isNegtive) {// 判断输入的数字是否为负数，若为则在首部添加-
			if (num == Integer.MIN_VALUE)//若该负数为有符号Int型的最大负数，将该特例特殊处理输出
				return "-80000000";
			num = -num;
		}
		char toHex;		
		while (num != 0) {// 主要转换过程，此处右移四位则相当于除了16
			tmp = num & 0xf;
			toHex = num2Alpha(tmp);
			res.append(toHex);
			num >>= 4;
		}
		
		if (isNegtive) {// 判断输入的数字是否为负数，若为则在首部添加-
			res.append('-');
		}
		return res.reverse().toString();// 将所有位数的数字反转后输出
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = -256;
		Int2Hex int2HexTest = new Int2Hex();
		String hex = int2HexTest.int2Hex(num);
		System.out.println(hex);
	}

}
