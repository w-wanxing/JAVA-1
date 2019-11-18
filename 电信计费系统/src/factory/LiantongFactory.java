package factory;
import user.*;
import 通信公司.*;

public class LiantongFactory implements Factory{
	//创建联通公司
	public User produceuser() {
		return new Liantong();
	}
}
