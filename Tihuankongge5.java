package jianzhioffer;
/*��Ŀ˵�������ַ����е�ÿ���ո񻻳�"20%����Ϊ���ÿ���滻�ƶ��ַ���ʱ�临�Ӷ�Ϊn^2��
 * �Ż���O��n�����������ȱ����м����ո񣬿�����Ӧ�ռ䣬�Ӻ���ǰ�Ƚϡ�������
 * java�в�����ô�鷳��ֱ����StrigBuffer��ok
 * ע�����������*/
public class Tihuankongge5 {
	public static void main(String[] args) {
		String s="We are happy��";
		test(s);
	}
	static void test(String s){
		if(s.equals(null)||s.length()==0) {
			return;
		}
		StringBuffer str = new StringBuffer();
		for(int begin=0;begin<s.length();begin++) {
			if(s.charAt(begin)!=' ') {
				str.append(s.charAt(begin));
			}else {
				str.append("20%");
			}
		}
		System.out.println(str);
	}
}
