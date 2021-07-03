package p2client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import p2server.IIntegrator;

public class P2Client {
    public static void main(String[] args) {
       try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            IIntegrator i=(IIntegrator) registry.lookup("integrator");
            Scanner sc=new Scanner(System.in);
            System.out.println("leftEnd:");
            double leftEnd=sc.nextDouble();
            System.out.println("rightEnd:");
            double rightEnd=sc.nextDouble();
            System.out.println("epsilon:");
            double epsilon=sc.nextDouble();
            System.out.println("in parameter:");
            int initialParam=sc.nextInt();
            Registry registry2 = LocateRegistry.getRegistry("localhost");
            IIntegrator i2=(IIntegrator) registry2.lookup("integrator");
            Scanner sc2=new Scanner(System.in);
            System.out.println("leftEnd:");
            double leftEnd2=sc2.nextDouble();
            System.out.println("rightEnd:");
            double rightEnd2=sc2.nextDouble();
            System.out.println("epsilon:");
            double epsilon2=sc2.nextDouble();
            System.out.println("in parameter:");
            int initialParam2=sc2.nextInt();
            double server1=i.adaptiveSimpson(leftEnd, rightEnd, epsilon, initialParam);
            double server2=i2.adaptiveSimpson(leftEnd2, rightEnd2, epsilon2, initialParam2);
            System.out.println(server1);
            System.out.println(server2);
            System.out.println(server1+server2);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.exit(0);
    }
    
}
