package ��10����ҵ;
import java.util.*;
public class Input implements Runnable {
	private int num;
	private Storage st;
	Random r=new Random();
	Input(Storage st){
		this.st=st;
	}
	public void run() {
		while(true) {
			st.put(r.nextInt(100000));
		}
	}
	
}
