public class RaceCondition {
    static Addition addition = new Addition();

    static Runnable runnable = () -> {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 1_000; i++) {
            addition.add();
        }
    };

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            Thread thread1 = new Thread(runnable);
            threads[i] = thread1;
            thread1.start();
        }

        for (int i = 0; i < threads.length; i++) {
            Thread thread = threads[i];
            thread.join();
        }
        System.out.println(addition.getI());

        /* How to run
            1. Remove synchronized keyword from add method of Addition class to reproduce race condition
            2. Add synchronized keyword to solve the inconsistent count result.
         */
    }
}
