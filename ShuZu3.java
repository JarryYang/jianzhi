package jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
//Q3��ά�������
//˼·��ѡ���Ͻǡ����½Ƕ����ԡ����Ϻ�������Ϊ������ֵ�ļ���ֵ���޷��ų����ж�����ѡ������ѡ���Ͻǡ�
//��չ����:��д�����ʽ����֧���κδ�С����������
//ע��Integer.toString��parseInt���÷�
/*����������
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
		System.out.println("�����"+jieguo);
		s.remove(s.size()-1);
		for(String x:s) {
			System.out.println(x);
		}
		//������������ת��Ϊ����
		int lo=s.size();
		int xiabiao=0;
		int[][] shuzu=new int[lo][lo];
		
		for(String i:s) {
			String[] temp=i.split(" ");//���տո��з�
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