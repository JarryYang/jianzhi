package jianzhioffer;

import java.util.ArrayList;
import java.util.Stack;

/*机器人运动范围：m*n的方格.机器人从原点开始运动，每次可以上下左右移动，但是不能进去坐标数位之和大于k的格子，例如k=18，则可以进入（35，37）但不能进入（35，38）
 * .问机器人能够到达多少个格子
 * 这里并没有要求不可以重复踏入一个格子，所以不用回溯。*/
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
		//得到数位之和
		int sum=0;
		while(num>0) {
			sum+=num%10;
			num/=10;
		}
		return sum;
	}
	public static boolean check(int threshold,int rows,int cols,int row,int col,boolean[][] visited) {
		//判断机器人能否进入这片区域
		if(row>=0&&row<rows&&col>=0&&col<cols&&digit(row)+digit(col)<=threshold&&!visited[row][col]) {
			return true;
		}
		return false;
	}

}
