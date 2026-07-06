package org.example.view;

import java.util.Scanner;

import org.example.service.ServiceTecnico;
import org.example.util.ScannerSingleton;

public class ViewCadastrarTecnico 
{
    //Singletons da Pasta Util
    static Scanner SC = ScannerSingleton.getInstance();

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
