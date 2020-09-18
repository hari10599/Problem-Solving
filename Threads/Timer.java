import java.util.*;
import java.net.*;
import java.text.*;
import java.io.*;

class Timer implements Runnable{
    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String closingTime; //"2020-09-03 18:34:00"
    ServerSocket ss;
    Socket s;

    Accepter(String ct, int port) { 
        try {
            ss = new ServerSocket(port);
        }
        catch(Exception e){
            System.out.println(e);
        }
        this.closingTime = ct;
    }

    public void run() {
        while(true) {
            try {
                s = ss.accept();
            }
            catch(Exception e) {
                System.out.println(e);
            }
            Date date = new Date();
            String curr = formater.format(date);
            if(curr.compareTo(closingTime) > 0) {
                break;
            }
            System.out.println(curr);
            System.out.println("New Client");
        }
    }

    public static void main(String[] args) {
        Accepter ac = new Accepter("2020-09-03 19:4:00", 12345);
        Thread s = new Thread(ac);
        s.start();
    }


}