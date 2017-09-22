/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linguagemDeProgramacaoII.poolDeThreads;

import java.util.concurrent.*;

public class PoolDeThreadsFixo {
    public static void main (String[] args){
        ExecutorService fixo = Executors.newFixedThreadPool(6);
        ExecutorService cache = Executors.newCachedThreadPool();
        ExecutorService temporal = Executors.newScheduledThreadPool(6);
        
        for(int i = 1, j = 1; i <= 20; i++, j++){
            if(i <= 6){
               fixo.execute(new Exibidor(i , j));
                //cache.execute(new Exibidor (i));
                //temporal.execute(new Exibidor (i)); 
            }else{
                fixo.execute(new Exibidor(j));
            }
        }
        
    }
}
