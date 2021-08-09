package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
	d드라이브의 d_other폴더에 있는 '스폰지밥.png'파일을
	d드라이브의 d_other폴더의 하위 폴더 중에서 '연습용'폴더에 
	'스폰지밥_복사본.png'파일로 복사하는 프로그램을 작성하시오.
 */
public class FileCopy {

	public static void main(String[] args) {
		try {
//			FileReader fr = new FileReader("d:/d_other/스폰지밥.png");
			FileInputStream fis = new FileInputStream("d:/d_other/스폰지밥.png");
			FileOutputStream fos = new FileOutputStream("d:/d_other/연습용/스폰지밥.png");
			
			int c; 

			while ((c = fis.read()) != -1) {
				fos.write(c);	
				System.out.println("복사 완료!!");
			}
			
			fis.close();
			fos.close();
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
	}

}
