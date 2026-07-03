package org.example.view;

import java.util.Scanner;

public class ViewCadastrarMaquina 
{
    //Funcionalidade 1
    public static void cadastrarMaquinaView()
    {
        Scanner sc = new Scanner(System.in);
        String nome, setor;

        //Exec. 1
        System.out.println("=================");
        System.out.println("Cadastrar Maquina");
        System.out.println("=================");

        //Exec. 2
        System.out.println("Digite o nome da máquina");
        nome = sc.nextLine();

        System.out.println("Digite o setor da máquina");
        setor = sc.nextLine();
        
    }
}
