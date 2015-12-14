package test1_File2Buff;

import java.io.ByteArrayOutputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.File;

/**
 * ��{@code File2Buf}����Ҫʵ�ֽ��ı��е����ݶ�ȡ��������byte[]�������������Ҫע��ĵط�
 * ���ļ���ȡ�쳣�Ĵ����Լ���ȡ�������������Լ����Ĺر�
 * 
 * @author shizhp
 * @data 2015��12��14��
 */
public class File2Buf {

	/**
	 * @param path
	 * @return ��ʾ�ļ�����Ascii����ֽ�����
	 * @throws IOException
	 */
	public byte[] file2Buf(String path) throws IOException {
		File fobj = new File(path);
		if (!fobj.isFile() || !fobj.exists()) {
			throw new IOException("file is not exist");
		}
		BufferedInputStream fis = null;
		ByteArrayOutputStream baos = null;
		byte[] buff = null;
		try {
			fis = new BufferedInputStream(new FileInputStream(fobj));
			baos = new ByteArrayOutputStream(4096);
			byte[] tmpBuff = new byte[4096];
			int tmpbyte = 0;
			while ((tmpbyte = fis.read(tmpBuff)) != -1) {
				baos.write(tmpBuff, 0, tmpbyte);
			}
			buff = baos.toByteArray();
		} finally {
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
		}
		return buff;
	}

	/**һ�ָ���Ч�ķ����������˶���Ĺ�����ֱ�Ӷ�ȡ�����ص������������
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public byte[] file2Buf2(String path) throws IOException {
		File fobj = new File(path);
		if (!fobj.isFile() || !fobj.exists()) {
			throw new IOException("file is not exist");
		}
		InputStream fis = null;
		int count = 0;
		byte[] buff = new byte[(int) fobj.length()];
		try {
			fis = new FileInputStream(fobj);
			int readedCount = 0;
			//(int)(fobj.length() > 4096? 4096 : fobj.length() )
			while ((readedCount = fis.read(buff)) != -1) {
				count += readedCount;
			}
			return buff;
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		File2Buf file2Buffer = new File2Buf();
		byte[] buff = null;
		String path = new String(
				"C:/Users/John/git/HelloWorld/src/test1_File2Buff/test1.txt");
		buff = file2Buffer.file2Buf2(path);
		if (buff != null) {
			System.out.println("���鳤��Ϊ" + buff.length);
			for (int i = 0; buff != null && i < buff.length; i++) {
				System.out.print(buff[i] + ",");
			}
		}

	}
}
