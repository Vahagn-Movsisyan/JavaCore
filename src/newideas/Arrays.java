package newideas;

public class Arrays {
    public static void main(String[] args) {
        int[][] matrix = {
                {5, 8, 3},
                {7, 2, 4},
                {6, 1, 9}
        };


        int totalElements = matrix.length * matrix[0].length;
        int[] changeArray = new int[totalElements];
        int index = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                changeArray[index++] = matrix[i][j];
            }
        }


        for (int i = 0; i < changeArray.length - 1; i++) {
            for (int j = 0; j < changeArray.length - i - 1; j++) {
                if (changeArray[j] > changeArray[j + 1]) {
                    int changeIndex = changeArray[j];
                    changeArray[j] = changeArray[j + 1];
                    changeArray[j + 1] = changeIndex;
                }
            }
        }


        index = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = changeArray[index++];
            }
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

