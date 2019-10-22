public class DownLoad implements Runnable{	
    private Socket socket;
	public DownLoad() {}
	public DownLoad(Socket socket){		
	   this.socket=socket;
	   }
	public void run() {		
	    try {		
	       FileInputStream fis = new FileInputStream("new.jpg");		
	       OutputStream out = socket.getOutputStream();			
	       int len=0;		
	       byte[] arr = new byte[1024];	
	       while((len=fis.read(arr))!=-1){			
	         out.write(arr,0,len);			
			 }		
			 fis.close();				
			 socket.shutdownOutput();		
			 socket.close();				
			 } catch (Exception e) {
				 e.printStackTrace();		
				 }	
	} 
}
