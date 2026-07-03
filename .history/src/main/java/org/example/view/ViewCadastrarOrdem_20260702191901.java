package org.example.view;

import java.util.List;
import java.util.Scanner;

import org.example.model.Maquina;
import org.example.model.Tecnico;
import org.example.service.ServiceMaquina;
import org.example.service.ServiceOrdem;
import org.example.service.ServiceTecnico;

import com.google.protobuf.Service;

public class ViewCadastrarOrdem 
{
    static Scanner SC = new Scanner(System.in);

    public static void cadastrarOrdemView()
    {
        List<Maquina> maquinas;
        List<Tecnico> tecnicos;
        int escolhaMaq, escolhaTec, escolha;

        System.out.println("=========================");
        System.out.println("Criar Ordem de Manutenção");
        System.out.println("=========================");

        System.out.println("Aperte qualquer tecla para começar a listagem de máquinas: ");
        SC.nextLine();

        maquinas = ServiceMaquina.listarOperacionaisService();

        for(Maquina maquina : maquinas)
        {
            System.out.println("============== ID:" + maquina.getId()+ "\nNome: " + maquina.getNome() + "\nSetor: " + maquina.getSetor());
        }

        System.out.println("Escolha a máquina por ID: ");
        escolhaMaq = SC.nextInt();
        SC.nextLine();
        escolha = escolhaMaq;

        try 
        {
            escolhaMaq = maquinas.indexOf(escolhaMaq)
        } catch (NullPointerException e) 
        {
            // TODO: handle exception
        }
        
        System.out.println("Aperte qualquer tecla para começar a listagem de técnicos: ");
        SC.nextLine();

        tecnicos = ServiceTecnico.listarTodos();

        for(Tecnico tecnico : tecnicos)
        {
            System.out.println("============== ID: " + tecnico.getId()+ "\nNome: " + tecnico.getNome() + "\nEspecialidade: " + tecnico.getEspecialidade());
        }

        System.out.println("Escolha o técnico por ID: ");
        escolhaTec = SC.nextInt();
        SC.nextLine();

        if(tecnicos.get(escolhaTec).getId() == escolhaTec)
        {
            System.out.println("Técnico não existe");
        }

        String response = ServiceOrdem.cadastrarOrdemService(escolha, escolha)
    }
}
