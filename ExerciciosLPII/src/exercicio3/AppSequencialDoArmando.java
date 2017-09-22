// Ler duas matrizes A e B quadradas de ordem 3 e realizar o produto destas matrizes.
// O produto AB da matriz A pela matriz B, apenas esta definido se o numero de colunas
// de A for igual ao numero de linhas de B. Cada elemento de AB e definido atraves do
// somatorio do produto dos elementos da i-esima linha da matriz A com os respetivos
// elementos da j-esima coluna da matriz B.
package linguagemDeProgramacaoII.exercicio3;

import java.util.*;

public class AppSequencialDoArmando {

  public static void main(String[] args) {
    Random rolagem = new Random();  
    Scanner ler = new Scanner(System.in);

    int n = 1 + rolagem.nextInt( 50 );; // ordem da matriz quadrada
    int i, j, k, sm;
    int a[][] = new int[50][50];
    int b[][] = new int[50][50];
    int ab[][] = new int[50][50];

// entrada de dados
    
    for (i=0; i<n; i++) {
      
      for (j=0; j<n; j++) {
        
        a[i][j] = 1 + rolagem.nextInt( 50 );
      }
      
    }

    
    for (i=0; i<n; i++) {
      
      for (j=0; j<n; j++) {
        
        b[i][j] = 1 + rolagem.nextInt( 50 );
      }
      
    }

// processamento: multiplicando as matrizes de entrada
    for (i=0; i<n; i++) {
      for (j=0; j<n; j++) {
        sm = 0;
        for (k=0; k<n; k++) {
          sm = sm + (a[i][k] * b[k][j]);
        }
        ab[i][j] = sm;
      }
    }

// saida
    System.out.printf("\n1a. Matriz________\n");
    for (i=0; i<n; i++) {
      System.out.printf("%da. linha: ", (i+1));
      for (j=0; j<n; j++) {
        System.out.printf("%d ", a[i][j]);
      }
      System.out.printf("\n");
    }

    System.out.printf("\n2a. Matriz________\n");
    for (i=0; i<n; i++) {
      System.out.printf("%da. linha: ", (i+1));
      for (j=0; j<n; j++) {
        System.out.printf("%d ", b[i][j]);
      }
      System.out.printf("\n");
    }

    System.out.printf("\nProduto___________\n");
    for (i=0; i<n; i++) {
      System.out.printf("%da. linha: ", (i+1));
      for (j=0; j<n; j++) {
        System.out.printf("%d ", ab[i][j]);
      }
      System.out.printf("\n");
    }
  }
}