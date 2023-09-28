public class Test {
    int[] array = {2, 12, 8, 9, 34, 5};

    public static void main(String[] args) {
        Test test = new Test();
        test.add(2, 99);

    }

    public  void  add(int index, int value) {
        if (index <= array.length) {
            for (int i = index; i < array.length - 1; i++) {
                array[i] = array[i + 1];
            }
            array[index] = value;

            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }

        } else {
            System.out.println("Index isn't ina array");
        }
    }


    void delete(int index) {
      if (index <= array.length){
          for (int i = index; i < array.length - 1; i++) {
              array[i] = array[i + 1];
          }
          for (int i = 0; i < array.length - 1; i++) {
              System.out.print(array[i] + " ");
          }
      }
      else System.out.println("Index not in array");
    }

    public  int getBuyIndex(int value){
        int i;
        int count = 0;
        for (i = 0; i < array.length ; i++) {
            if (array[i] == value){
                count++;
            }
        }
        return -1;
    }



    public  void  set(int index, int value){
        array[index] = value;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }






    public boolean exist(int value){
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) return true;
        }
        return false;
    }

}
