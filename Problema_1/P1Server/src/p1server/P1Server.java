package p1server;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class P1Server {
    
    public static void main(String[] args) throws RemoteException {
        IntervalImpl interval = new IntervalImpl();
        try
        {
              Registry registry = LocateRegistry.getRegistry();
              registry.rebind("s1", interval);
              registry.rebind("s2", interval);
              System.out.println("Server is running…");
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
    
}
