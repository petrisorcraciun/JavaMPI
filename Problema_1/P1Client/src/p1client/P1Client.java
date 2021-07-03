package p1client;

import java.io.DataInputStream;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import p1server.Interval;


public class P1Client {
  public static void main(String[] args) {
    try {
    // System.setSecurityManager(new RMISecurityManager());
            int[] nr = {0, 0, 0, 0};

            int portSv1 = 1099;
            int portSv2 = 1099;
            DataInputStream in = new DataInputStream(System.in);;
            Registry registry = LocateRegistry.getRegistry("172.19.48.1", portSv1);
            Interval intervalSv1 = (Interval) registry.lookup("s1");
            int result = 0;
            System.out.println("----------------------------- ");
            System.out.println("Sv1: ");
            System.out.print("nr 1 : ");
            nr[0] = Integer.parseInt(in.readLine());
            System.out.print("nr 2 : ");
            nr[1] = Integer.parseInt(in.readLine());
            System.out.println("----------------------------- ");
            Registry registry2 = LocateRegistry.getRegistry("localhost", portSv2);
            Interval intervalSv2 = (Interval) registry2.lookup("s2");
            System.out.println("Sv2 ");
            System.out.print("nr 1 : ");
            nr[2] = Integer.parseInt(in.readLine());
            System.out.print("nr 2 : ");
            nr[3] = Integer.parseInt(in.readLine());
            try {
                result += intervalSv1.findNrPrimes(nr[0], nr[1]);
                result += intervalSv2.findNrPrimes(nr[2], nr[3]);
            } catch (RemoteException e1) {
                e1.printStackTrace();
            }
            System.out.println("Result: " + result);
    } catch (Exception e) {
      System.out.println(e);
    }
    System.exit(0);
  }
}