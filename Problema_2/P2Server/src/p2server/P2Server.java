package p2server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class P2Server {
    public static void main(String[] args) {
       try {
            IIntegratorImpl i=new IIntegratorImpl();
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("integrator", i);
            System.out.println("Server is running...");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
