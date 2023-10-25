public class Test {
    public static void main(String[] args) {
        int[] arr = {2, 4};
        try {
            System.out.println(arr[1]);
            System.out.println("normal");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("error");
        }
    }
}
