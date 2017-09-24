/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio3;

import static java.lang.Math.sqrt;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author drayt
 */
public class AppConcorrente extends Thread {
    private static Random valor_aleatorio = new Random();
    private static int aleatorio = valor_aleatorio.nextInt(98);
    private static int tamanho = (int) (sqrt(aleatorio*aleatorio) + 2);    //Dá um valor positivo (em módulo) e aleatório de 2 à 10 a matriz
    private static int[][] matriz_A = new int[tamanho][tamanho];
    private static int[][] matriz_B = new int[tamanho][tamanho];
    private static int[][] matriz_R = new int[tamanho][tamanho];
    //private static ElementoMatriz[] calcula_elementos = new ElementoMatriz[tamanho*tamanho];
    
    public AppConcorrente(int i, int j){
        
    }
    
    public static void main (String[] args){
        String mA = "";
        String mB = "";
        String mR = "";
        String mAux = "";
        long tempo_inicial = 0;
        
        preenche_matriz(matriz_A);
        preenche_matriz(matriz_B);
        
        tempo_inicial = System.currentTimeMillis();
        multiplica_matrizes();
        System.out.println( (System.currentTimeMillis() - tempo_inicial) + " ms");
                
        mA = exibe_matriz(matriz_A);
        mB = exibe_matriz(matriz_B);
        mR = exibe_matriz(matriz_R);
        
        JOptionPane.showMessageDialog( null, "A Matriz A abaixo \n" + mA + "\n" + "multiplicada pela "          +
                                             "Matriz B à seguir \n" + mB + "\n" + "resulta na seguinte matriz" +
                                             "\n\n" + mR, "", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void run(int linha, int coluna){
        int soma_dos_elementos = 0;
        
        for(int k = 0; k < tamanho; k++){
            soma_dos_elementos = soma_dos_elementos + (matriz_A[linha][k] * matriz_B[k][coluna]);
        }
        
        matriz_R[linha][coluna] = soma_dos_elementos;
    }
    
    public static void preenche_matriz(int[][] matriz){
        for(int i = 0; i < tamanho; i++){
            for(int j = 0; j < tamanho; j++){
                //matriz[i][j] = valor_aleatorio.nextInt();
                matriz[i][j] = -100 + valor_aleatorio.nextInt(200);
                //matriz[i][j] = valor_aleatorio.nextInt(10);
            }
        }
    }
    
    public static void multiplica_matrizes(){
        AppConcorrente[][] thread = new AppConcorrente[tamanho][tamanho];
        int i = 0;
        int j = 0;
        
        for(i = 0; i < tamanho; i++){
            for(j = 0; j < tamanho; j++){
                 thread[i][j].start();
                 
            }
        }
        //this.join();
        //thread[i][j].join();
    }
    
    public static String exibe_matriz(int[][] matriz){
        String mAux = "";
        String m    = "";
        
        for(int i = 0; i < tamanho; i++){            
            for(int j = 0; j < tamanho; j++){
                if(j+1 != tamanho){
                    
                    if(j == 0){
                        mAux = "[   " + matriz[i][j];
                    }else{
                        mAux = mAux + "      " + matriz[i][j];
                    }
                    
                }else{
                    mAux = mAux + "      " + matriz[i][j] + "    ]";
                }
            }
            
            if(i == 0){
                m = mAux;
            }else{
                m = m + "\n" + mAux;
            }
        }
        
        return m;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

