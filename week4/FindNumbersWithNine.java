package week4;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class FindNumbersWithNine {

    private static final int THRESHOLD = 100;

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new FindNineTask(1, 1000));
        pool.shutdown();
    }

    static class FindNineTask extends RecursiveAction {

        private final int start;
        private final int end;

        public FindNineTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start +1 < THRESHOLD) {
                for (int i = start; i <= end; i++) {
                    if (containsNine(i)) {
                        // System.out.println(Thread.currentThread().getName() + " "+i);
                        System.out.println(i);

                        
                    }
                }
            } else {
                int mid = (start + end) / 2;
                invokeAll(new FindNineTask(start, mid), new FindNineTask(mid + 1, end));
            }
        }

        private boolean containsNine(int n) {
            while (n > 0) {
                if (n % 10 == 9) {
                    return true;
                }
                n /= 10;
            }
            return false;
        }
    }
}
