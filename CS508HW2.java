import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

public class CS508HW2 {

    private  static int[] arr = new int[250000000];

    static Random random = new Random();

    static class SumPartial implements Callable<BigInteger> {
    
        BigInteger threadSum;
        int[] arr;
        int begin;
        int end;

        SumPartial (int[] arr, int begin, int end){
            this.arr=arr;
            this.begin=begin;
            this.end=end;
        }

        public BigInteger call(){

        BigInteger threadSum = BigInteger.valueOf(0);

        for (int i=begin; i<=end; i++) {
            BigInteger bigI = BigInteger.valueOf(arr[i]);
            threadSum.add(bigI);
        }

        //sum.set(sum.get().add(threadSum));

        return threadSum;
        }

        public BigInteger getThreadSum(){
            return threadSum;
        }
    
    }

    

    public static void main(String args[]) throws Exception {

        AtomicReference<BigInteger> sum = new AtomicReference<BigInteger> ();
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }

        for (int i=1; i <= 100; i++) {
            if (250000000 % i == 0) {
                long start = System.currentTimeMillis();
                sum.set(BigInteger.valueOf(0));
                ExecutorService workers = Executors.newFixedThreadPool(i);
                List<Future<BigInteger>> futures = new ArrayList<>();
                for (int y=0; y<i; y++) {
                int begin=arr.length/y;
                int end=begin+arr.length/i;
                futures.add(workers.submit(new SumPartial(arr,begin,end)));
                }
                for (int z=0; z<futures.size(); z++) {
                    sum.set(sum.get().add(futures.get(z).get()));
                }
                long end = System.currentTimeMillis();
                System.out.println("The sum is " + sum + " and the run time is " + (end-start));
            }

        }

        
    }

/*
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
*/
}