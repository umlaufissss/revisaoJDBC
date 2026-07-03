package org.example.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.example.model.OrdemManutencao;
import org.example.service.ServiceMaquina;
import org.example.service.ServiceOrdem;


public class ViewAssociarPecas 
{
    static Scanner SC = new Scanner(System.in);

    public static void associarPecasView()
    {
        List<OrdemManutencao> ordens;
        int escolhaOrd;

        System.out.println("======================");
        System.out.println("Associar Peças à Ordem");
        System.out.println("======================");

        System.out.println("Aperte qualquer tecla para começar a listagem de ordens de manutenção: ");
        SC.nextLine();

        ordens = ServiceOrdem.listarPendencias();

        for(OrdemManutencao ordem : ordens)
        {
            System.out.println("============== ID:" + ordem.getId()+ "\nMáquina: " + ordem.getIdMaquina()+ "\nTécnico: " + ordem.getIdTecnico() + "\nData: " + ordem.getDataSolicitacao() + "\nStatus: " + ordem.getStatus());
        }

        System.out.println("Escolha a máquina por ID: ");
        escolhaOrd = SC.nextInt();
        SC.nextLine();

        try
        {
            ServiceMaquina.buscarPorId(escolhaMaq);
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
    }
}
