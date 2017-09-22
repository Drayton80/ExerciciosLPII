/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linguagemDeProgramacaoII.poolDeThreads;

public class Exibidor implements Runnable {
    private int numero_da_tarefa = 1;
    private int numero_do_thread = 1;
    
    public Exibidor(int numero_do_thread, int numero_da_tarefa){
        this.numero_do_thread = numero_do_thread;
        this.numero_da_tarefa = numero_da_tarefa;
    }
    
    public Exibidor(int numero_da_tarefa){
        this.numero_da_tarefa = numero_da_tarefa;
    }
    
    public void run(){
        try{
            Thread.sleep(10000);
        }catch(Exception e){}
        
        System.out.println("Thread número { "                  + numero_do_thread +
                           " } executando a tarefa de número " + numero_da_tarefa);
         
    }
}
