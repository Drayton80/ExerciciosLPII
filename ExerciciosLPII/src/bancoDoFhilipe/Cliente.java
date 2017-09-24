/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoDoFhilipe;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Kel_Nunes
 */
public class Cliente {
    public static void main(String[] args) {
        try {
            //Criando socket cliente:
            Socket cliente = new Socket("localhost", 12345);
            //Criando conexões in e out(canos):
            DataInputStream in = new DataInputStream(cliente.getInputStream());
            DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
            
            //Instanciando classe scanner(teclado) e variaveis de menssagem:
            Scanner entrada = new Scanner(System.in);
            String fromClient, fromServer;
            boolean expectResponse;
            
            while(true){
                fromServer = in.readUTF();
                expectResponse = in.readBoolean();
                System.out.println(fromServer);
                
                if (fromServer.equals(Protocolo.Saida())) {
                    break;
                }
                
                if (expectResponse) {
                    fromClient = entrada.nextLine();
                    out.writeUTF(fromClient);
                }
            }
            //Fechamentos
            cliente.close();
            in.close();
            out.close();
        
        }catch(Exception erro){
                    System.out.println("ERRO: "+ erro.toString());
        }
    }
}
