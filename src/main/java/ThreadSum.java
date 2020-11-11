public class ThreadSum extends Thread {
    private final CustomArray arr;
    private final int leftIndex;
    private final int rightIndex;

    public ThreadSum(CustomArray arr, int leftIndex, int rightIndex) {
        this.arr = arr;
        this.leftIndex = leftIndex;
        this.rightIndex = rightIndex;
    }

    @Override
    public void run() {
        int tmpSum = arr.sumPartOfArray(leftIndex, rightIndex);
        System.out.println("Sum of current chunk with left index " + leftIndex + " and right index " + rightIndex + ": " + tmpSum);
        arr.addSum(tmpSum);
    }

}
