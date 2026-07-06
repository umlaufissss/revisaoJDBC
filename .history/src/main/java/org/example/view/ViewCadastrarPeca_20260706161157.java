package org.example.view;

import java.util.Scanner;

import org.example.service.ServicePeca;

public class ViewCadastrarPeca 
{
    static Scanner SC = new Scanner(System.in);

    public static void cadastrarPecaView()
    {
        String nome;
        double estoque;
        //Cabeçalho
        System.out.println("==============");
        System.out.println("Cadastrar Peça");
        System.out.println("==============");

        //Requere os valores necessários para cadastrar uma peça
        System.out.println("Digite o nome da peça: ");
        nome = SC.nextLine();

        System.out.println("Digite a quantidade em estoque: ");
        estoque = SC.nextDouble();
        SC.nextLine();

        //
        String response = ServicePeca.serviceCadastroPeca(nome, estoque);

        System.out.println(response);

    }
}
