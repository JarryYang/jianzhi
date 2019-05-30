package jianzhioffer;

import java.util.ArrayList;
import java.util.Stack;

/*�������˶���Χ��m*n�ķ���.�����˴�ԭ�㿪ʼ�˶���ÿ�ο������������ƶ������ǲ��ܽ�ȥ������λ֮�ʹ���k�ĸ��ӣ�����k=18������Խ��루35��37�������ܽ��루35��38��
 * .�ʻ������ܹ�������ٸ�����
 * ���ﲢû��Ҫ�󲻿����ظ�̤��һ�����ӣ����Բ��û��ݡ�*/
public class ActionScope13 {
	public static void main(String[] args) {
		System.out.println(moving(1,2,2));
	}
	public static int moving(int threshold,int raws,int cols) {
		if(threshold<0||raws<=0||cols<=0) {
			return 0;
		}
		boolean[][] visited=new boolean[raws][cols];
		for(int i=0;i<raws;i++) {
			for(int j=0;j<cols;j++) {
					visited[i][j]=false;
			}
		}
		int count =movingCountCore(threshold,raws,cols,0,0,visited);
		return count;
	}
	public static int movingCountCore(int threshold,int raws,int cols,int raw,int col,boolean[][] visited) {
		int count =0;
		if(check(threshold,raws,cols,raw,col,visited)) {
			visited[raw][col]=true;
			count=1+movingCountCore(threshold,raws,cols,raw-1,col,visited)+movingCountCore(threshold,raws,cols,raw+1,col,visited)+
					movingCountCore(threshold,raws,cols,raw,col-1,visited)+movingCountCore(threshold,raws,cols,raw,col+1,visited);
		}
		return count;
	}
	public static int digit(int num) {
		//�õ���λ֮��
		int sum=0;
		while(num>0) {
			sum+=num%10;
			num/=10;
		}
		return sum;
	}
	public static boolean check(int threshold,int rows,int cols,int row,int col,boolean[][] visited) {
		//�жϻ������ܷ������Ƭ����
		if(row>=0&&row<rows&&col>=0&&col<cols&&digit(row)+digit(col)<=threshold&&!visited[row][col]) {
			return true;
		}
		return false;
	}

}
