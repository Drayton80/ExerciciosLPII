/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linguagemDeProgramacaoII.exercicio3;

/**
 *
 * @author drayt
 */
public class ElementoMatriz implements Runnable {
    private int linha, coluna, tamanho;
    
    public ElementoMatriz(int i, int j, int tamanho){
        this.tamanho = tamanho;
        linha  = i;
        coluna = j;
    }
    
    public void run(){
        int soma_dos_elementos = 0;
        
        for(int k = 0; k < tamanho; k++){
            //soma_dos_elementos = soma_dos_elementos + (matriz_A[linha][k] * matriz_B[k][coluna]);
        }
        
        //matriz_R[linha][coluna] = soma_dos_elementos;
    }
}
