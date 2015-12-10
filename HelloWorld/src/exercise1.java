import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;

public class exercise1 {
	/*
	 * turn a file into a byte buffer if the file doesn't exit or read error
	 * return null 20151208 by shizhp
	 */
	public static byte[] file2buf(File fobj) throws Exception {
		byte[] buff = null;// 返回字节数组
		InputStream fis = null;// 定义文件读取输入流
		ByteArrayOutputStream baos = null;// 定义文件输出流
		if(!fobj.isFile() || !fobj.exists()){
			throw new Exception("file is not exist");
		}
		if(fobj.isFile() && fobj.exists()) {
			byte[] tmpBuff = new byte[4096];// 缓冲字节数组
			fis = new FileInputStream(fobj);
			baos = new ByteArrayOutputStream(4096);
			int tmpbyte = 0;// 获取文件读取信息
			while ((tmpbyte = fis.read(tmpBuff)) != -1) {
				baos.write(tmpBuff, 0, tmpbyte);
			}
			buff = baos.toByteArray();
		}
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

	public static void main(String[] args)throws Exception {
		File fobj = null;
		byte[] buff = null;
		fobj = new File("D:/test1.txt");
		if(!fobj.isFile() || !fobj.exists()){
			throw new Exception("file is not exist");
		}
		buff = file2buf(fobj);
		if (buff != null) {
			System.out.println("数组长度为" + buff.length);
			for (int i = 0; buff != null && i < buff.length; i++) {
				System.out.println(buff[i]);
			}
		}
	}
}
