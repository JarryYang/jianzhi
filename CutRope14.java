package jianzhioffer;
/*���������⣺����Ϊn>1�����Ӽ���m>1�Σ�ÿ�μ���k��i���������ǵĿ��ܵ����˻��Ƕ��١�
 * ���ֽⷨ��n^2��dp��n�Ŀռ��dp��O1��̰���㷨
 * dp�㷨��ת�ƹ�ʽ��f(n)=max(f(i)*f(n-i))������Ҫ���ô������ϵķ���
 * ̰���㷨��Ҫ��֤���õĶ����֧�ţ���n>5ʱ��3��n-3��>2(n-2)>n)*/
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
			
			return (int) (Math.pow(3, times3)*Math.pow(2, times2));//���һ��2*2��1*3��
		}else
			return (int) (Math.pow(3, times3));//���һ��2*2��1*3��

	}
}
