package jianzhioffer;
/*二进制中1的个数：设计一个函数，输入一个整数，输出二进制中1的个数*/
public class Binary1num15 {
public static void main(String[] args) {
	System.out.println(Binary1num3(2));
}
public static int Binary1num1(int x) {
	//第一种，可能引起死循环的最简单的移位算法，注意移位不可以换成除以二因为效率快的多。
	//存在问题，负数，最高位置是1不能简单设置保留1，会引起死循环。
	int jishu=0;
	while(x>0) {
		if((x&1)!=0) {
			jishu++;
		}
		x=x>>1;
	}
	return jishu;

}
public static int Binary1num2(int x) {
	//第2种，解决存在负数的情况，常规解法：我们不移动x的，移动1的位数
	int jishu=0;
	int flag=1;
	while(flag!=0) {
		if((x&flag)!=0) {
			jishu++;
		}
		flag=flag<<1;
	}
	return jishu;
}
public static int Binary1num3(int x) {
	//第3种，第二种无论如何都要循环32次。太慢了，现在有几个1就循环几次
	int jishu=0;
	while(x!=0) {
		x=x&(x-1);
		jishu++;
	}
	return jishu;
}
}
