package jianzhioffer;
/*给定一棵二叉树和其中一个节点，如何找出中序遍历的下一个节点，树中还有两个指向左右的节点和一个指向父节点
 * 思路：若有右子树，则从右子节点出发，一直沿着左子节点往下找，就能找到下个节点。若无。右子树，如果他是父节点的左节点，父节点就是下个节点。
 * 如果都不是，那么就沿着父节点向上遍历，找到一个是父节点的左节点的节点就是下个节点。
 * 
 * 注意的地方：用equals出现空指针错误，但是改为==就没错了。因为比较的是对象的地址，不一定有值存在，
 * */
public class NextNode8 {
	public static void main(String[] args) {
		//测试
		//给出一棵树
		Erchashu f=new Erchashu("f",null,null,null);
		Erchashu g=new Erchashu("g",null,null,null);
		Erchashu h=new Erchashu("h",null,null,null);
		Erchashu i=new Erchashu("i",null,null,null);
		Erchashu d=new Erchashu("d",null,null,null);
		Erchashu e=new Erchashu("e",null,h,i);
		Erchashu b=new Erchashu("b",null,d,e);
		Erchashu c=new Erchashu("c",null,f,g);
		Erchashu a=new Erchashu("a",null,b,c);
		b.fuqin=a;
		c.fuqin=a;
		d.fuqin=b;
		e.fuqin=b;
		f.fuqin=c;
		g.fuqin=c;
		h.fuqin=e;
		i.fuqin=e;
		Erchashu result=get(i);
		System.out.println(result.value);
	}
	public static Erchashu get(Erchashu x) {
		Erchashu next= new Erchashu(null);
		if(x.equals(null)) {
			return null;
		}
		if(x.you!=null) {
			Erchashu next1=x.you;
			while(next1!=null) {//不可以用equals
				if(next1.zuo!=null) {
					next1=next1.zuo;
				}else {
					next=next1;
					return next;
				}
			}
		}
		else if(x.fuqin!=null&&x.fuqin.zuo==x) {
			return(x.fuqin);
		}
			
			Erchashu temp=x.fuqin;
			while(temp!=null) {//到根节点为止
				
				if(temp.fuqin==null) {
					temp=temp.fuqin;
					}
				if(temp.fuqin.zuo==null) {
					break;
				}
				if(temp.fuqin.zuo==temp) {//他是父亲的左孩子
					next=temp;
					break;
				}
				temp=temp.fuqin;
				if(temp.fuqin==null) {
					next=x;
					break;
				}
			}
			return next;
	}
	
}
class Erchashu{
	String value;
	Erchashu fuqin;
	Erchashu zuo;
	Erchashu you;
	public Erchashu(String value,
			Erchashu fuqin,
			Erchashu zuo,
			Erchashu you) {
		this.value=value;
		this.zuo=zuo;
		this.you=you;
	}
	public Erchashu(String value) {
		this.value=value;
	}
	
}
