package jianzhioffer;

/*�ж�һ���������Ƿ���ĳ�ַ��������ַ���·����·�������ظ������þ���Ԫ�ص�λ��
 * ˼·�����ݷ�*/
public class MatrixWay12 {
	public static void main(String[] args) {
		char[][] ch = new char[][] { { 'a', 'b', 't', 'g' }, { 'c', 'f', 'c', 's' }, { 'j', 'd', 'e', 'h' } };
		String s = "bfce";
		String s1 = "abfb";
		System.out.println(hasPath(ch, 3, 4, s));
		System.out.println(hasPath(ch, 3, 4, s1));
	}

	public static boolean hasPath(char[][] ch, int row, int col, String s) {
		boolean b = false;
		if (ch == null || s == null || row < 1 || col < 1 | ch.length <= 0 || s.equals(null)) {
			b = false;
		}
		boolean[][] visited = new boolean[row][col];
		int pathlength = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (hasPathCore(ch, row, col, i, j, s, pathlength, visited)) {
					b = true;
				}
			}
		}
		return b;
	}

	public static boolean hasPathCore(char[][] ch, int row, int col, int i, int j, String s, int pathlength,
			boolean[][] visited) {
		// if(s.charAt(pathlength)=='\0') {//Ҫע��java�е��ַ�����c�����в�һ��û��'\0'
		if (pathlength ==s.length() ) {
			return true;
		}
		boolean hasPath = false;
		if (i >= 0 && i < row && j >= 0 && j < col && ch[i][j] == s.charAt(pathlength) && !visited[i][j]) {
			++pathlength;
			visited[i][j] = true;
			hasPath = hasPathCore(ch, row, col, i, j - 1, s, pathlength, visited)
					|| hasPathCore(ch, row, col, i, j + 1, s, pathlength, visited)
					|| hasPathCore(ch, row, col, i - 1, j, s, pathlength, visited)
					|| hasPathCore(ch, row, col, i + 1, j, s, pathlength, visited);
			if (!hasPath) {
				--pathlength;
				visited[i][j] = false;
			}
		}
		return hasPath;
	}
}
