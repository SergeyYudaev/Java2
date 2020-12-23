public class Java2HomeWork2 {

    public static void main(String[] args) {
        String[][] arr = {{"1", "3", "2", "4"}, {"2", "4", "1", "9"}, {"6", "8", "7", "1"}, {"1", "9", "2", "5"}};
        printArr(arr);
        int sum = sumArr(arr);
        System.out.println("Сумма элементов строкового массива: " + sum);
    }

    public static int sumArr(String[][] arr) throws MyArraySizeExeption, MyArrayDataExeption {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr.length != 4 || arr[i].length != 4) throw new MyArraySizeExeption("Размер массива должен быть 4*4");
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    counter += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataExeption("Неверный формат данных массива в ячейке: " + "[" + i + "][" + j + "]", i, j);
                }
            }
        }
        return counter;
    }

    public static void printArr(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
