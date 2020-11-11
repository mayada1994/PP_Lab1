import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int size = in.nextInt();
        System.out.println("Enter number of array chunks:");
        int chunks = in.nextInt();
        CustomArray arr = new CustomArray();
        arr.createArray(size);
        arr.printArray();
        System.out.println("Total sum of elements: " + arr.parPartSum(chunks));
    }

}
