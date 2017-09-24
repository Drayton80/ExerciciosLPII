package programaDoDouglas;
import programaDoDouglas.Clientes;
import java.io.*;
import java.net.Socket;
import java.util.concurrent.*;

public class MultiplosClientes {


    public static void main(String[] args){
        Clientes cliente1 = new Clientes();
        Clientes cliente2 = new Clientes();
        Thread c1 = new Thread(cliente1);
        Thread c2 = new Thread(cliente2);
        c1.start();
        c2.start();
    }
    
}
