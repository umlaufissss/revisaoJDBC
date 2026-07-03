package org.example.view;

import java.util.Scanner;

import org.example.service.ServiceMaquina;

public class ViewCadastrarMaquina 
{
    Scanner sc = new Scanner(System.in);
    //Funcionalidade 1
    public static void cadastrarMaquinaView()
    {
        String nome, setor;

        //Exec. 1
        System.out.println("=================");
        System.out.println("Cadastrar Maquina");
        System.out.println("=================");

        //Exec. 2
        System.out.println("Digite o nome da máquina: ");
        nome = sc.nextLine();

        System.out.println("Digite o setor da máquina: ");
        setor = sc.nextLine();

        sc.close();

        //Exec.3 Chamando Service
        String response = ServiceMaquina.serviceCadastrarMaquina(nome, setor);

        System.out.println(response);
    }
}
