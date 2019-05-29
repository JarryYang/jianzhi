package jianzhioffer;

import java.util.Arrays;
import java.util.Collections;

//剑指offer第三题：找出长度为n的数组中任意一个重复数字，数字大小范围在0-n-1之间
//普通排序的方法要用O（nlgn）。hash虽然只用O（n），但是要额外申请O（n）空间。所以考虑On时间复杂度+O(1)空间复杂度的方法
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