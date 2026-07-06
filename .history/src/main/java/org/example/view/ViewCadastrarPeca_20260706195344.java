package org.example.view;

import java.util.Scanner;

import org.example.service.ServicePeca;
import org.example.util.ReturnToMain;
import org.example.util.ScannerSingleton;

public class ViewCadastrarPeca 
{
    //Singletons da Pasta Util
    static Scanner SC = ScannerSingleton.getInstance();
    static ReturnToMain returnToMain = ReturnToMain.getIntance();

    public static void cadastrarPecaView()
    {
        String nome;
        double estoque;
        //Cabeçalho
        System.out.println("==============");
        System.out.println("Cadastrar Peça");
        System.out.println("==============");

        //Requere os valores necessários para cadastrar uma peça
        System.out.println("Digite o nome da peça: ");
        nome = SC.nextLine();

        System.out.println("Digite a quantidade em estoque: ");
        estoque = SC.nextDouble();
        SC.nextLine();

        //Chamar service que irá tratar os valores para cadastrar a peça
        String response = ServicePeca.serviceCadastroPeca(nome, estoque);

        //Resposta da service de sucesso ou fracasso
        System.out.println(response);

    }
}
