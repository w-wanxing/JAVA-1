public class HelloWorldRunnable implements Runnable { 
   public void run() {      
   System.out.println("Hello Concurrent World");   
   }
    public static void main(String[] args) {   
	System.out.println("--------实现Runnable接口--------");    
    HelloWorldRunnable helloWorldRunnable = new HelloWorldRunnable();   
	System.out.println("--------创建线程--------");   
	Thread thread = new Thread(helloWorldRunnable);    
    System.out.println("--------启动线程--------");     
	thread.start();
    }
}