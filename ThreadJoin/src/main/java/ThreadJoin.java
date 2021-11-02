public class ThreadJoin {

    static Runnable runnable = () -> {
        String currentThread = Thread.currentThread().getName();
        switch (currentThread) {
            case "Rio" -> {
                try {
                    Thread.sleep(3000);
                    System.out.println(currentThread);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            case "Tio" -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(currentThread);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            case "Mio" -> System.out.println(currentThread);
            default -> System.out.println("No matching Thread found)");
        }

    };

    public static void main(String[] args) {
        Thread rio = new Thread(runnable);
        rio.setName("Rio");

        Thread tio = new Thread(runnable);
        tio.setName("Tio");

        Thread mio = new Thread(runnable);
        mio.setName("Mio");

        // Without join method threads get terminated as soon as finishes their job
        rio.start();
        tio.start();
        mio.start();

        // Each thread will make sure previous thread is completes its job and terminated before it starts.

       /* rio.start();
        rio.join();
        tio.start();
        tio.join();
        mio.start();
        mio.join();*/


    }
}