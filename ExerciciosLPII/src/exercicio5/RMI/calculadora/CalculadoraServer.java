package exercicio5.RMI.calculadora;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class CalculadoraServer {
    public static void main(String[] arguments) throws RemoteException, NamingException, MalformedURLException{
        String url = "//localhost/calculadora";    //Definindo um URL qualquer
        
        try{
            Calculadora calculadora = new CalculadoraImpl();    /* Instanciando um objeto do tipo CalculadoraImpl
                                                                     * que implementa interface Calculadora        */
            
            //Registry registro = LocateRegistry.createRegistry(1099);
            //registro.rebind("calculadoraRMI", calculadora);

            //Context name = new InitialContext();
            //name.rebind("rmi:///calculadora", calculadora); //Deu errado
            
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi:///calculadora" , calculadora);      /* Associa ou registra um nome (nesse caso,
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
        }
        
    }
}
