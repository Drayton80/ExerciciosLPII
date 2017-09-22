/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linguagemDeProgramacaoII.exercicio5.RMI.servidor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CalculadoraServer {
    public static void main(String[] arguments) throws RemoteException, NamingException, MalformedURLException{
        String url = "//localhost/calculadora";    //Definindo um URL qualquer
        
        try{
            CalculadoraImpl calculadora = new CalculadoraImpl();    /* Instanciando um objeto do tipo CalculadoraImpl
                                                                     * que implementa interface Calculadora        */
            
            Context name = new InitialContext();
            name.rebind("rmi:calculadora", calculadora);
            
            /*Naming.rebind( url, calculadora);                       /* Associa ou registra um nome (nesse caso,
                                                                     * calculadora) para um Objeto Remoto o qual
                                                                     * pode ser usado depois para procurar esse
                                                                     * mesmo Objeto Remoto, ou seja, você confere
                                                                     * para um objeto uma localização (ou URL) para
                                                                     * que ele possa ser encontrado na rede.
                                                                     */
            
            /* Ambos os passos anteriores serviram para criar uma instância de um objeto CalculadoraImpl e fazê-lo
             * possuir um endereço em rede (como um sinalizador) que espera por alguém para acessá-lo (bind = vincular) ou
             * para que seja estabelecido um vinculo.
             */
                        
        }catch(RemoteException e){
            System.out.println("Erro: " + e.getMessage()); //Pegando a mensagem da exceção e exibindo na tela
        }catch(NamingException e){
            System.out.println("Erro no URL: " + e.getMessage()); //Pegando a mensagem da exceção e exibindo na tela
        }
    }
}
