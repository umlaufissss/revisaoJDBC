package org.example.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.example.model.OrdemManutencao;
import org.example.model.Peca;
import org.example.service.ServiceOrdem;
import org.example.service.ServiceOrdemPeca;
import org.example.service.ServicePeca;
import org.example.util.ReturnToMain;
import org.example.util.ScannerSingleton;


public class ViewAssociarPecas 
{
    //Singletons da Pasta Util
    static Scanner SC = ScannerSingleton.getInstance();
    static ReturnToMain returnToMain = ReturnToMain.getIntance();

    public static void associarPecasView()
    {
        List<OrdemManutencao> ordens;
        List<Peca> pecas;
        int escolhaOrd, escolhaPec;
        double estoque;
        boolean existe = false;

        //Cabeçalho
        System.out.println("======================");
        System.out.println("Associar Peças à Ordem");
        System.out.println("======================");

        System.out.println("Aperte qualquer tecla para começar a listagem de ordens de manutenção: ");
        SC.nextLine();

        //Chamar service que irá apeas retornar ordens pendentes
        ordens = ServiceOrdem.listarPendencias();

        if(ordens.isEmpty())
        {
            return;
        }

        //Listagen de ordens pendentes
        System.out.println("=================");
        System.out.println("Ordens pendentes:");
        System.out.println("=================");
        for(OrdemManutencao ordem : ordens)
        {
            System.out.println("============== ID:" + ordem.getId()
            + "\nMáquina: " + ordem.getIdMaquina()
            + "\nTécnico: " + ordem.getIdTecnico() 
            + "\nData: " + ordem.getDataSolicitacao() 
            + "\nStatus: " + ordem.getStatus());
        }

        System.out.println("Escolha a Ordem por ID: ");
        escolhaOrd = SC.nextInt();
        SC.nextLine();

        //Procurar ordem por ID
        try
        {
            existe = ServiceOrdem.buscarPorId(escolhaOrd);
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }

        System.out.println("Aperte qualquer tecla para começar a listagem das peças: ");
        SC.nextLine();

        pecas = ServicePeca.listarTudo();

        //Listagem de todas as peças
        System.out.println("==================");
        System.out.println("Listagem de peças:");
        System.out.println("==================");
        for(Peca peca : pecas)
        {
            System.out.println("============== ID:" + peca.getId()
            + "\nNome: " + peca.getNome()
            + "\nEstoque: " + peca.getEstoque());
        }

        System.out.println("Escolha a Peça por ID: ");
        escolhaPec = SC.nextInt();
        SC.nextLine();

        System.out.println("Selecione a quantidade necessária do estoque");
        estoque = SC.nextDouble();

        //Procurar peça por ID
        try 
        {
            ServicePeca.buscarPorId(escolhaOrd, estoque);
        } 
        catch (SQLException e) 
        {
            System.err.println(e);
        }

        //Chamar service para tratar os valores necessários para associar as ordens
        String response = ServiceOrdemPeca.serviceAssociarOrdem(escolhaOrd, escolhaPec, estoque);

        //Resposta da service de sucesso ou fracasso
        System.out.println(response);
        
        returnToMain.retornoInicio();
    }
}