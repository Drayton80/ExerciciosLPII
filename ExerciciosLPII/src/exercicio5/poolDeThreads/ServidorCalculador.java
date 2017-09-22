/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linguagemDeProgramacaoII.exercicio5.poolDeThreads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;


public class ServidorCalculador {
    public static void main(String[] arguments){
        boolean sair = false;
        ExecutorService e = Executors.newCachedThreadPool();
        
        try{
            ServerSocket servidor = new ServerSocket(123);
        
            while(!sair){
                Socket s = servidor.accept();
                e.execute(new Calculadora(s));
            }
            
        }catch(IOException n){
            System.out.println("Houve algum problema de conexão!!!");
        }
        
        
        
        
    }
}