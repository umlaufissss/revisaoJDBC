package org.example.view;

import java.util.List;
import java.util.Scanner;

import org.example.model.Maquina;
import org.example.model.OrdemManutencao;
import org.example.repository.OrdemDAO;


public class ViewAssociarPecas 
{
    static Scanner SC = new Scanner(System.in);

    public static void associarPecasView()
    {
        List<OrdemManutencao> ordens;

        System.out.println("======================");
        System.out.println("Associar Peças à Ordem");
        System.out.println("======================");

        System.out.println("Aperte qualquer tecla para começar a listagem de ordens de manutenção: ");
        SC.nextLine();

        ordens = ServiceO.listarPendencias();

        for(OrdemManutencao ordem : ordens)
        {
            System.out.println("============== ID:" + ordem.getId()+ "\nMáquina: " + ordem.getIdMaquina()+ "\nTécnico: " + ordem.getIdTecnico() + "\nData: " + ordem.getDataSolicitacao() + "\nStatus: " + ordem.getStatus());
        }
    }
}
