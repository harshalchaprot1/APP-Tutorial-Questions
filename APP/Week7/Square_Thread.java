/* Create a thread using Runnable interface that prints the squares of numbers from 1 to 5. */
import java.util.Scanner;

class SquarePrinter implements Runnable {
    

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Square of " + i + " = " + (i * i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Square_Thread {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("");
        

        SquarePrinter sp = new SquarePrinter();
        Thread t = new Thread(sp);
        t.start();
    }
}
