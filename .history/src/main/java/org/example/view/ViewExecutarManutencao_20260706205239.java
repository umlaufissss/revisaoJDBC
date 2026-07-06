package org.example.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.example.model.OrdemManutencao;
import org.example.model.OrdemPeca;
import org.example.model.Peca;
import org.example.service.ServiceOrdem;
import org.example.service.ServicePeca;
import org.example.util.ReturnToMain;
import org.example.util.ScannerSingleton;

public class ViewExecutarManutencao 
{
    //Singletons da Pasta Util
    static Scanner SC = ScannerSingleton.getInstance();
    static ReturnToMain returnToMain = ReturnToMain.getIntance();

    public static void executarManutencaoView()
    {
        List<OrdemManutencao> ordens;
        Map<Peca, OrdemPeca> estoque;
        String response = "Não há correspondente";
        
        System.out.println("===================");
        System.out.println("Executar Manutençaõ");
        System.out.println("===================");

        System.out.println("Aperte qualquer tecla para começar a listagem de ordens de manutenção pendentes: ");
        SC.nextLine();

        //Chamar service que irá apenas retornar ordens pendentes
        ordens = ServiceOrdem.listarPendencias();

        if(ordens())
        {
            return;
        }

        //Listagem de ordens pendentes
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

        //Chamando service para verificação e status atual do estoque...
        System.out.println("Verificando o estoque das peças...");
        estoque = ServicePeca.verificarEstoque();

        //Listagem de ordens de peça
        System.out.println("====================");
        System.out.println("Alteração de estoque");
        System.out.println("====================");
        for (Map.Entry<Peca, OrdemPeca> ordem : estoque.entrySet()) {
            
            System.out.println("============== ID da Ordem de Manutenção:" + ordem.getValue().getIdOrdem()
            + "\nID da Peça: " + ordem.getKey().getId()
            + "\nNome: " + ordem.getKey().getNome() 
            + "\nEstoque: " + ordem.getKey().getEstoque() 
            + "\nQuantidade: " + ordem.getValue().getQuantidade()
            + "\n");
            
            //Chamar método para verificar que as ordens serão fechadas
            try
            {
                response = ServicePeca.estoqueSuficiente(ordem.getKey(), ordem.getValue().getQuantidade());
            }
            catch(SQLException e)
            {
                System.err.println(e);
            }
            
            //Resposta da service de sucesso ou fracasso
            System.out.println("Status do estoque: " + response + "\n");

            returnToMain.retornoInicio();
        }
    }
}
