public class BasicThreading {

    public static void main(String[] args) {
        Mythread thread1 = new Mythread("Thread 1",3000);
        Mythread thread2 = new Mythread("Thread 2",7000);

        thread1.start();
        thread2.start();

        for(int i=0; i<=10; i++){
            System.out.println("Main thread #"+i);
            try{
                Thread.sleep(4000);
            }catch (InterruptedException e){
                System.out.println("Main thread interrupted");
            }
        }
    }
}

class Mythread extends Thread {
    private String message;
    private int sleepTime;

    Mythread(String message, int sleepTime) {
        this.message = message;
        this.sleepTime = sleepTime;
    }

    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(message+"-"+i);
            try{
                Thread.sleep(sleepTime);
            }catch (InterruptedException e){
                System.out.println("thread interrupted");
            }
        }
    }
}

