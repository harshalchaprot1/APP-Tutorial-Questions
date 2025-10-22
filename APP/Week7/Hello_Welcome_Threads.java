/* Program where one thread prints "Hello" and another prints "Welcome" */
class Hello_Thread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class Welcome_Thread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Welcome");
            try {
                Thread.sleep(520);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Hello_Welcome_Threads {
    public static void main(String[] args) {
        Hello_Thread t1 = new Hello_Thread();
        Welcome_Thread t2 = new Welcome_Thread();

        t1.start();
        t2.start();
    }
}
