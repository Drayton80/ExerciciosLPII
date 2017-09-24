/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoDoFhilipe;

import java.net.*;
import java.util.LinkedList;
import java.util.concurrent.*;

/**
 *
 * @author Kel_Nunes
 */
public class Servidor {
    
    //Criando Lista Encadeada de contas:
    protected static LinkedList<Conta> contas = new LinkedList<>();
    
    public static void main(String[] args){
        try{
            //Iniciando Servidor:
            System.out.println("Iniciando o servidor...");
            ServerSocket servidor = new ServerSocket(12345);
            //Criando uma pool de threads variável:
            ExecutorService exe = Executors.newCachedThreadPool();
            
            while(true){
                //Observando quem entra em contato com o servidor:
                Socket cliente = servidor.accept();
                System.out.println("Servidor Iniciado.");
                //Runando o cliente na pool do multservidor:
                exe.execute(new MultServidor(cliente));
                
            }
            
        }catch(Exception erro){
            System.err.println("ERRO:" + erro.toString());
        }
    }
}
