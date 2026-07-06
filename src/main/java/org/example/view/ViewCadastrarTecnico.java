package org.example.view;

import java.util.Scanner;

import org.example.service.ServiceTecnico;

public class ViewCadastrarTecnico 
{
    static Scanner SC = new Scanner(System.in);
    //Funcionalidade 1
    public static void cadastrarTecnicoView()
    {
        String nome, especialidade;

        //Cabeçalho
        System.out.println("=================");
        System.out.println("Cadastrar Técnico");
        System.out.println("=================");

        //Requere os valores necessários para cadastrar um técnico
        System.out.println("Digite o nome do técnico: ");
        nome = SC.nextLine();

        System.out.println("Digite a especialidade do técnico: ");
        especialidade = SC.nextLine();

        //Chamar método para tratar os valores dados para cadastrar um técnico
        String response = ServiceTecnico.cadastrarTecnico(nome, especialidade);

        //Resposta da service de sucesso ou fracasso
        System.out.println(response);
    }
}
