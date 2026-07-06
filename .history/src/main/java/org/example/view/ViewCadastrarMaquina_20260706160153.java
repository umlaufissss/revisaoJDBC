package org.example.view;

import java.util.Scanner;

import org.example.service.ServiceMaquina;

public class ViewCadastrarMaquina 
{
    static Scanner SC = new Scanner(System.in);
    //Funcionalidade 1
    public static void cadastrarMaquinaView()
    {
        String nome, setor;

        //Cabeçalho
        System.out.println("=================");
        System.out.println("Cadastrar Maquina");
        System.out.println("=================");

        //Requere os valores necessários para criar uma máquina
        System.out.println("Digite o nome da máquina: ");
        nome = SC.nextLine();

        System.out.println("Digite o setor da máquina: ");
        setor = SC.nextLine();

        //Chama service que irá tratar os valores
        String response = ServiceMaquina.serviceCadastrarMaquina(nome, setor);

        //Resposta da service de sucesso ou fracasso
        System.out.println(response);
    }
}
