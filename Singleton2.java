package jianzhioffer;

import org.junit.jupiter.api.Test;


public class Singleton2 {
	@Test
	public void ceshi() {
		Singleton a =Singleton.get();
		Singleton b =Singleton.get();
		System.out.println(a==b);
	}
	
	
}
//普通的饿汉模式
class Singleton{
	private static Singleton instance=new Singleton();
	private Singleton() {
		
	}
	public static Singleton get() {
		return instance;
	}
}
//最普通的懒汉单例模式,只适用于单线程环境
class Singleton1{
	private static Singleton1 instance=null;
	private Singleton1() {
		
	}
	public static Singleton1 get() {
		if(instance==null) {
			instance=new Singleton1();
		}return instance;
	}
}
//改进版懒汉单例模式,可用于多线程环境
class Singleton3{
	private static Singleton3 instance=null;
	private Singleton3() {
		
	}
	public static Singleton3 get() {
		if(instance==null) {//提高效率，告诉其他线程，如果已经创建好了就不要再继续等了
		synchronized(Singleton3.class){//因为static内部不能有this或者super，因为static是对类而言，后面那两个是对对象而言的
		if(instance==null) {
			instance=new Singleton3();
		}
		}}
		return instance;
	}
}