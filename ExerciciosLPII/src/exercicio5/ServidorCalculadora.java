/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linguagemDeProgramacaoII.exercicio5;

import java.net.ServerSocket;
import java.io.*;
import java.net.*;

public class ServidorCalculadora {
    private static boolean sair = false;
    private static int[] numeros;
    
    public static void main(String[] arguments)
                  throws IOException, UnknownHostException {
        int escolher;
        int soma = 0;
        int multiplica = 1;
        
        ServerSocket servidor = new ServerSocket(123);
        Socket s = servidor.accept();
        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        
        while(sair){
            escolher = Integer.parseInt(in.readUTF());
            
            switch(escolher){
                case 1:
                    numeros = new int[Integer.parseInt(in.readUTF())];
                    
                    for(int i = 0; i < numeros.length; i++){
                        numeros[i] = Integer.parseInt(in.readUTF());
                        
                        soma += numeros[i];
                    }  
                    
                    out.writeUTF(String.valueOf(soma));
                case 4:
                    sair = true;                    
            }           
        }
        
        in.close();
        out.close();
        s.close();
        servidor.close();
    }
}
