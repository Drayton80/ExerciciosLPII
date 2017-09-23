package exercicio5.RMI.servidor;

import java.rmi.*;

public interface Calculadora extends Remote {
    public double soma(double[] numeros) throws RemoteException;
    public double multiplicacao(double[] numeros) throws RemoteException;
    public double subtracao(double[] numeros) throws RemoteException;
    public double divisao(double[] numeros) throws RemoteException;
}
