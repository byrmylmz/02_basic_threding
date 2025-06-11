public class SingleThreadVersion {

    public static void main(String[] args) {
        Mythread thread1 = new Mythread("Thread 1", 3000);
        Mythread thread2 = new Mythread("Thread 2", 7000);

        // thread'leri başlatmıyoruz, doğrudan run() metodunu çağırıyoruz
        thread1.run();  // çalıştır ama yeni bir thread oluşturma
        thread2.run();  // yine ana thread içinde çalışır

        // main thread çalışması
        for (int i = 0; i <= 10; i++) {
            System.out.println("Main thread #" + i);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted");
            }
        }
    }
}

// NOT: Artık Thread sınıfından miras almıyoruz
class Mythread {
    private String message;
    private int sleepTime;

    Mythread(String message, int sleepTime) {
        this.message = message;
        this.sleepTime = sleepTime;
    }

    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(message + " - " + i);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}
