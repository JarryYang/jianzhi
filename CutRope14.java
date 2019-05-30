package jianzhioffer;
/*减绳子问题：长度为n>1的绳子剪成m>1段，每段记作k【i】。问他们的可能的最大乘积是多少。
 * 三种解法，n^2的dp和n的空间的dp加O1的贪婪算法
 * dp算法的转移公式：f(n)=max(f(i)*f(n-i))，但是要采用从下向上的方法
 * 贪婪算法需要有证明好的定理的支撑：当n>5时候，3（n-3）>2(n-2)>n)*/
public class CutRope14 {
	public static void main(String[] args) {
		System.out.println(dp(13));
		System.out.println(tanlan(13));
	}
	public static int dp(int n) {
		if(n<2) {
			return 0;
		}
		if(n==2) {
			return 1;
		}
		if(n==3) {
			return 2;
		}
		int[] products=new int[n+1];
		products[0]=0;
		products[1]=1;
		products[2]=2;
		products[3]=3;
		products[4]=4;
		int max=0;
		for(int i=5;i<=n;++i) {//i=5=2*3
			max=0;
			for(int j=1;j<=i/2;++j) {
				int product=products[j]*products[i-j];
				if(max<product) {
					max=product;
				}
				products[i]=max;
			}
		}
		max=products[n];
		return max;
	}
	public static int tanlan(int n) {
		if(n<2) {
			return 0;
		}
		if(n==2) {
			return 1;
		}
		if(n==3) {
			return 2;
		}
		int times3=n/3;
		if(n-3*times3==1) {
			times3=times3-1;
		}
		int times2=(n-times3*3)/2;
		if(times2!=0) {
			
			return (int) (Math.pow(3, times3)*Math.pow(2, times2));//最后一段2*2比1*3大
		}else
			return (int) (Math.pow(3, times3));//最后一段2*2比1*3大

	}
}
