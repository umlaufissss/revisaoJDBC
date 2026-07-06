package org.example;

import java.util.Scanner;

import org.example.util.ScannerSingleton;
import org.example.view.ViewAssociarPecas;
import org.example.view.ViewCadastrarMaquina;
import org.example.view.ViewCadastrarOrdem;
import org.example.view.ViewCadastrarPeca;
import org.example.view.ViewCadastrarTecnico;
import org.example.view.ViewExecutarManutencao;


public class Main 
{
   static Scanner SC = ScannerSingleton.getInstance();
   
   public static void main() 
   {
      System.out.println("Iniciando sistema...");


      inicio();
   }

   public static void inicio()
   {
      int option;
      //Cabeçalho
      System.out.println("--------------------------------------------------------------");
      System.out.println("                             MENU                             ");
      System.out.println("--------------------------------------------------------------");

      //Opções de views
      System.out.println("[1] - Cadastrar máquina        [2] - Cadastrar técnico        ");
      System.out.println("[3] - Cadastrar peça           [4] - Criar Ordem de Manutenção");
      System.out.println("[5] - Associar Peças à Ordem   [6] - Executar Manutenção      ");
      System.out.println("                               [0] - Sair                     ");
      option = SC.nextInt();
      SC.nextLine();

      switch (option)
      {
         case 1 -> ViewCadastrarMaquina.cadastrarMaquinaView();
         case 2 -> ViewCadastrarTecnico.cadastrarTecnicoView();
         case 3 -> ViewCadastrarPeca.cadastrarPecaView();
         case 4 -> ViewCadastrarOrdem.cadastrarOrdemView();
         case 5 -> ViewAssociarPecas.associarPecasView();
         case 6 -> ViewExecutarManutencao.executarManutencaoView();
         case 0 -> {

            System.out.println("Saindo da aplicação...");
            System.exit(0);
         }
         default -> {
            System.out.println("Aviso! Opção inválida, não há como prosseguir...");
            inicio();
         }
      }
   }

   static private Main inicio;

   private SingletonInicio(){}
}

