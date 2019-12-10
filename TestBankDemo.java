interface BankAccount{
    void playIn(double amount);
    boolean withDraw(double amount);
    double getBalance();
}

//�����ӿ�ITransferBankAccount���̳л��ӿ�BankAccount��������ת�˷���transferTo().
interface ITransferBankAccount extends  BankAccount{
    boolean transferTo(BankAccount destunation,double amount);
}


/*������CurrentAccount(ʵ�ֻ��ӿ�ITransferBankAccount)��
���а���˽�����ݳ�Ա������name�����balance,
��ʵ�ִ�����playIn(),ȡ�����withdraw()��
��ѯ���getBanlance()������ת�˷���transferTo()��
���ط���toString()�������÷����������е�ǰ�˻��е���*/
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
        System.out.println("���㣬ȡ��ʧ��"); 
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
    
    
    
    public boolean transferTo(BankAccount destination, double amount) {//����ת��
            
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
    //�������У�ӵ�������˻����ֱ�Ϊ�ܲٺ�������
    //(1):�ܲٴ��1000���������2000��
    //(2):������ܲ�ת��1ԪǮ�����������˻���ǰ����
    public static void main(String[] args) {
        CurrentAccount bankCount1=new CurrentAccount("�ܲ�"); 
        CurrentAccount bankCount2=new CurrentAccount("����"); 
        bankCount1.playIn(1000);
        bankCount2.playIn(2000);
        bankCount2.transferTo(bankCount1,1);
        System.out.println(bankCount1.toString());
        System.out.println(bankCount2.toString());
    }

}