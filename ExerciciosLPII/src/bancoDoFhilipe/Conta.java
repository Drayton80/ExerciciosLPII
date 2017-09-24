/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoDoFhilipe;

/**
 *
 * @author Kel_Nunes
 */
public class Conta {
    //atributos:
    private double saldo;
    private String nome;
    private String senha;
    
    //construtor:
    public Conta(String name, String senha){
        this.nome = nome;
        this.senha = senha;
        saldo = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void deposito(double quantia){
        saldo += quantia;
    }
    
    public void saque(double quantia){
        saldo -= quantia;
    }
}
