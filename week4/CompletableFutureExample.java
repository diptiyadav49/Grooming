package week4;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {

    public static void main(String[] args) {

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            int sum = 0;
            for (int i = 1; i <= 10; i++) {
                sum += i;
            }
            return sum;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            int sum = 0;
            for (int i = 11; i <= 20; i++) {
                sum += i;
            }
            return sum;
        });

        CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> {
            int sum = 0;
            for (int i = 21; i <= 30; i++) {
                sum += i;
            }
            return sum;
        });

        CompletableFuture<Integer> finalFuture = CompletableFuture.allOf(future1, future2, future3)
                .thenApply(v -> {
                    int sum = future1.join() + future2.join() + future3.join();
                    return sum;
                });

        System.out.println("Sum of 1 to 30 integers: " + finalFuture.join());
    }
}