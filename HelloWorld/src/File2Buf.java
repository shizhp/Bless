import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.File;

/**
 * @ClassName: File2Buf
 * @Discription: TODO(turn a file into a byte array)
 * @author shizhp
 * @date: 2015��12��11�� ����11:30:10 <br/>
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
		if (!fobj.isFile() || !fobj.exists()) {//���ļ������ڻ��߸�·�������ļ����׳��쳣
			throw new IOException("file is not exist");
		}
		InputStream fis = new FileInputStream(fobj);// �����ļ���ȡ������
		ByteArrayOutputStream baos = new ByteArrayOutputStream(4096);// �����ļ������
		byte[] tmpBuff = new byte[4096];// �����ֽ�����
		int tmpbyte = 0;// ��ȡ�ļ���ȡ״̬��Ϣ
		while ((tmpbyte = fis.read(tmpBuff)) != -1) {
			baos.write(tmpBuff, 0, tmpbyte);
		}
		byte[] buff = baos.toByteArray();// �����ֽ�����

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
			System.out.println("���鳤��Ϊ" + buff.length);
			for (int i = 0; buff != null && i < buff.length; i++) {
				System.out.print(buff[i] + ",");
			}
		}

	}
}
