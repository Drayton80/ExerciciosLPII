package exercicio5.poolDeThreads;

/**
 *
 * @author drayton80
 */

import java.net.ServerSocket;
import java.io.*;
import java.net.*;
import java.util.*;

public class ClienteCalculadora {
    public static void main(String[] arguments){
        try{
            Socket s = new Socket("localhost", 123);
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            PrintWriter out_message = new PrintWriter(out, true);
            Scanner in_message = new Scanner(in);
            Scanner entrada = new Scanner(System.in);
            
            LinkedList<Integer> resultado_soma = new LinkedList<Integer>();
            resultado_soma.add(0);
            int quantidade_de_somas = 0;
            
            LinkedList<Integer> resultado_multiplicacao = new LinkedList<Integer>();
            resultado_multiplicacao.add(1);
            int quantidade_de_multiplicacoes = 0;
            
            int escolha, subescolha;
            boolean sair = false;
            
            while(!sair){
                System.out.println("Escolha uma das seguintes opções: \n" +
                                   " 1 - Somar                        \n" +
                                   " 2 - Multiplicar                  \n" +
            //                       " 3 - Manipular Resultados         \n" +
                                   " 4 - Zerar Resultados             \n" +
                                   " 5 - Sair                           ");
                
                escolha = Integer.parseInt(entrada.nextLine());
                
                out_message.println(String.valueOf(escolha));
                
                switch(escolha){
                    case 1:
                        System.out.println("Quais números deseja somar?");
                        out_message.println(entrada.nextLine());
                        
                        resultado_soma.add( (quantidade_de_somas + 1) , Integer.parseInt(in_message.nextLine()) );
                        System.out.println("A soma resultou em " + resultado_soma.get(quantidade_de_somas + 1));
                        
                        resultado_soma.add(0);
                        quantidade_de_somas++;
                        break;
                        
                    case 2:
                        System.out.println("Quais números deseja multiplicar?");
                        out_message.println(entrada.nextLine());
                        
                        resultado_multiplicacao.add( (quantidade_de_multiplicacoes + 1), Integer.parseInt(in_message.nextLine()) );
                        System.out.println("A multiplicação resultou em " 
                                            + resultado_multiplicacao.get(quantidade_de_multiplicacoes + 1) );
                        
                        resultado_multiplicacao.add(1);
                        quantidade_de_multiplicacoes++;
                        break;
                        
                    //case 3:
                    //    String com_espacos;
                    //    String[] sem_espacos;
                    //    int[] numeros;
                    //    
                    //    System.out.println("Há os seguintes resultados de somas: ");
                    //    
                    //    for(int i = 0; i < quantidade_de_somas; i++){
                    //        System.out.println(" s" + (i+1) + " = " + resultado_soma.get(i + 1));
                    //    }
                    //    
                    //    for(int i = 0; i < quantidade_de_multiplicacoes; i++){
                    //        System.out.println(" m" + (i+1) + " = " + resultado_multiplicacao.get(i + 1));
                    //    }
                    //    
                    //    System.out.println("  Escolha uma das seguintes opções: \n" +
                    //                       "   1 - Somar Resultados             \n" +
                    //                       "   2 - Multiplicar Resultados       \n" +
                    //                       "   3 - Retornar ao menu               ");
                    //    
                    //    subescolha = Integer.parseInt(entrada.nextLine());
                    //    
                    //    out_message.println(subescolha);
                    //    
                    //    switch(subescolha){
                    //        case 1:                                
                    //            System.out.println("Quais s e/ou m deseja somar entre si?");
                    //            com_espacos = entrada.nextLine();
                    //            sem_espacos = com_espacos.split(" ");
                    //            
                    //            numeros = new int[sem_espacos.length];
                    //            
                    //            for(int i = 0; i < sem_espacos.length; i++){
                    //                if(sem_espacos[i].substring(0,0).equals("s")){
                    //                    String num = sem_espacos[i].substring(1);
                    //                    
                    //                    numeros[i] = resultado_soma.get( Integer.parseInt(num) );
                    //                }
                    //                
                    //                if(sem_espacos[i].substring(0,0).equals("m")){
                    //                    String num = sem_espacos[i].substring(1);
                    //                    
                    //                    numeros[i] = resultado_multiplicacao.get( Integer.parseInt(num) );
                    //                }
                    //            }
                    //            
                    //            String numeros_para_somar = "";
                    //            
                    //            for(int i = 0; i < numeros.length; i++){
                    //                if(i == 0){
                    //                    numeros_para_somar = numeros_para_somar + numeros[i];
                    //                }else{
                    //                    numeros_para_somar = numeros_para_somar + " " + numeros[i];
                    //                }
                    //            }
                    //            
                    //            out_message.println(numeros_para_somar);
                    //            
                    //            resultado_soma.add( (quantidade_de_somas + 1), Integer.parseInt(in_message.nextLine()) );
                    //            System.out.println("A soma resultou em " + resultado_soma.get(quantidade_de_somas + 1) );
                    //
                    //            resultado_soma.add(0);
                    //            quantidade_de_somas++;
                    //            break;
                    //    
                    //        case 3:
                    //            break;
                    //    }
                    //    
                    case 4:
                        resultado_soma.clear();
                        resultado_multiplicacao.clear();
                        quantidade_de_somas = 0;
                        quantidade_de_multiplicacoes = 0;
                        break;
                        
                    case 5:
                        sair = true;
                        break;
                        
                    default:
                        System.out.println("Escolha inválida!!!");
                }
            }
            
            in.close();
            out.close();
            s.close();
            
        }catch(IOException n){
            System.out.println("Conexão com o servidor falhou.");
        }
    }
}
