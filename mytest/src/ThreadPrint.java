/**
 * @author nihao
 * @create 2022-11-07 16:22
 */
public class ThreadPrint extends Thread {
    int k = 1;

    public void run() {
        int i = k;
        while (i < 50) {
            System.out.println(Thread.currentThread().getName() + "-----" + i);
            i += 2;
        }
        System.out.println(Thread.currentThread().getName() + " end!");
    }

    public static void main(String[] args) {
        ThreadPrint t1 = new ThreadPrint();
        ThreadPrint t2 = new ThreadPrint();
        t1.k = 1;
        t2.k = 2;
        t1.start();
        t2.start();
    }
}

