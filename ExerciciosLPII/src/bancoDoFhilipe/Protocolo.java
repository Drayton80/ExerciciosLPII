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
public class Protocolo {
    public static String Menu() {

        return "  ------------- MENU ------------\n"
                + "|Opção 1 - Criar nova conta  |\n"
                + "|Opção 2 - Realizar deposito |\n"
                + "|Opção 3 - Realizar saque    |\n"
                + "|Opção 4 - Sair              |\n"
                + "-------------------------------\n"
                + "por favor selecione uma opção: ";
    }
    public static String Saida(){
        return "Serviço encerrado.";
    }
    
    public static String Opcao1(String nome, String senha){
        //Cria um novo elemento conta no array de Contas:
        Servidor.contas.add(new Conta(nome, senha));
        return "Nova conta criada com sucesso!\n";
    }
    public static String Opcao2(String nome, String senha, double quantia){
        //Para cada conta: 
        for (Conta c : Servidor.contas) {
            //Se o nome da conta for equivalente ao parametro:  
            if (c.getNome().equals(nome)) {
                //Se a senha for equivalente ao parametro:
                if (c.getSenha().equals(senha)) {
                    c.deposito(quantia);
                    return "Deposito feito com sucesso, seu novo saldo é: " + c.getSaldo() + ".";
                }
                //Se a senha não for:
                return "Senha errada.";
            }
        }
        //se o nome não for:
        return "Conta não encontrada.";
    }
    public String Opcao3(String nome, String senha, double quantia) {
        //para cada conta:
        for (Conta c : Servidor.contas) {
            //Se o nome for equivalente:
            if (c.getNome().equals(nome)) {
                //Se a senha for equivalente:
                if (c.getSenha().equals(senha)) {
                    c.saque(quantia);
                    return "Withdraw sucessfully made. Your new balance is " + c.getSaldo() + ".";
                }
                //Se a senha não for:
                return "Wrong password.";
            }
        }
        //Se o nome não for:
        return "Sorry, we could not find this account.";
    }

    
}
