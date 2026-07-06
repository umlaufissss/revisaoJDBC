package org.example.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.example.model.Maquina;
import org.example.model.Tecnico;
import org.example.service.ServiceMaquina;
import org.example.service.ServiceOrdem;
import org.example.service.ServiceTecnico;
import org.example.util.ReturnToMain;
import org.example.util.ScannerSingleton;

public class ViewCadastrarOrdem 
{
    //Singletons da Pasta Util
    static Scanner SC = ScannerSingleton.getInstance();
    static ReturnToMain returnToMain = ReturnToMain.getIntance();

    public static void cadastrarOrdemView()
    {
        List<Maquina> maquinas;
        List<Tecnico> tecnicos;
        int escolhaMaq, escolhaTec;
        boolean existe = false;

        //Cabeçalho
        System.out.println("=========================");
        System.out.println("Criar Ordem de Manutenção");
        System.out.println("=========================");

        System.out.println("Aperte qualquer tecla para começar a listagem de máquinas: ");
        SC.nextLine();

        //Listagem de máquinas operacionais
        maquinas = ServiceMaquina.listarOperacionaisService();

        if(maquinas.isEmpty())
        {
            return;
        }

        for(Maquina maquina : maquinas)
        {
            System.out.println("============== ID:" + maquina.getId()
            + "\nNome: " + maquina.getNome() 
            + "\nSetor: " + maquina.getSetor());
        }

        System.out.println("Escolha a máquina por ID: ");
        escolhaMaq = SC.nextInt();
        SC.nextLine();

        //Procurar máquina por ID
        try
        {
            existe = ServiceMaquina.buscarPorId(escolhaMaq);
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }
        
        if(!existe)
        {
            return;
        }
        
        System.out.println("Aperte qualquer tecla para começar a listagem de técnicos: ");
        SC.nextLine();

        //Listagem de técnicos
        tecnicos = ServiceTecnico.listarTodos();

        for(Tecnico tecnico : tecnicos)
        {
            System.out.println("============== ID: " + tecnico.getId()+ "\nNome: " + tecnico.getNome() + "\nEspecialidade: " + tecnico.getEspecialidade());
        }

        System.out.println("Escolha o técnico por ID: ");
        escolhaTec = SC.nextInt();
        SC.nextLine();

        //Procurar técnico por ID
        try
        {
            existe = ServiceTecnico.buscarPorId(escolhaTec);
        }
        catch(SQLException e)
        {
            System.err.println(e);
        }

        if(!existe)
        {
            return;
        }
        //Chamar método para tratar os valores dados para a ordem
        String response = ServiceOrdem.cadastrarOrdemService(escolhaMaq, escolhaTec);
        //Resposta da service de sucesso ou fracasso
        System.out.println(response);

        returnToMain.retornoInicio();
    }
}
