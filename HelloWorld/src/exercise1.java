import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
public class exercise1 {
	/*turn a file into a byte buffer
	 * if the file doesn't exit or read error return null 
	 * 20151208 by shizhp
	 */
	public static byte[] file2buf(File fobj)
	{
		byte[] buff= null;//返回字节数组
		InputStream fis = null;//定义文件读取输入流
		ByteArrayOutputStream baos = null;//定义文件输出流
		try{
			
			if(fobj.isFile()&&fobj.exists())
			{	//return buff;
				//int buffLength=(int)fobj.length();//根据文件的长度来分配byte数组长度
				byte[] tmpBuff = new byte[4096];//缓冲字节数组
				fis =new FileInputStream(fobj);
				baos = new ByteArrayOutputStream(4096);
				int tmpbyte = 0;//获取文件读取信息
				while((tmpbyte = fis.read(tmpBuff)) != -1)
				{
					baos.write(tmpBuff,0,tmpbyte);
				}
				//fis.read(buff);
				//fis.close();
				buff = baos.toByteArray();
				// outByte = fis; 
				
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{			
			e.printStackTrace();
		}
		finally
		{
			if(fis != null)
			{
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(baos != null)
			{

				try {
					baos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		return buff;
	}
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		File fobj = null;

		fobj=new File("D:/test.txt");	
			byte[] buff=null;
		//if(fobj.isFile()&&fobj.exists())//若文件存在 进行读取操作
		buff = file2buf(fobj);
		if(buff!=null)
		{
			System.out.println("数组长度为"+buff.length);
			for(int i=0;buff!=null&&i<buff.length;i++)
			{
				System.out.println(buff[i]);
			}
		}
		//fobj.close();		
	    }
}

