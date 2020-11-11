public class CustomArray {
    public int[] array;
    public int currentSize;
    public int sum = 0;

    public void createArray(int size) {
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        currentSize = array.length;
    }

    public void printArray() {
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println("");
    }

    public int sumPartOfArray(int leftIndex, int rightIndex) {
        int sum = 0;
        for (int i = leftIndex; i <= rightIndex; i++)
            sum += array[i];
        return sum;
    }

    private int chunks;

    public int parPartSum(int chunks) {
        this.chunks = chunks;

        int leftIndex = 0;
        int delta = array.length / chunks;
        for (int i = 0; i < chunks - 1; i++) {
            new ThreadSum(this, leftIndex, leftIndex + delta).start();
            leftIndex += (delta + 1);
        }

        new ThreadSum(this, leftIndex, array.length - 1).start();

        synchronized (this) {
            while (this.chunks > 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return sum;
    }

    public synchronized void addSum(int sum) {
        this.sum += sum;
        chunks--;
        notify();
    }

}
