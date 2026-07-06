package org.example.view;

import java.util.List;
import java.util.Scanner;

import org.example.model.OrdemManutencao;
import org.example.service.ServiceOrdem;

public class ViewExecutarManutencao 
{
    static Scanner SC = new Scanner(System.in);

    public static void executarManutencaoView()
    {
        List<OrdemManutencao> ordens;
        int escolhaOrd;
        
        System.out.println("===================");
        System.out.println("Executar Manutençaõ");
        System.out.println("===================");

        System.out.println("Aperte qualquer tecla para começar a listagem de ordens de manutenção pendentes: ");
        SC.nextLine();

        //Chamar service que irá apenas retornar ordens pendente
        ordens = ServiceOrdem.listarPendencias();

        //Listagem de ordens perndentes
        for(OrdemManutencao ordem : ordens)
        {
/*
Para cada peça da ordem: 
■ Verificar o estoque atual da peça no banco de dados. 
■ Comparar com quantidade necessária*/

            System.out.println("============== ID:" 
            + ordem.getId()+ "\nMáquina: " + ordem.getIdMaquina()
            + "\nTécnico: " + ordem.getIdTecnico() 
            + "\nData: " + ordem.getDataSolicitacao() 
            + "\nStatus: " + ordem.getStatus());
        }
    }
}
