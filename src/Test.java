public class Test {
    int[] array = {2, 12, 8, 9, 34, 5, 13, 8, 2};

    public static void main(String[] args) {
        Test test = new Test();
        test.delete(0);

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
        if (count > 1){
            return value;

        } else {
            return -1;
        }

    }



    public  void  set(int index, int value){
        array[index] = value;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public  void  add(int index, int value){
        if (index <= array.length){
            for (int i = index; i < array.length - 1 ; i++) {
                array[index] = value;
                array[i] = array[i + 1];
            }
        }
        else {
            System.out.println("Index isn't ina array");
        }

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
