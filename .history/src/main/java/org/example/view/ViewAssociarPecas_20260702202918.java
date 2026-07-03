package org.example.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.example.model.OrdemManutencao;
import org.example.model.Peca;
import org.example.service.ServiceOrdem;
import org.example.service.ServicePeca;


public class ViewAssociarPecas 
{
    static Scanner SC = new Scanner(System.in);

    public static void associarPecasView()
    {
        List<OrdemManutencao> ordens;
        List<Peca> pecas;
        int escolhaOrd, escolhaPec;
        double estoque;

        //Exec. 1
        System.out.println("======================");
        System.out.println("Associar Peças à Ordem");
        System.out.println("======================");

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

        try
        {
            ServiceOrdem.buscarPorId(escolhaOrd);
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }

        pecas = ServicePeca.listarTudo();

        //Exec. 3
        for(Peca peca : pecas)
        {
            System.out.println("============== ID:" + peca.getId()+ "\nNome: " + peca.getNome()+ "\nEstoque: " + peca.getEstoque());
        }

        System.out.println("Escolha a Peça por ID: ");
        escolhaPec = SC.nextInt();
        SC.nextLine();

        System.out.println("Selecione a quantidade necessária do estoque");
        estoque = SC.nextDouble();

        try 
        {
            ServicePeca.buscarPorId(escolhaOrd, estoque);
        } 
        catch (SQLException e) 
        {
            System.err.println(e);
        }

        var
        
    }
}
