/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linguagemDeProgramacaoII.exercicio5.RMI.servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author drayton80
 */
public class CalculadoraImpl extends UnicastRemoteObject implements Calculadora {
    public CalculadoraImpl() throws RemoteException{
        super();
    }
    
    public double soma(double[] numeros) throws RemoteException{
        double soma = 0;
        
        for(int i = 0; i < numeros.length; i++){
            soma = soma + numeros[i];
        }
        
        return soma;        
    }
    
    public double multiplicacao(double[] numeros) throws RemoteException{
        double multiplicacao = 1;
        
        for(int i = 0; i < numeros.length; i++){
            multiplicacao = multiplicacao * numeros[i];
        }
        
        return multiplicacao;
    }
    
    public double subtracao(double[] numeros) throws RemoteException{
        double subtracao = 0;
        
        for(int i = 0; i < numeros.length; i++){
            subtracao = subtracao - numeros[i];
        }
        
        return subtracao;        
    }
    
    public double divisao(double[] numeros) throws RemoteException{
        double divisao = 1;
        
        for(int i = 0; i < numeros.length; i++){
            divisao = divisao / numeros[i];
        }
        
        return divisao;
    }
    
}
