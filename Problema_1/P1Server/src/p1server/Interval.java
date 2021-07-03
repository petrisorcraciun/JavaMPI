package p1server;

import java.rmi.*;
public interface Interval extends Remote
{
    public int findNrPrimes(int a ,int b) throws RemoteException;
}