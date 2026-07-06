package org.example.view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.example.model.OrdemManutencao;
import org.example.model.OrdemPeca;
import org.example.model.Peca;
import org.example.service.ServiceOrdem;
import org.example.service.ServicePeca;

public class ViewExecutarManutencao 
{
    static Scanner SC = new Scanner(System.in);

    public static void executarManutencaoView()
    {
        List<OrdemManutencao> ordens;
        Map<Peca, OrdemPeca> estoque;
        int escolhaOrd;
        
        System.out.println("===================");
        System.out.println("Executar Manutençaõ");
        System.out.println("===================");

        System.out.println("Aperte qualquer tecla para começar a listagem de ordens de manutenção pendentes: ");
        SC.nextLine();

        //Chamar service que irá apenas retornar ordens pendente
        ordens = ServiceOrdem.listarPendencias();

        //Listagem de ordens perndentes
        System.out.println("=================");
        System.out.println("Ordens pendentes:");
        System.out.println("=================");
        for(OrdemManutencao ordem : ordens)
        {
            System.out.println("============== ID:" + ordem.getId()
            + "\nMáquina: " + ordem.getIdMaquina()
            + "\nTécnico: " + ordem.getIdTecnico() 
            + "\nData: " + ordem.getDataSolicitacao() 
            + "\nStatus: " + ordem.getStatus()
            + "\n");
        }

        System.out.println("Verificando o estoque das peças...");
        estoque = ServicePeca.verificarEstoque();
    }
}
