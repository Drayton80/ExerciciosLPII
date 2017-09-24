package poolDeThreads;

import java.util.concurrent.*;

public class PoolDeThreadsFixo {
    public static void main (String[] args){
        ExecutorService fixo = Executors.newFixedThreadPool(6);
        ExecutorService cache = Executors.newCachedThreadPool();
        ExecutorService temporal = Executors.newScheduledThreadPool(6);
        
        //Com interface Runnable:
        Exibidor h = new Exibidor(12);
        Thread t = new Thread(h);
        t.start();
        
        //Com extends Thread:
        ExibidorT thread = new ExibidorT(12);
        thread.start();
        
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
