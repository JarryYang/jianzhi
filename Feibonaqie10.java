package jianzhioffer;
/*�ø�Ч�ʷ���ʵ�����쳲��������еĵ�n��*/
public class Feibonaqie10 {
	public static void main(String[] args) {
		System.out.println(feibonaqie1(6));
		System.out.println(feibonaqie2(6));
	}
	public static int feibonaqie1(int n) {
		//����ͨ�ĵݹ�ķ���
		if(n<=0) {
			return 0;
		}
		else if(n==1) {
			return 1;
		}
		
		return feibonaqie1(n-1)+feibonaqie1(n-2);
		
		
	}
	public static int feibonaqie2(int n) {
		//��Ч�ķ���,��ʵ����ѭ�����ٶ�On
		if(n<=0) {
			return 0;
		}
		else if(n==1) {
			return 1;
		}
		int first=0;
		int second=1;
		int third=0;
		for(int i=0;i<n-1;i++) {
			third=first+second;
			first=second;
			second=third;
		}
		return third;
	}
}
