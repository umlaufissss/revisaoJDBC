package org.example;


public class Main 
{
   public static void main() 
   {
      System.out.println("Iniciando sistema...");

      inicio();
   }

   public static void inicio()
   {
      //Cabeçalho
      System.out.println("--------------------------------------------------------------");
      System.out.println("                             MENU                             ");
      System.out.println("--------------------------------------------------------------");

      System.out.println("[1] - Cadastrar máquina [2] - Cadastrar técnico");
      System.out.println("[3] - Cadastrar peça [4] - Criar Ordem de Manutenção");
      System.out.println("[5] - Associar Peças à Ordem [6] - Executar Manutenção");
   }
}

