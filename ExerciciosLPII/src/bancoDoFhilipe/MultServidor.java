/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoDoFhilipe;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author Kel_Nunes
 */
public class MultServidor implements Runnable {

    //Atributo com socket?
    Socket cliente;
    //Construtor do atributo?
    public MultServidor(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        try {
            //Criando as conexões in e out:
            DataInputStream in = new DataInputStream(cliente.getInputStream());
            DataOutputStream out = new DataOutputStream(cliente.getOutputStream());

            //Instanciando scanner(teclado) e a classe protocolo:
            Scanner entrada = new Scanner(System.in);
            Protocolo protocolo = new Protocolo();
            //Variaveis:
            int opcao;
            double quantia;
            String nome, senha;

            while (true) {
                try {
                    //Enviando o menu para o cliente:
                    out.writeUTF(Protocolo.Menu());
                    out.writeBoolean(true);
                    //Recebendo opção do cliente e transformando em um inteiro:
                    opcao = Integer.parseInt(in.readUTF());

                    //Encerramento:
                    if (opcao == 4) {
                        out.writeUTF(Protocolo.Saida());
                        break;
                    }
                    //Perguntando nome:
                    out.writeUTF("Entre com o nome da conta:");
                    //O que isso faz?
                    out.writeBoolean(true);
                    //Recebendo resposta do nome:
                    nome = in.readUTF();
                    
                    //Perguntando a senha:
                    out.writeUTF("Entre com a senha da conta:");
                    //O que isso faz?
                    out.writeBoolean(true);
                    //Recebendo a resposta:
                    senha = in.readUTF();
                    switch (opcao) {
                        case 1:
                            out.writeUTF(protocolo.Opcao1(nome, senha));
                            out.writeBoolean(false);
                            break;
                        case 2:
                            out.writeUTF("Entre com a quantia a ser depositada:");
                            //O que este caralho faz?
                            out.writeBoolean(true);
                            quantia = Double.parseDouble(in.readUTF());
                            out.writeUTF(protocolo.Opcao2(nome, senha, quantia));
                            //O que esta buceta faz?
                            out.writeBoolean(false);
                            break;
                        case 3:
                            out.writeUTF("Entre com a quantia a ser sacada:");
                            out.writeBoolean(true);
                            quantia = Double.parseDouble(in.readUTF());
                            out.writeUTF(protocolo.Opcao3(nome, senha, quantia));
                            //O que esta mizera faz?
                            out.writeBoolean(false);
                            break;
                        default:
                            out.writeUTF("Invalid option, please, try again.");
                            //O que esta mizera faz?
                            out.writeBoolean(true);
                            break;
                    }
                } catch (NumberFormatException erro) {
                    out.writeUTF("Numero invalido, tente novamente:");
                    //O que esta porra faz?
                    out.writeBoolean(false);
                }
            }
            cliente.close();
            in.close();
            out.close();

        } catch (Exception erro) {
            System.err.println("ERRO: " + erro.toString());
        }
    }

}
