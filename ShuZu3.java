package jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//Q3二维数组查找
//思路：选右上角、左下角都可以。左上和右下因为是数组值的极端值而无法排除行列而不可选。这里选右上角。
//扩展部分:自写输入格式化，支持任何大小的数组输入
//注意Integer.toString和parseInt的用法
/*测试用例：
 * 	12 1 2 54 7
	12 23 5 44 8
	1 2 5 77 5
	4 4 56 44 51
	12 12 45 78 51
	51
*/
public class ShuZu3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<String> s =new ArrayList<String>();
		while(true) {
			String str=null;
				str=in.nextLine();
				if(str.equals("")) {
					break;
				}else {
					s.add(str);
				}
			
		}
		in.close();
		for(String x:s) {
			System.out.println(x);
		}
		String jishu=s.get(s.size()-1);
		int jieguo=Integer.parseInt(jishu);
		System.out.println("结果是"+jieguo);
		s.remove(s.size()-1);
		for(String x:s) {
			System.out.println(x);
		}
		//接下来将输入转化为数组
		int lo=s.size();
		int xiabiao=0;
		int[][] shuzu=new int[lo][lo];
		
		for(String i:s) {
			String[] temp=i.split(" ");//按照空格切分
			for(int m=0;m<temp.length;m++) {
				shuzu[xiabiao][m]=Integer.parseInt(temp[m]);
			}
			xiabiao++;
		}
		for(int i=0;i<shuzu.length;i++){
			System.out.println(Arrays.toString(shuzu[i]));
		}
		System.out.println(Try.test(shuzu,jieguo));
	}
}

class Try {
	public static boolean test(int[][] m, int n) {
		boolean result=false;
		if(m!=null) {
			int raw=m.length-1;
			int colum=0;
			if(m[colum][raw]==n) {
				result= true;
			}
			while(colum<=m.length-1&&raw>=0) {
				if(m[colum][raw]>n) {
					raw--;
				}else if(m[colum][raw]<n) {
					colum++;
				}else if (m[colum][raw]==n){
					 result=true;
					 break;
				}
			}
		}
		return result;
	}
}