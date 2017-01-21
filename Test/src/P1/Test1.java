package P1;

import java.io.IOException;
import java.util.ArrayList;

public class Test1 {
	
	
	public void m1() throws Exception{
		System.out.println("p");
	}
	public void m2() throws IOException{
		System.out.println("hf");
	}
	public static void main(String[] args) {
	
		Test1 t = new Test1();
		T2 t2 = new T2();
	
		// t2.m2(9);
		try{
		t.m1();
		}catch(Exception e){
			System.out.println(e);
		}
	}


}
