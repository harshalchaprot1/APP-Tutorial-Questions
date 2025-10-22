/* Program to print multiplication tables of 5 and 10 using threads */
class Table_5 extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("5 x " + i + " = " + (5 * i));
            try {
                Thread.sleep(480);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class Table_10 extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("10 x " + i + " = " + (10 * i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Multiplication_Threads {
    public static void main(String[] args) {
        Table_5 t5 = new Table_5();
        Table_10 t10 = new Table_10();

        t5.start(); 
        t10.start();
    }
}
