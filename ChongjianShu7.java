package jianzhioffer;

import java.util.Arrays;

//����ǰ������������������ԭ�����������ͷ�ڵ�.˼·���õݹ�ķ�����
public class ChongjianShu7 {
	public static void main(String[] args) {
		int[] qianxu=new int[] {1,2,4,7,3,5,6,8};
		int[] zhongxu=new int[] {4,7,2,1,5,3,8,6};
		BinaryTreeNode result;
		result=binaryTree(qianxu,zhongxu);
		print(result);
	}
	
	public static void print(BinaryTreeNode tre) {//��ӡ�����Խڵ�Ϊ��־���������
		if(!tre.equals(null)) {
			if(tre.left!=null) {
				print(tre.left);
			}if(tre.right!=null) {
				print(tre.right);
			}
			System.out.println(tre.value);//�ı���仰��λ�ã��ͻ�ı������ʽ
		}
	}
	
	public static BinaryTreeNode binaryTree(int[] x, int[] y) {
		if((x==null)||(x.length==0)) {
			return null;
		}//ֹͣ������
		int root=0;//���ڵ�
		BinaryTreeNode result=new BinaryTreeNode();
		int[] left1=null;//��������ǰ��
		int[] left2=null;//������������
		int[] right1=null;//��ǰ
		int[] right2 = null;//����
		if(x.length==1) {
			root=x[0];
			result.value=root;
			result.left=null;
			result.right=null;
			return result;
		}
		//�������ֶ�����
		root=x[0];//���ڵ�
		
		int zuobiao=0;//��ʵ����ط����ַ������ò���
		for(int i=0;i<y.length;i++) {
			if(y[i]==root) {
				zuobiao=i;
				break;
			}
		}
		if(zuobiao==0) {
			right2=new int[y.length-1];
			right1=new int[x.length-1];
			for(int i=0;i<y.length-1;i++) {
				right2[i]=y[i+1];
			}
			for(int i=0;i<x.length-1;i++) {
				right1[i]=x[i+1];
			}
		}
		if(zuobiao==y.length-1) {
			left2=new int[y.length-1];
			left1=new int[x.length-1];
			for(int i=0;i<y.length-1;i++) {
				left2[i]=y[i];
			}
			for(int i=0;i<x.length-1;i++) {
				left1[i]=x[i+1];
			}
		}else {
			right2=new int[y.length-zuobiao-1];
			right1=new int[y.length-zuobiao-1];
			left2=new int[zuobiao];
			left1=new int[zuobiao];
			for(int i=0;i<left2.length;i++) {
				left2[i]=y[i];
			}
			for(int i=0;i<left1.length;i++) {
				left1[i]=x[i+1];
			}
			for(int i=0;i<right2.length;i++) {
				right2[i]=y[i+zuobiao+1];
			}
			for(int i=0;i<right1.length;i++) {
				right1[i]=x[i+1+zuobiao];
			}
		}
	
		result.value=root;
		result.left=binaryTree(left1,left2);//������
		result.right=binaryTree(right1,right2);//������
		return result;

		
	}
	
}


class BinaryTreeNode{
	int value;
	BinaryTreeNode left;
	BinaryTreeNode right;
}

