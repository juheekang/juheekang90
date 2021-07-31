package kr.or.ddit.basic;

import java.util.Iterator;
import java.util.Vector;

public class VectorTest01 {
	public static void main(String[] args) {
		//객체생성
		Vector v1 = new Vector();
		System.out.println("처음 크기: "+ v1.size());
		
		//데이터 추가: add(추가할 데이터),컬렉션에는 객체만저장가능
		//반환값: 성공시(true), 실패(false)
		v1.add("aaaaa");
		v1.add(new Integer(1111));
		v1.add(123); //오토박싱이 이루어진다.
		v1.add('a');
		v1.add(3.14);
		boolean r = v1.add(true);
		
		System.out.println("현재 크기: "+ v1.size());
		System.out.println("반환값: + r");
		System.out.println("v1 => "+ v1);
		System.out.println();
		
		// 데이터 추가2: addElement(추가할 데이터)
		// ==> 이전 버전에서부터 지원하는 메서드
		// ==> 이전 버전으로 작성된 프로그램을 위해 남겨 놓은 메서드
		v1.addElement("cccc");
		System.out.println("v1 = > "+v1);
		
		//데이터 추가 2: add(index, 데이터);
		//==>'index' 번째에 '데이터'를 끼워 넣는다.
		//==> 'index'는 0번부터 시작한다.
		//==> 반환값은 없다.
		v1.add(1,"kkk");
		System.out.println("v1 = > "+v1);
		
		//데어터 꺼내오기: get(index);꺼내올때도 object 형으로 나온다. object를 int에 넣어줄때 형변환을 해야한다.
		//==> 'index'번째 데이터를 반환한다
		int data = (int) v1.get(3);
		System.out.println("3번쨰 데이터: "+ data);
		
		//데이터 변경하기 : set(index, 새로운데이터);
		//==> 'index'번째의 데이터를 '새로운데이터'로 덮어쓴다.
		//==> 반환값 : 원래의 데이터
		String temp = (String) v1.set(0, "ZZZZ");
		System.out.println("v1 => "+ v1);
		System.out.println("반환값: "+ temp);
		
		//데이터 삭제하기 : remove(index);
		//==> 'index'번째의 데이터를 삭제한다.
		//==> 반환값 : 삭제된 데이터
		temp = (String) v1.remove(0);
		System.out.println("v1 => "+ v1);
		System.out.println("삭제된 데이터: "+ temp);
		
		//데이터 삭제하기 2: remove(삭제할 데이터);
		//==> '삭제할데이터'를 찾아 삭제한다.
		//==> '삭제할데이터'가 여러개이면 앞에서부터 삭제된다
		//==> 반환값 : 삭제성공(true), 삭제 실패(false)
		//==> 삭제할 데이터가 '정수형'이거나 'char형' 일경우에는 반드시 객체로 
		//     변환해서 사용해야 한다.
		v1.remove("cccc");
		System.out.println("삭제후 : "+ v1);
		
		v1.remove(new Integer(123));
		System.out.println("삭제후 : "+ v1);
		
		v1.remove(new Character ('a'));
		System.out.println("삭제후 : "+ v1);
		
		v1.remove(true);
		v1.remove(3.14);
		System.out.println("삭제후 : "+ v1);
		
		// 전체 데이터 삭제: clear();
		v1.clear();
		System.out.println("전체 삭제후 : `+v1");
		
		//
		/*
		 * 제네릭타입(Generic Type) ==> 클래스 내부에서 사용할 데이터의 타입을 
		 * 							외부에서 지정하는 기법
		 * 		==> 객체를 선언할때 < > 안에서 그 객체가 사용할 데이터의 타입을 정해주는것을 말한다.
		 * 		==> 이런식으로 객체를 선언하게 되면 다른 종류의 데이터를 저장할수 없다.
		 * 		==> 이때 제네릭으로 선언될 수 있는 데이터 타입을 클래스 형이어야 한다.
		 * 			(int ==> Integer, boolean ==> Boolean
		 * 			 char==> Character 등으로 대체해서 사용해야 한다.)
		 * 		==> 제네릭 타입으로 선언하게 되면 데이터를 꺼내 올때 별도의 형변환이 필요없다.
		 */
		Vector<String> v2 = new Vector<String>();
		v2.add("안녕하세요");
		// v2.add(123);   오류: 다른 종료의 데이터를 저장할수 없음
		
		String temp2 = v2.get(0);	//형변환없이 자료를 꺼내올수있다.
		
		Vector<Vector> vv = new Vector<Vector>();
		Vector<Vector<Vector>> vvv = new Vector<Vector<Vector>>();
		
		//-------------------------
		System.out.println("---------------------------------");
		
		v2.clear();
		v2.add("AAA");
		v2.add("BBB");
		v2.add("CCC");
		v2.add("DDD");
		v2.add("EEE");
		
		Vector<String> v3 = new Vector<String>();
		v3.add("BBB");
		v3.add("EEE");
	
		System.out.println("v2 = "+ v2);
		System.out.println("v3 = "+ v3);
		
		//데이터 삭제하기: removeAll(Collection 객체);
		//		==> 'Collection객체'가 가지고 있는 데이터를 찾아서 모두 삭제
		//		==> 반환값: 삭제 성공(true), 삭제 실패(false)
		v2.removeAll(v3);
		System.out.println("v2 => + v2");
		//---------------------------------
		v2.clear();
		
		v2.add("AAA");
		v2.add("BBB");
		v2.add("CCC");
		v2.add("DDD");
		v2.add("EEE");

		// 벡터의 데이터를 순서대로 모두 가져와 사용하고 싶으면 반복문을 사용하면 된다
		// (주로 for문 사용)
		System.out.println("일반적인 for문 사용");
		for(int i=0; i<v2.size(); i++) {
			System.out.println(i + "번째 자료: " + v2.get(i));
		}
		System.out.println("---------------------");
		 
		// 향상된 for문
		System.out.println("향상된 for문 사용");
		for(String s : v2) {
			System.out.println(s);
		}
		System.out.println("---------------------");
		
		
	}
}
