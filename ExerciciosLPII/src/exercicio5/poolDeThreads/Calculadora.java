package exercicio5.poolDeThreads;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;
import java.util.concurrent.*;

public class Calculadora implements Runnable {
    Socket s;
    
    public Calculadora(Socket s){
        this.s = s;
    }
    
    public void run(){
        try{
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            PrintWriter out_message = new PrintWriter(out, true);
            Scanner in_message = new Scanner(in);
            
            String numeros_com_espaco;
            String[] numeros_sem_espaco;
            int[] numeros;
            int escolha, subescolha;
            boolean sair = false;
            
            while(!sair){
                int soma = 0;
                int multiplicacao = 1;
                
                escolha = Integer.parseInt(in_message.nextLine());
                
                if(escolha != 5){
                    numeros_com_espaco = in_message.nextLine();
                    numeros_sem_espaco = numeros_com_espaco.split(" ");
                    
                    numeros = new int[numeros_sem_espaco.length];
                
                    for(int i = 0; i < numeros.length; i++){
                        numeros[i] = Integer.parseInt(numeros_sem_espaco[i]); 
                    }
                    
                    switch(escolha){
                        case 1:
                            for(int i = 0; i < numeros.length; i++){
                                soma = soma + numeros[i];
                            }

                            out_message.println(soma);
                            break;

                        case 2:
                            for(int i = 0; i < numeros.length; i++){
                                multiplicacao = multiplicacao * numeros[i];
                            }

                            out_message.println(multiplicacao);
                            break;

                        //case 3:
                        //    subescolha = Integer.parseInt(in_message.nextLine());
                        //    
                        //    switch(subescolha){
                        //        case 1:
                        //            soma = 0;
                        //            
                        //            numeros_com_espaco = in_message.nextLine();
                        //            numeros_sem_espaco = numeros_com_espaco.split(" ");
                        //            
                        //            numeros = new int[numeros_sem_espaco.length];
                        //            
                        //            for(int i = 0; i < numeros.length; i++){
                        //                numeros[i] = Integer.parseInt(numeros_sem_espaco[i]); 
                        //            }
                        //            
                        //            for(int i = 0; i < numeros.length; i++){
                        //                soma = soma + numeros[i];
                        //            }
                        //            
                        //            System.out.println(soma);
                        //            
                        //            out_message.println(soma);
                        //            break;
                        //            
                        //        case 2:
                        //            
                        //        case 3:
                        //            break;
                        //    }
                        //    
                        //    break;
                        //    
                        case 4:
                            break;

                    }

                }else{
                    sair = true;
                    in.close();
                    out.close();
                    s.close();
                    break;   
                }
                
            }

        }catch(IOException n){
            System.out.println("Houve algum problema de conexão!!!");
        }
        
    }
}
