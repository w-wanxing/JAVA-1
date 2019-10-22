publie class MyRunnable implements Runnable{
	publie void run(){
		for (int i = 0; i < 50;i++){
			System.out.println("new");
		}
	}
    publie static void main (String[] arge){
    	new Thead(new MyRunnable()).start();
		for (int i = 0; i < 100;i++){
			System.out.println("main");
		}
	}
}