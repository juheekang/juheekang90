package kr.or.ddit.basic;

import java.io.File;

public class FileTest03 {

	public static void main(String[] args) {
		File f = new File("d:/d_other/test.txt");  //대소문자를 맞춰야하지만 윈도우는 상관없다.
		System.out.println(f.getName() + "의 크기 : " + f.length() + "byte(s)");
		
		System.out.println("path : " + f.getPath());
		System.out.println("absolutePath : " + f.getAbsolutePath());
		System.out.println();
		
		File f2 = new File(".");
		System.out.println("path : " + f2.getPath());
		System.out.println("absolutePath : " + f2.getAbsolutePath());
		System.out.println();
		
	}

}
