package org.example;

import java.util.Scanner;


public class Main 
{
   static Scanner SC = new Scanner(System.in);
   public static void main() 
   {
      System.out.println("Iniciando sistema...");

      //APLICAR SINGLETON

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
      option = SC.nextInt();
      SC.nextLine();

      switch (option):
      {
         
      }
   }
}

