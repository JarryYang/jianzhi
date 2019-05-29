package jianzhioffer;
/*用高效率方法实现输出斐波那契数列的第n项*/
public class Feibonaqie10 {
	public static void main(String[] args) {
		System.out.println(feibonaqie1(6));
		System.out.println(feibonaqie2(6));
	}
	public static int feibonaqie1(int n) {
		//最普通的递归的方法
		if(n<=0) {
			return 0;
		}
		else if(n==1) {
			return 1;
		}
		
		return feibonaqie1(n-1)+feibonaqie1(n-2);
		
		
	}
	public static int feibonaqie2(int n) {
		//高效的方法,其实就是循环。速度On
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
