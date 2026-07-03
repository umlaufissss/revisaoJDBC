package org.example.view;

import java.util.Scanner;

import org.example.service.ServiceMaquina;

public class ViewCadastrarTecnico 
{
    static Scanner SC = new Scanner(System.in);
    //Funcionalidade 1
    public static void cadastrarTecnicoView()
    {
        String nome, especialidade;

        //Exec. 1
        System.out.println("=================");
        System.out.println("Cadastrar Técnico");
        System.out.println("=================");

        //Exec. 2
        System.out.println("Digite o nome do técnico: ");
        nome = SC.nextLine();

        System.out.println("Digite a especialidade do técnico: ");
        especialidade = SC.nextLine();

        //Exec.3 Chamando Service
        String response = ServiceMaquina.serviceCadastrarMaquina(nome, setor);

        System.out.println(response);
    }
}
