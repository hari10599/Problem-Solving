
class RunnableExample implements Runnable {
    int counter = 0;
    public void run() {
        counter++;
        System.out.println("hello Runnable"+ counter);
    }
}

class ThreadExample extends Thread{
    int counter = 0;
    public void run() {
        counter++;
        System.out.println("hello Thread" + counter);   
    }
}

class RunnableVsThread {
    public static void main(String[] args) {
        RunnableExample re = new RunnableExample();
        for(int i = 0; i < 4; i++) {
            Thread t = new Thread(re);
            t.start();
             try {
                // thread to sleep for 1000 milliseconds
                Thread.sleep(1000);
             } catch (Exception e) {
                System.out.println(e);
             }

        }
        
    
        for(int i = 0; i < 4; i++) {
            ThreadExample te = new ThreadExample();
            System.out.println(te.getId());
            te.start();
             try {
                // thread to sleep for 1000 milliseconds
                Thread.sleep(1000);
             } catch (Exception e) {
                System.out.println(e);
             }

        }
    }
}