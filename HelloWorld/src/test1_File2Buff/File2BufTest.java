package test1_File2Buff;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Test;

/**
 * ��Ҫ��ɶ�File2Buf�ĵ�Ԫ���ԣ�ע��Կ��ļ��Ĳ������� junit����ζ��쳣���д����Լ���ζ�һ���ܴ���ļ����в��ԣ���ʱδ��ʵ�֣�
 * 
 * @author shizhp
 * @data 2015��12��14��
 */
public class File2BufTest {
	/**
	 * @throws IOException
	 */
	@Test
	public void test() throws IOException {
		File2Buf exerTest = new File2Buf();
		byte[] expBuff1 = { 100, 97, 111, 105, 117, 104, 102, 100, 111, 97,
				104, 111, 110, 111, 97, 100, 110, 111, 110 };
		assertArrayEquals(
				expBuff1,
				exerTest.file2Buf("C:/Users/John/git/HelloWorld/src/test1_File2Buff/test1.txt"));
		byte[] expBuff2 = {};
		assertArrayEquals(
				expBuff2,
				exerTest.file2Buf("C:/Users/John/git/HelloWorld/src/test1_File2Buff/test2.txt"));
		/*
		 * byte[] expBuff3 = {}; try { assertArrayEquals(expBuff3,
		 * exerTest.file2buf("D:/test3.txt")); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
	}

	@Test
	public void test2() throws IOException {
		File2Buf exerTest = new File2Buf();
		byte[] expBuff1 = { 100, 97, 111, 105, 117, 104, 102, 100, 111, 97,
				104, 111, 110, 111, 97, 100, 110, 111, 110 };
		assertArrayEquals(
				expBuff1,
				exerTest.file2Buf2("C:/Users/John/git/HelloWorld/src/test1_File2Buff/test1.txt"));
		byte[] expBuff2 = {};
		assertArrayEquals(
				expBuff2,
				exerTest.file2Buf2("C:/Users/John/git/HelloWorld/src/test1_File2Buff/test2.txt"));
		/*
		 * byte[] expBuff3 = {}; try { assertArrayEquals(expBuff3,
		 * exerTest.file2buf("D:/test3.txt")); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
	}
}
