package jianzhioffer;
/*����һ�ö�����������һ���ڵ㣬����ҳ������������һ���ڵ㣬���л�������ָ�����ҵĽڵ��һ��ָ�򸸽ڵ�
 * ˼·��������������������ӽڵ������һֱ�������ӽڵ������ң������ҵ��¸��ڵ㡣���ޡ���������������Ǹ��ڵ����ڵ㣬���ڵ�����¸��ڵ㡣
 * ��������ǣ���ô�����Ÿ��ڵ����ϱ������ҵ�һ���Ǹ��ڵ����ڵ�Ľڵ�����¸��ڵ㡣
 * 
 * ע��ĵط�����equals���ֿ�ָ����󣬵��Ǹ�Ϊ==��û���ˡ���Ϊ�Ƚϵ��Ƕ���ĵ�ַ����һ����ֵ���ڣ�
 * */
public class NextNode8 {
	public static void main(String[] args) {
		//����
		//����һ����
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
			while(next1!=null) {//��������equals
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
			while(temp!=null) {//�����ڵ�Ϊֹ
				
				if(temp.fuqin==null) {
					temp=temp.fuqin;
					}
				if(temp.fuqin.zuo==null) {
					break;
				}
				if(temp.fuqin.zuo==temp) {//���Ǹ��׵�����
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
