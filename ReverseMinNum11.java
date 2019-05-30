package jianzhioffer;

//��ת�������С����
/*˵����Ҫ���Ƕ��ַ�������������в����ٶ�ΪO��lgn��
 * ���Ҫ�������������*1.����Ϊ�ջ��߿�ָ��2.�ƶ�Ԫ����Ϊ03.ǰ���м�����֮��������*/
public class ReverseMinNum11 {
	public static void main(String[] args) throws Exception {
		int[] t = null;
		int[] test = new int[] { 3, 4, 5, 1, 2 };
		int[] test1 = new int[] { 1, 2, 3, 4, 5 };
		int[] test2 = new int[] { 1, 0, 1, 1, 1 };
		int[] test3 = new int[] { 1, 1, 1, 0, 1 };
		searchReverse(test);
		searchReverse(test1);
		searchReverse(test2);
		searchReverse(test3);
		searchReverse(t);
	}

	public static void searchReverse(int[] test) throws Exception {
		if (test.length <= 0 || test == null) {
			throw new Exception("unlegal");
		}
		int qian = 0;
		int hou = test.length - 1;
		int mid = qian;
		while (test[qian] >= test[hou]) {
			if (hou - qian == 1) {
				mid = hou;
				break;
			}
			if (test[qian] == test[mid] && test[mid] == test[hou]) {
                mid= minFromSortSearch(test);
                break;
                // �㷨�ĺ���˼��
            }
			mid = (hou + qian) / 2;
			if (test[mid] >= test[qian]) {
				qian = mid;
			}
			if (test[mid] <= test[hou]) {
				hou = mid;
			}
		}
		System.out.println(test[mid]);
	}
	 public static int minFromSortSearch(int[] array) {
         int minEle = 0;
         for (int i = 1; i < array.length; i++) {
             if (array[i] < array[minEle]) {
                 minEle = i;
             }
         }
         return minEle;
     }
}
