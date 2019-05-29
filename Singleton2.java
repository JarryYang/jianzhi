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
//��ͨ�Ķ���ģʽ
class Singleton{
	private static Singleton instance=new Singleton();
	private Singleton() {
		
	}
	public static Singleton get() {
		return instance;
	}
}
//����ͨ����������ģʽ,ֻ�����ڵ��̻߳���
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
//�Ľ�����������ģʽ,�����ڶ��̻߳���
class Singleton3{
	private static Singleton3 instance=null;
	private Singleton3() {
		
	}
	public static Singleton3 get() {
		if(instance==null) {//���Ч�ʣ����������̣߳�����Ѿ��������˾Ͳ�Ҫ�ټ�������
		synchronized(Singleton3.class){//��Ϊstatic�ڲ�������this����super����Ϊstatic�Ƕ�����ԣ������������ǶԶ�����Ե�
		if(instance==null) {
			instance=new Singleton3();
		}
		}}
		return instance;
	}
}