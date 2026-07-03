package org.example.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.example.model.Maquina;

public class ViewCadastrarOrdem 
{
    static Scanner SC = new Scanner(System.in);

    public static void cadastrarOrdemView()
    {
        List<Maquina> maquinas = new ArrayList<>();

        System.out.println("=========================");
        System.out.println("Criar Ordem de Manutenção");
        System.out.println("=========================");

        System.out.println("Aperte qualquer tecla para começar a listagem de máquinas: ");
        SC.nextLine();

        try
        {
            maquinas = Service
        }
    }
}
