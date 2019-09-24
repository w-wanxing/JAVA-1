interface Animal
interface Anmial{
    void shout();
}
class Cat implements Animal{
	public void shout(){
		System.out.println("喵喵");
	}
}
class Dog implements Animal{
	public void shout(){
		System.out.println("汪汪");
	}
}
pubilc class Example13{
pubilc static void main(String[] args){
	Animal an1=new Cat();
		Animal an2=new Dog();
	animalShout(an1);
		animalShout(an2);
}
public static void animalShout(Animal an){
	an.shout();
}
}