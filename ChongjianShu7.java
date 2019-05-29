package jianzhioffer;

import java.util.Arrays;

//输入前序遍历和中序遍历，还原二叉树并输出头节点.思路：用递归的方法。
public class ChongjianShu7 {
	public static void main(String[] args) {
		int[] qianxu=new int[] {1,2,4,7,3,5,6,8};
		int[] zhongxu=new int[] {4,7,2,1,5,3,8,6};
		BinaryTreeNode result;
		result=binaryTree(qianxu,zhongxu);
		print(result);
	}
	
	public static void print(BinaryTreeNode tre) {//打印树，以节点为标志，深度优先
		if(!tre.equals(null)) {
			if(tre.left!=null) {
				print(tre.left);
			}if(tre.right!=null) {
				print(tre.right);
			}
			System.out.println(tre.value);//改变这句话的位置，就会改变遍历方式
		}
	}
	
	public static BinaryTreeNode binaryTree(int[] x, int[] y) {
		if((x==null)||(x.length==0)) {
			return null;
		}//停止的条件
		int root=0;//根节点
		BinaryTreeNode result=new BinaryTreeNode();
		int[] left1=null;//左子树的前序
		int[] left2=null;//左子树的中序
		int[] right1=null;//右前
		int[] right2 = null;//右中
		if(x.length==1) {
			root=x[0];
			result.value=root;
			result.left=null;
			result.right=null;
			return result;
		}
		//正常划分二叉树
		root=x[0];//根节点
		
		int zuobiao=0;//其实这个地方用字符串不好操作
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
		result.left=binaryTree(left1,left2);//左子树
		result.right=binaryTree(right1,right2);//右子树
		return result;

		
	}
	
}


class BinaryTreeNode{
	int value;
	BinaryTreeNode left;
	BinaryTreeNode right;
}

