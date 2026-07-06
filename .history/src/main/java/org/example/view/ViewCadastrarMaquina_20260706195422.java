package org.example.view;

import java.util.Scanner;

import org.example.service.ServiceMaquina;
import org.example.util.ReturnToMain;
import org.example.util.ScannerSingleton;

public class ViewCadastrarMaquina 
{
    //Singletons da Pasta Util
    static Scanner SC = ScannerSingleton.getInstance();
    static ReturnToMain returnToMain = ReturnToMain.getIntance();

    public static void cadastrarMaquinaView()
    {
        String nome, setor;

        //Cabeçalho
        System.out.println("=================");
        System.out.println("Cadastrar Maquina");
        System.out.println("=================");

        //Requere os valores necessários para cadastrar uma máquina
        System.out.println("Digite o nome da máquina: ");
        nome = SC.nextLine();

        System.out.println("Digite o setor da máquina: ");
        setor = SC.nextLine();

        //Chama service que irá tratar os valores para cadastrar a máquina
        String response = ServiceMaquina.serviceCadastrarMaquina(nome, setor);

        //Resposta da service de sucesso ou fracasso
        System.out.println(response);

        returnToMain.retornoInicio();
    }
}
