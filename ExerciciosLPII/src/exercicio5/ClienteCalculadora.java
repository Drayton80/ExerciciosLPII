/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linguagemDeProgramacaoII.exercicio5;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author drayton80
 */
public class ClienteCalculadora {
    private static Scanner entrada = new Scanner(System.in);
    private static String escolha_aux;
    private static int resultado;
    private static int contador = 0;
    private static int[] numeros;
    
    public static void main(String[] args) 
                  throws UnknownHostException, IOException{
        int escolha = 0;
        
        Socket s = new Socket("localhost", 123);
        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        PrintWriter mensagem = new PrintWriter(out, true);
        
        while(true){
            try{      
                
                System.out.println("Escolha uma das seguintes opções: \n" +
                                   " 1 - Para Somar                   \n" +
                                   " 2 - Para Multiplicar             \n" +
                                   " 3 - Para Exibir Resultado        \n" +
                                   " 4 - Para Sair                    ");
                
                escolha_aux = entrada.nextLine();
                escolha = Integer.parseInt(escolha_aux);
                
                if(escolha < 1 || 4 < escolha){
                    throw new OutOfLimitsException();
                }
                
                if(escolha == 4){
                    out.writeUTF(escolha_aux);
                    break;
                }
                
                if(escolha == 1){
                    String exibir_soma = "";
                    String tamanho;
                    out.writeUTF(escolha_aux);
                    
                    soma();
                    
                    tamanho = String.valueOf(numeros.length);
                    out.writeUTF(tamanho);
                    
                    for(int i = 0; i < numeros.length; i++){
                        out.writeUTF(String.valueOf(numeros[i]));
                        exibir_soma = exibir_soma + " + " + numeros[i];
                    }
                    
                    if(contador == 0){
                        resultado = Integer.parseInt(in.readUTF());
                    }else{
                        resultado = resultado + Integer.parseInt(in.readUTF());
                    }
                    
                    contador++;
                    
                    System.out.println( exibir_soma + " = " + resultado);
                }
                
            }catch(NumberFormatException n){
                System.out.println("Caractere inválido!!!");
            }catch(OutOfLimitsException d){
                System.out.println("Número inválido!!!");
            }
            
        }
        
        in.close();
        out.close();
        s.close();
    }
    
    private static void soma(){
        int escolha = 0;
        
        try{
            System.out.println("Quantos números deseja somar?");
            escolha = Integer.parseInt(entrada.nextLine());
            numeros = new int[escolha];
        
            
        }catch(NumberFormatException n){
            System.out.println("Caractere inválido!!!");
        }
        
        for(int i = 0; i < escolha; i++){
            try{
                System.out.println("Qual o " + (i+1) + "º número da soma?");
                numeros[i] = Integer.parseInt(entrada.nextLine());
                
            }catch(NumberFormatException n){
                System.out.println("Caractere inválido!!!");
            }
        }
    }
}
