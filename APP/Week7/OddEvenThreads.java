/* Program to print odd and even numbers using threads */
import java.util.Scanner;

class OddThread extends Thread {
    int n;
    OddThread(int n) {
        this.n = n;
    }
    public void run() {
        for (int i = 1; i <= n; i = i + 2) {
            System.out.println("Odd: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class EvenThread extends Thread {
    int n;
    EvenThread(int n) {
        this.n = n;
    }
    public void run() {
        for (int i = 2; i <= n; i = i + 2) {
            System.out.println("Even: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class OddEvenThreads {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter any number: ");
        int n = sc.nextInt();

        OddThread odd = new OddThread(n);
        EvenThread even = new EvenThread(n);

        odd.start();   
        even.start();  
    }
}
