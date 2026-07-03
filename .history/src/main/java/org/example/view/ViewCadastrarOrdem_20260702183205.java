package org.example.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.example.model.Maquina;
import org.example.service.ServiceMaquina;

public class ViewCadastrarOrdem 
{
    static Scanner SC = new Scanner(System.in);

    public static void cadastrarOrdemView()
    {
        List<Maquina> maquinas = new ArrayList<>();
        int escolha = 0;

        System.out.println("=========================");
        System.out.println("Criar Ordem de Manutenção");
        System.out.println("=========================");

        System.out.println("Aperte qualquer tecla para começar a listagem de máquinas: ");
        SC.nextLine();

        maquinas = ServiceMaquina.listarOperacionaisService();

        for(Maquina maquina : maquinas)
        {
        System.out.println("==============" + maquina.getId()+ "\nNome: " + maquina.getNome() + "\nSetor: " + maquina.getSetor());
        }

        System.out.println("Escolha a máquina por ID: ");
        escolha = SC.nextInt();
        SC.nextLine();

        if(maquinas.get(escolha).getId() != escolha)
        {
            System.out.println("Maquina não existe");
            //Colocar break aqui?
        }

        Eu conheco um dos três patetas?
        Fale os nomes
        Nem da menina?
        
    }
}
