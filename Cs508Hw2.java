import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class Cs508Hw2 {

    private AtomicReference<BigInteger> sum = new AtomicReference<BigInteger>();

    private  static int[] arr = new int[250000000];

    static Random random = new Random();

    public static void main(String args[]) throws Exception {

        Runnable computePartialSum = (int start, int end) -> {
            int sum = 0;
            for (int i = 1; i <= 10; i++) {
                System.out.println(i + " Thread ID: " + Thread.currentThread().getId());
                sum = sum + i;
            }
            System.out.println("Sum: " + sum + " Thread ID: " + Thread.currentThread().getId());
        };

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }

        for (int i=1; i <= 100; i++) {
            if (250000000 % i == 0) {
                
            }
        }

        
        one.join();
        two.join();
        three.join();

        System.out.println("Finally");

    }

    void createRunnable(int begin, int end) {
        Thread t = new Thread(() -> sumFromArray(begin,end));
        t.start();
    }

    void sumFromArray(int begin, int end) {
        BigInteger threadSum = BigInteger.valueOf(0);

        for (int i=begin; i<=end; i++) {
            BigInteger bigI = BigInteger.valueOf(i);
            threadSum.add(bigI);
        }

        sum.set(sum.get().add(threadSum));
    }
}