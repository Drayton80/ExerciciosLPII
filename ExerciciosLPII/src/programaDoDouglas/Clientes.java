/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programaDoDouglas;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author Auricelio
 */
public class Clientes implements Runnable {
    
    public void run(){
        
         System.out.println("Cliente inicializado");
         
        try{
        Socket cliente = new Socket("localhost", 4444);//127.0.0.1 ou localhost representa o IP padrão da máquina

        //Vamos abrir os canos em que são feitas as comunicações entre servidor e cliente
        
        //Entrada dos bits vindos no socket cliente
        DataInputStream entrada = new DataInputStream(cliente.getInputStream());
        //Saida de bit enviados pelo socket cliente
        DataOutputStream saida = new DataOutputStream(cliente.getOutputStream());
        //Vamos usar as mensagens de entrada e saida do servidor:
        
        //Será mandado a mensagem para o servidor da String convertida em um array de bits:
        saida.writeUTF("Iaew server o/");
        //Lê a mensagem recebida do servidor em um array de bits convertido para um string:
        System.out.println(entrada.readUTF());
        //Fechamento do entrada e da saida dos canos:
        saida.close(); 
        entrada.close();
        //Fechamento do socket:
        cliente.close();
         }catch(IOException e){
             System.out.println("Falha na comunicação");
         }
    }
    
}
