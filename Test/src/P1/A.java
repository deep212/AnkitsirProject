package P1;


class A extends Thread 
{ 
    A() {} 
    A(Runnable r) {super(r); } 
    public void run() 
    { 
        System.out.print("Inside Thread ");
    } 
} 
class MyRunnable implements Runnable 
{ 
    public void run() 
    { 
        System.out.print(" Inside Runnable"); 
    } 
   public static void main(String[] args) 
    { 
        new A().start(); 
        new A(new MyRunnable()).start(); 
    } 
}