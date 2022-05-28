package com.company;

public class MyThreadVer implements Runnable{
Thread thread;

MyThreadVer(String name){
    thread = new Thread(this,name);
}
public static MyThreadVer createAndStart(String name){
    MyThreadVer myThreadVer = new MyThreadVer(name);
        myThreadVer.thread.start();
        return myThreadVer;
    }

    public void run(){
    System.out.println(thread.getName() + "starts to operate");
    try{
        for(int count = 0; count < 10 ; count++){
            Thread.sleep(100);
            System.out.println(thread.getName() +"is excuted,the counter value"+ count );
        }
    }catch (InterruptedException e){
        System.out.println(thread.getName()+"has been interrupted");
    }
    System.out.println(thread.getName()+"finishes running.");
}
}
class MoreThreads{
    public static  void main (String[]args) {
        System.out.println("the main thread starts running.");
        MyThreadVer myThread1 = MyThreadVer.createAndStart("Child thread #1");
        MyThreadVer myThread2 = MyThreadVer.createAndStart("Child thread #2");
        MyThreadVer myThread3 = MyThreadVer.createAndStart("Child thread #3");

        System.out.print(".");
        try {
            myThread1.thread.join();
            myThread2.thread.join();
            myThread3.thread.join();
        } catch (InterruptedException e) {

            System.out.println("the main Thread is exiting");
        }
    }
}
