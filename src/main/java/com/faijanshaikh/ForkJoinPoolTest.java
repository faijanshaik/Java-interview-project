package main.java.com.faijanshaikh;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolTest {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ForkJoinPool pool = new ForkJoinPool();
        int sum = pool.invoke(new SumTask(0, array, array.length - 1));
        System.out.println(" Total sum " + sum);
    }
}

class SumTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 3;
    public int[] array;
    public int start;
    public int end;

    public SumTask(int start, int[] array, int end) {
        this.start = start;
        this.array = array;
        this.end = end;
    }

    @Override
    protected Integer compute() {

        if (end - start <= THRESHOLD) {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            int mid = (start + end) / 2;
            SumTask left = new SumTask(start, array, mid);
            SumTask right = new SumTask(mid + 1, array, end);
            left.fork();
            int rightResult = right.compute();
            int leftResult = left.join();

            return rightResult + leftResult;
        }
    }
}