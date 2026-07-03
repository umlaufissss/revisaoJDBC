package org.example.view;

import java.util.Scanner;

import org.example.model.Maquina;
import org.example.service.ServiceMaquina;

public class ViewAssociarPecas 
{
    static Scanner SC = new Scanner(System.in);

    public static void associarPecasView()
    {
        System.out.println("======================");
        System.out.println("Associar Peças à Ordem");
        System.out.println("======================");

        System.out.println("Aperte qualquer tecla para começar a listagem de ordens de manutenção: ");
        SC.nextLine();

        maquinas = ServiceMaquina.listarOperacionaisService();

        for(Maquina maquina : maquinas)
        {
            System.out.println("============== ID:" + maquina.getId()+ "\nNome: " + maquina.getNome() + "\nSetor: " + maquina.getSetor());
        }
    }
}
