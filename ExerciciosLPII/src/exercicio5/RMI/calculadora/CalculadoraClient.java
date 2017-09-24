package exercicio5.RMI.calculadora;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CalculadoraClient {
    public static void main(String[] arguments){
        String url = "//localhost/calculadora";
    
    
        try{
            Calculadora calc;                           /* Criando um objeto do tipo calc
                                                         * e deixando preparado para apontar para
                                                         * algo.
                                                         */
            
            //Registry registro = LocateRegistry.getRegistry("localhost",1099);
            //calc = (Calculadora) registro.lookup("calculadoraRMI");
            
            //Context con = new InitialContext();
            //calc = (Calculadora) con.lookup("rmi://localhost/calculadora");  //Deu errado
            
            calc = (Calculadora) Naming.lookup("rmi://localhost/calculadora");     /* Faz o objeto calc apontar ou,
                                                                                    * mais precisamente, procurar e
                                                                                    * apontar para a localização (URL) do
                                                                                    * objeto calculadora na Classe
                                                                                    * CalculadoraServer.
                                                                                    */
            
            /* Feito isso, tem-se que calc aponta para um objeto remoto aonde estão instanciados
             * todos os métodos que serão necessários para a calculadora, ou seje, os dois
             * passos anteriores em conjunto com os do CalculadoraServidor fizeram com que um
             * objeto CalculadoraImpl produzisse um URL na rede e com que calc pudesse apontar
             * para esse URL e, assim, ficar possibilitado de usar qualquer método de CalculadoraImpl
             */
            
            boolean sair = false;
            int contador = 0;
            int  escolha = 0;
            int[] posicoes;
            double[] numeros;
            Scanner scan = new Scanner(System.in);
            String com_espacos;
            String[] sem_espacos;
            
            LinkedList<Double> resultados = new LinkedList();           
            
            while(!sair){
                boolean ficar_no_try = true;
                
                while(ficar_no_try){
                    try{
                        System.out.println("Qual operação deseja fazer? \n" +
                                           " 1 - Soma                   \n" +
                                           " 2 - Multiplicação          \n" +
                                           " 3 - Subtração              \n" +
                                           " 4 - Divisão                \n" +
                                           " 5 - Manipular Resultados   \n" +
                                           " 6 - Para Sair                ");
                        
                        escolha = Integer.parseInt(scan.nextLine());
                        
                        ficar_no_try = false;
                    }catch(NumberFormatException e){
                        System.out.println("Caractere inválido!!!");
                    }
                }
                
                switch(escolha){
                    case 1:
                        System.out.println("Digite os números que deseja somar abaixo: ");
                        
                        com_espacos = scan.nextLine();
                        sem_espacos = com_espacos.split(" ");
                        
                        numeros = new double[sem_espacos.length];
                        numeros = array_string_para_double(sem_espacos);
                        
                        resultados.add(calc.soma(numeros));
                        System.out.println(      "A operação teve como resultado: " +
                                           String.valueOf(resultados.get(contador)));
                        
                        contador++;
                        break;
                     
                    case 2:
                        System.out.println("Digite os números que deseja multiplicar abaixo: ");
                        
                        com_espacos = scan.nextLine();
                        sem_espacos = com_espacos.split(" ");
                        
                        numeros = new double[sem_espacos.length];
                        numeros = array_string_para_double(sem_espacos);
                        
                        resultados.add(calc.multiplicacao(numeros));
                        System.out.println(      "A operação teve como resultado: " +
                                           String.valueOf(resultados.get(contador)));
                        
                        contador++;
                        break;
                    
                    case 3:
                        System.out.println("Digite os números que deseja subtrair abaixo: ");
                        
                        com_espacos = scan.nextLine();
                        sem_espacos = com_espacos.split(" ");
                        
                        numeros = new double[sem_espacos.length];
                        numeros = array_string_para_double(sem_espacos);
                        
                        resultados.add(calc.subtracao(numeros));
                        System.out.println(      "A operação teve como resultado: " +
                                           String.valueOf(resultados.get(contador)));
                        
                        contador++;
                        break;
                        
                    case 4:
                        System.out.println("Digite os números que deseja dividir abaixo: ");
                        
                        com_espacos = scan.nextLine();
                        sem_espacos = com_espacos.split(" ");
                        
                        numeros = new double[sem_espacos.length];
                        numeros = array_string_para_double(sem_espacos);
                        
                        resultados.add(calc.divisao(numeros));
                        System.out.println(      "A operação teve como resultado: " +
                                           String.valueOf(resultados.get(contador)));
                        
                        contador++;
                        break;
                    
                    case 5:
                        System.out.println(" O programa possuí os seguintes resultados: ");
                        
                        for(int i = 0; i < resultados.size(); i++){  
                            System.out.println("   Resultado " + (i+1) + ": " + String.valueOf(resultados.get(i))); 
                        }
                        
                        System.out.println(" Quais você deseja manipular?");
                        
                        com_espacos = scan.nextLine();
                        sem_espacos = com_espacos.split(" ");
                        
                        posicoes = new int[sem_espacos.length];
                        numeros  = new double[sem_espacos.length];
                        posicoes = array_string_para_int(sem_espacos);
                        
                        for(int i = 0; i < posicoes.length; i++){
                            numeros[i] = resultados.get(posicoes[i]-1); //As posições de uma linkedlist vão de 0 a n
                        }
                        
                        System.out.println(" Que operação quer fazer com eles?");
                        
                        boolean ficar_no_laco = true;
                        
                        while(ficar_no_laco){
                            System.out.println(" Qual operação deseja fazer?  \n" +
                                               "  1 - Somar                   \n" +
                                               "  2 - Multiplicaçar           \n" +
                                               "  3 - Subtrair                \n" +
                                               "  4 - Dividir                   ");

                            escolha = Integer.parseInt(scan.nextLine());

                            switch(escolha){
                                case 1:
                                    resultados.add(calc.soma(numeros));
                                    ficar_no_laco = false;
                                    
                                    break;
                                    
                                case 2:
                                    resultados.add(calc.multiplicacao(numeros));
                                    ficar_no_laco = false;
                                    
                                    break;
                                
                                case 3:
                                    resultados.add(calc.subtracao(numeros));
                                    ficar_no_laco = false;
                                    
                                    break;
                                    
                                case 4:
                                    resultados.add(calc.divisao(numeros));
                                    ficar_no_laco = false;
                                    
                                    break;
                                    
                                default:
                                    System.out.println("Caractere inválido!!!");
                            }
                        }
                        
                        System.out.println(      "A operação teve como resultado: " +
                                           String.valueOf(resultados.get(contador)));
                        
                        contador++;
                        break;
                        
                    case 6:
                        sair = true;
                        
                } 
            }
            
            
            
        }catch(RemoteException e){
            System.out.println("Erro remoto: " + e.getMessage());
        //}catch(Exception e){
        //    System.out.println("Erro: " + e.getMessage());
        } catch (NotBoundException e) {
            System.out.println("Erro no Vinculo: " + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println("Erro no URL: " + e.getMessage());
        }
    }
    
    private static double[] array_string_para_double(String[] sequencia){
        double[] numeros = new double[sequencia.length];
        
        for(int i = 0; i < sequencia.length; i++){
            try{
                numeros[i] = Double.parseDouble(sequencia[i]);
            }catch(NumberFormatException e){
                numeros[i] = 0;
            }
        }
        
        return numeros;
    }
    
    private static int[] array_string_para_int(String[] sequencia){
        int[] numeros = new int[sequencia.length];
        
        for(int i = 0; i < sequencia.length; i++){
            try{
                numeros[i] = Integer.parseInt(sequencia[i]);
            }catch(NumberFormatException e){
                numeros[i] = 0;
            }
        }
        
        return numeros;
    }
}
