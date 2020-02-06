public class Cs508Hw1 {
    public static void main(String args[]) throws Exception{
        Runnable oneToTen =() -> {
            int sum=0;
            for (int i = 1; i<=10; i++) {
                System.out.println(i + "Thread ID:" + Thread.currentThread().getId());
                sum=sum+i;
            }
            System.out.println("Sum: " + sum + "Thread ID: " + Thread.currentThread().getId());
        };

        Runnable mediumInt =() -> {
            int sum=0;
            for (int i = (int) Math.pow(11,2); i<=Math.pow(20,2); i++) {
                System.out.println(i + "Thread ID: " + Thread.currentThread().getId());
                sum=sum+i;
            }  
            System.out.println("Sum: " + sum + "Thread ID: " + Thread.currentThread().getId());
        };

        Runnable largeInt =() -> {
            int sum=0;
            for(int i = (int) Math.pow(21,3); i<=Math.pow(30,3); i++) {
                System.out.println(i + "Thread ID: " + Thread.currentThread().getId());
                sum=sum+i;
            }
            System.out.println("Sum: " + sum + "Thread ID: " + Thread.currentThread().getId());
        };

        Thread one = new Thread(oneToTen);
        Thread two = new Thread(mediumInt);
        Thread three = new Thread(largeInt);
        one.start();
        two.start();
        three.start();
        one.join();
        two.join();
        three.join();

        System.out.println("Finally");

    }
}