package jianzhioffer;
/*��������1�ĸ��������һ������������һ�������������������1�ĸ���*/
public class Binary1num15 {
public static void main(String[] args) {
	System.out.println(Binary1num3(2));
}
public static int Binary1num1(int x) {
	//��һ�֣�����������ѭ������򵥵���λ�㷨��ע����λ�����Ի��ɳ��Զ���ΪЧ�ʿ�Ķࡣ
	//�������⣬���������λ����1���ܼ����ñ���1����������ѭ����
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
	//��2�֣�������ڸ��������������ⷨ�����ǲ��ƶ�x�ģ��ƶ�1��λ��
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
	//��3�֣��ڶ���������ζ�Ҫѭ��32�Ρ�̫���ˣ������м���1��ѭ������
	int jishu=0;
	while(x!=0) {
		x=x&(x-1);
		jishu++;
	}
	return jishu;
}
}
