package org.example.view;

import java.util.List;
import java.util.Scanner;

import org.example.model.Maquina;
import org.example.model.Tecnico;
import org.example.service.ServiceMaquina;
import org.example.service.ServiceTecnico;

public class ViewCadastrarOrdem 
{
    static Scanner SC = new Scanner(System.in);

    public static void cadastrarOrdemView()
    {
        List<Maquina> maquinas;
        List<Tecnico> tecnicos;
        int escolha;

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
        
        System.out.println("Aperte qualquer tecla para começar a listagem de técnicos: ");
        SC.nextLine();

        tecnicos = ServiceTecnico.listarTodos();

        for(Tecnico tecnico : tecnicos)
        {
            System.out.println("==============" + tecnico.getId()+ "\nNome: " + tecnico.getNome() + "\nEspecialidade: " + tecnico.getEspecialidade());
        }

        System.out.println("Escolha o técnico por ID: ");
        escolha = SC.nextInt();
        SC.nextLine();

        if(tecnicos.get(escolha).getId() != escolha)
        {
            System.out.println("Técnico não existe");
        }



    }
}
