import java.io.*;
public class exercise1 {
	/*turn a file into a byte buffer
	 * if the file doesn't exit or read error return null 
	 * 20151208 by shizhp
	 */
	public static byte[] file2buf(File fobj)
	{
		try{
			byte[] buff=null;
			if(fobj.isFile()&&fobj.exists())
			{	//return buff;
				int buffLength=(int)fobj.length();//根据文件的长度来分配byte数组长度
				buff=new byte[buffLength];
				FileInputStream fis=new FileInputStream(fobj);
				fis.read(buff);
				fis.close();
				return buff;
			}
			else
			{
				System.out.println("error in reading file");
				return buff;
			}
		}
		catch(Exception e)
		{
			byte[] buff=null;
			return buff;
			//System.out.println("error");
			//e.printStackTrace();
		}
	}
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {//throws Exception{
		// TODO Auto-generated method stub
		File fobj=new File("D:\\test1.txt");
		byte[] buff=null;
		//if(fobj.isFile()&&fobj.exists())//若文件存在 进行读取操作
			buff=file2buf(fobj);
		if(buff!=null)
		{
			System.out.println(buff.length);
			for(int i=0;buff!=null&&i<buff.length;i++)
			{
				System.out.println(buff[i]);
			}
		}
		else
			System.out.println("no such file exists");
		//fobj.close();
		
		
	    }
}

