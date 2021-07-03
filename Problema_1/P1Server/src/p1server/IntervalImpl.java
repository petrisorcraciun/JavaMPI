package p1server;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class IntervalImpl extends UnicastRemoteObject implements Interval    
{
    public IntervalImpl() throws RemoteException{}
    
    public int findNrPrimes(int a,int b) throws RemoteException
    {
        int result = 0;
        Boolean prim;
        if(a == 1) a++;
        for(int i = a; i <= b; i ++){
            prim = true;
            for(int d = 2; d * d <= i; d ++){
                if(i%d == 0) 
                    prim = false;
            }
            if(prim){
                result++;
            }
        }
        return result;
    }
}
