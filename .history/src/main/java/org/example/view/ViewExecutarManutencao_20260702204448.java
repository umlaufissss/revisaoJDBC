package org.example.view;

import org.example.model.OrdemManutencao;
import org.example.service.ServiceOrdem;

public class ViewExecutarManutencao 
{
    public static void executarManutencaoView()
    {
        System.out.println("===================");
        System.out.println("Executar Manutençaõ");
        System.out.println("===================");

        System.out.println("Aperte qualquer tecla para começar a listagem de ordens de manutenção: ");
        SC.nextLine();

        ordens = ServiceOrdem.listarPendencias();

        //Exec. 2
        for(OrdemManutencao ordem : ordens)
        {
            System.out.println("============== ID:" + ordem.getId()+ "\nMáquina: " + ordem.getIdMaquina()+ "\nTécnico: " + ordem.getIdTecnico() + "\nData: " + ordem.getDataSolicitacao() + "\nStatus: " + ordem.getStatus());
        }

        System.out.println("Escolha a Ordem por ID: ");
        escolhaOrd = SC.nextInt();
        SC.nextLine();
    }
}
