package ��10����ҵ;

public class Storage {
	private String[] cells = new String[10];
	private int inPos=1,outPos=1;
	private int count=0;

	public synchronized void put(int num) {
		try {
			while(count ==cells.length) {
				this.wait();
			}
			cells[inPos]=String.valueOf(num);
			System.out.println(cells[inPos]+"�û���½");
			inPos++;	
			if(inPos==cells.length) {
				inPos=0;
			}
			count++;
			System.out.println("������"+count+"�û�����");
			Thread.sleep(1000);
			this.notify();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void get(int num) {
		try {
			while (count==0) {
				this.wait();
			}
			String name="a";
			System.out.println(cells[outPos]+"����ע��");
			cells[outPos]=name;	
			outPos++;
			if(outPos==cells.length)
				outPos=0;
			System.out.println("������"+count+"�û�����");
			Thread.sleep(1000);
			this.notify();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
