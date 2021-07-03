package p2server;

import java.rmi.*;

public interface IIntegrator extends Remote {
   public double adaptiveSimpson(double leftEnd, double rightEnd, double epsilon, int initParam) throws RemoteException;
}
