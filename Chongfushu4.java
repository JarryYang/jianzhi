package jianzhioffer;

import java.util.Arrays;
import java.util.Collections;

//��ָoffer�����⣺�ҳ�����Ϊn������������һ���ظ����֣����ִ�С��Χ��0-n-1֮��
//��ͨ����ķ���Ҫ��O��nlgn����hash��Ȼֻ��O��n��������Ҫ��������O��n���ռ䡣���Կ���Onʱ�临�Ӷ�+O(1)�ռ临�Ӷȵķ���
public class Chongfushu4 {
	public static void main(String[] args) {
		int[] arr=new int[] {2,3,0,1,2,5,3};
		Chongf.find(arr);
	}
}
class Chongf{
	public static void find(int[] x) {
		int length=x.length;
		boolean s=false;
		for(int i=0;i<length;i++) {
			while(i!=x[i]) {
				int j=x[i];
				int temp=x[j];
				if(temp==j) {
					s=true;
					System.out.println(j);
					break;
				}else {
				x[j]=x[i];
				x[i]=temp;}
				
			}
		}
		System.out.println(s);
	}
}