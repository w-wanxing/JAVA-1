interface BankAccount{
    void playIn(double amount);
    boolean withDraw(double amount);
    double getBalance();
}

//创建接口ITransferBankAccount（继承基接口BankAccount），包含转账方法transferTo().
interface ITransferBankAccount extends  BankAccount{
    boolean transferTo(BankAccount destunation,double amount);
}


/*创建类CurrentAccount(实现基接口ITransferBankAccount)，
类中包含私有数据成员：名字name和余额balance,
并实现存款方法：playIn(),取款方法：withdraw()，
查询余额getBanlance()，银行转账方法transferTo()，
重载方法toString()方法，该方法返回银行当前账户中的余额。*/
class CurrentAccount implements ITransferBankAccount{
    private String name;
    private double balance;
    
    public CurrentAccount(String name) {
        super();
        this.name = name;
    }
    
    public void playIn(double amount){
        this.balance+=amount;
    }
    
    public boolean withDraw(double amount){
        if(this.balance>=amount){     
            this.balance-=amount;     
            return true;     
            }     
        System.out.println("余额不足，取款失败"); 
        return false;

    }
    public double getBalance(){
        return balance;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    public boolean transferTo(BankAccount destination, double amount) {//银行转账
            
        boolean result;     
        if((result=withDraw(amount))==true) {    
            destination.playIn(amount);
        }
        return result;
         
    }
    
     
    
    @Override
    public String toString() {
        return "CurrentAccount [name=" + name + ", balance=" + balance + "]";
    }
    }



public class TestBankDemo {
    //主函数中：拥有两个账户：分别为曹操和刘备，
    //(1):曹操存款1000，刘备存款2000。
    //(2):刘备向曹操转账1元钱，返回两个账户当前的余额。
    public static void main(String[] args) {
        CurrentAccount bankCount1=new CurrentAccount("曹操"); 
        CurrentAccount bankCount2=new CurrentAccount("刘备"); 
        bankCount1.playIn(1000);
        bankCount2.playIn(2000);
        bankCount2.transferTo(bankCount1,1);
        System.out.println(bankCount1.toString());
        System.out.println(bankCount2.toString());
    }

}