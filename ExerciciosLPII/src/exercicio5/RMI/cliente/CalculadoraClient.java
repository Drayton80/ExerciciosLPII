package linguagemDeProgramacaoII.exercicio5.RMI.cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.Scanner;
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
            
            Context con = new InitialContext();
            calc = (Calculadora) con.lookup("rmi://127.0.0.1/calculadora");
            
            /*calc = (Calculadora) Naming.lookup(url);     /* Faz o objeto calc apontar ou,
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
            int contador = 1;
            int  escolha = 0;
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
                                           " 6 - Para Sair              \n");
                        
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
                        numeros = array_string_para_int(sem_espacos);
                        
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
                        numeros = array_string_para_int(sem_espacos);
                        
                        resultados.add(calc.multiplicacao(numeros));
                        System.out.println(      "A operação teve como resultado: " +
                                           String.valueOf(resultados.get(contador)));
                        
                        contador++;
                        break;
                     
                    case 6:
                        sair = true;
                        
                }
                
                
                
                
                
            }
            
            
            
        }catch(NamingException e){
            System.out.println("Erro no URL: " + e.getMessage());
        }catch(RemoteException e){
            System.out.println("Erro remoto: " + e.getMessage());
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    private static double[] array_string_para_int(String[] sequencia){
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
}
