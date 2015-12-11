import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.File;

/**
 * @ClassName: File2Buf
 * @Discription: TODO(turn a file into a byte array)
 * @author shizhp
 * @date: 2015年12月11日 上午11:30:10 <br/>
 *
 */
public class File2Buf {
	/**
	 * @Title :file2Buf
	 * @Description :TODO(the method implement file2Buf)
	 * @para :@param path
	 * @para :@return
	 * @para :@throws Exception
	 * @return :byte[]
	 * @throws
	 */
	public byte[] file2Buf(String path) throws IOException {
		File fobj = new File(path);
		if (!fobj.isFile() || !fobj.exists()) {//若文件不存在或者该路径不是文件则抛出异常
			throw new IOException("file is not exist");
		}
		InputStream fis = new FileInputStream(fobj);// 定义文件读取输入流
		ByteArrayOutputStream baos = new ByteArrayOutputStream(4096);// 定义文件输出流
		byte[] tmpBuff = new byte[4096];// 缓冲字节数组
		int tmpbyte = 0;// 获取文件读取状态信息
		while ((tmpbyte = fis.read(tmpBuff)) != -1) {
			baos.write(tmpBuff, 0, tmpbyte);
		}
		byte[] buff = baos.toByteArray();// 返回字节数组

		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (baos != null) {
			try {
				baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return buff;
	}

	public static void main(String[] args) throws IOException {
		File2Buf file2Buffer = new File2Buf();
		byte[] buff = null;
		String path = new String("D:/test1.txt");
		buff = file2Buffer.file2Buf(path);
		if (buff != null) {
			System.out.println("数组长度为" + buff.length);
			for (int i = 0; buff != null && i < buff.length; i++) {
				System.out.print(buff[i] + ",");
			}
		}

	}
}
