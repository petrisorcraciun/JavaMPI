package p2server;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class IIntegratorImpl extends UnicastRemoteObject implements IIntegrator {

    public IIntegratorImpl() throws RemoteException {
    }

    @Override
    public double adaptiveSimpson(double valA, double valB, double valEpsilon, int initParam) throws RemoteException {
        double firstSum = 0;
        double secondSum = 0;
        double Im = 0;
        double prevIm = 0;
        if ((valB - valA) == 0) return 0;
        int counter = 0;
        while( Math.abs(Im - prevIm) < valEpsilon){  
            double mK = Math.pow(2, counter) * initParam; 
            for (int i = 1; i < mK - 1; i++) {
                firstSum = firstSum + Math.sin(valA + 2 * i * ((valB - valA)/ (2 * mK)));
            }
            for (int i = 0; i < mK - 1; i++) {
                secondSum = secondSum + Math.sin(valA + 2 * (i + 1) * ((valB - valA) / (2 * mK)));
            }
            prevIm = Im;
            Im = ((valB - valA) / (6 * mK)) * (Math.sin(valA) + (2 * firstSum) + (4 * secondSum) + Math.sin(valB));
            counter++;
        }
        return Im;
    }
}
