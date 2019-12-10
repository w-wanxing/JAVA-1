public class ATM {
    private static ArrayList<Account>
	  accounts=new ArrayList<Account>(); 
	      private static Scanner scanner;
		    //    private static boolean isLogin1 = false;
			  //    private static boolean isLogin2 = false;
 private static boolean isLogin = false;
   public static void showMenu() {     
    System.out.println("请选择操作");
	System.out.println("1.存钱");
	System.out.println("2.取钱"); 
    System.out.println("3.查询余额"); 
    System.out.println("0.取卡");
 }    
   public static void processMenu(int id, int command) {  //执行指定的命令     
      switch (command) {     
	       case 1:
		   System.out.println("请输入存入的钱数"); 
		   double depositMoney = scanner.nextDouble(); 
            accounts.get(id).deposit(depositMoney);   
		    break; 
	//           double withdrawMoney = scanner.nextDouble(); 
	//             accounts.get(id).withDraw(withdrawMoney); 
	//             break; 
	//            System.out.println("您账户里的余额式" + accounts.get(id).getBalance()); 
	//            break;          
	  case 2:             
	   System.out.println("请输入取出的钱数");
	    double withdrawMoney = scanner.nextDouble();
        accounts.get(id).withDraw(withdrawMoney);
         break;   
      case 3:  
	   System.out.println("您账户里的余额式" + accounts.get(id).getBalance());    
	    break;     
	  case 0:     
        isLogin = false; 
        System.out.println("取卡并退出");
        break;    
	    default:    
         System.out.println("请输入正确的指令:");  
	       break;     
    }      
    }     
	   public static void welcome(){//一定要定义为静态方法   
	        System.out.println("************************************************");   
			System.out.println("*************欢迎光临*************************"); 
			System.out.println("***********请插入银行卡进行操作************");   
			System.out.println("*************************************************");  
 }
 public static void main(String[] args) throws Exception {
 // TODO Auto-generated method stub
    Account acc1 = new Account(001, 100,100);
	accounts.add(acc1);
	Account acc2 = new Account(002, 200,150);              
	accounts.add(acc2);              
	Account acc3 = new Account(003, 300,200);              
	accounts.add(acc3);              
	Account acc4 = new Account(004, 400,250);              
	accounts.add(acc4);  //              
	while(true) {           
	ATM.welcome();           
	scanner = new Scanner(System.in);              
	int id = scanner.nextInt();
	//            for (int i = 0; i < 3; i++) {            
	for (Account acc : accounts) {  //检查账户和密码是否相符                
	if ( id == acc.getId()) {  
	//                    isLogin1 = true;                       
	System.out.println("请输入密码");                    
	int password= scanner.nextInt();                    
	if ( password == acc.getPassword()) {  //)&&(password==acc.password)                        
	isLogin = true;                         
	break;                
	}                                  
	}
	//              else {
	//                    System.out.println("请输入正确的账户");
	//                }                            }
	//                    else {
	//                        System.out.println("请输入正确的密码");
	//                    }
	//                    
	//此处不能直接用acc.id 因为id 是私有变量
	//                }  
	//                else {
	//                     int id2= scanner.nextInt();
	//                     break;
	//                }            
	//检测账号和密码是否正确 
	 //            }
	 //三次机会                                         
	 //                else {
	 //                    System.out.println("请输入正确的ID");
	 //                     int id2 = scanner.nextInt();
	 //                   continue;
	 //                }
	 //            }
	 //                
	 //          System.out.println("请输入密码");
	 //         int password = scanner.nextInt();       
	 //       
	 //      else {
	 //            System.out.println("请输入正确的ID");
	 //             int password2= scanner.nextInt();
	 //             break;//        }  
	 //        
	 //     while (isLogin1==true||isLogin2==true)
	 //     {
	 //         isLogin=true;
	 //     }                     
	 while (isLogin) {                  
	 showMenu();                  
	 scanner = new Scanner(System.in);                  
	 int command = scanner.nextInt();                  
	 processMenu(id, command);               
	 }                    
	}       
  }        
}
