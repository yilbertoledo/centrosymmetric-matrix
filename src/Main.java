/**
 * Utility to generate and test CentroSymmetric Matrix
 * 
 * @author Yilber Toledo
 *
 */
public class Main {

	public static void main(String[] args) {

		// Generate matrix
		int m[][] = generateCentroSymmetricMatrix(8, 8);
		// Print genearted matix
		print2DArray(m, "A");

		// Check if the matrix is Centrosymmetric
		if (checkCentrosymmetricted(m))
			System.out.println("Yes, it is Centrosymmetric");
		else
			System.out.println("No, it's not Centrosymmetric");
	}

	/**
	 * Generates a Centrosymmetric matrix m*n
	 * 
	 * @param m Row count
	 * @param n Column count
	 * @return Integer two dimension array
	 */
	private static int[][] generateCentroSymmetricMatrix(int m, int n) {
		int[][] result = new int[m][n];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				int iVal = m - i + 1;
				int jVal = n - j + 1;
				if (Integer.parseInt(String.valueOf(iVal) + String.valueOf(jVal)) >= Integer
						.parseInt(String.valueOf(i) + String.valueOf(j))) {
					result[i - 1][j - 1] = Integer.parseInt(String.valueOf(i) + String.valueOf(j));
				} else {
					result[i - 1][j - 1] = result[iVal - 1][jVal - 1];
				}
			}
		}

		return result;
	}

	/**
	 * Prints a Integer Two dimension array
	 * 
	 * @param intArray
	 * @param prefijo
	 */
	private static void print2DArray(int[][] intArray, String prefijo) {
		for (int[] a : intArray) {
			for (int i : a) {
				System.out.print(prefijo + i + "\t");
			}
			System.out.println("\n");
		}
	}

	/**
	 * Determines if a matrix is Centrosymmetric
	 * 
	 * @param array2D
	 * @return
	 */
	static boolean checkCentrosymmetricted(int array2D[][]) {
		int mid_row;

		int rowsCount = array2D.length;
		int colsCount = array2D[0].length;

		// Finding the middle row of the matrix
		if ((rowsCount & 1) > 0)
			mid_row = rowsCount / 2 + 1;
		else
			mid_row = rowsCount / 2;
		// for each row upto middle row.
		for (int i = 0; i < mid_row; i++) {
			// If each element and its corresponding element is not equal then return false.
			for (int j = 0; j < colsCount; j++) {
				if (array2D[i][j] != array2D[rowsCount - i - 1][colsCount - j - 1]) {
					return false;
				}
			}
		}
		return true;
	}
}
