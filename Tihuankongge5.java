package jianzhioffer;
/*题目说明：把字符串中的每个空格换成"20%，因为如果每次替换移动字符串时间复杂度为n^2。
 * 优化：O（n）的做法：先遍历有几个空格，开辟相应空间，从后向前比较、交换。
 * java中不用这么麻烦，直接用StrigBuffer就ok
 * 注意特殊情况。*/
public class Tihuankongge5 {
	public static void main(String[] args) {
		String s="We are happy！";
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
