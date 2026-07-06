package org.example.util;

import org.example.Main;

public class ReturnToMain 
{

    //Criação de Singleton para retornar à main
    private static ReturnToMain returnToMain;

    private ReturnToMain() {}
    
    public static ReturnToMain getIntance()
    {
        if(returnToMain == null)
        {
            returnToMain = new ReturnToMain();
        }
        return returnToMain;
    }

    //Limpar código
    public static void cls()
    {
        for(int i = 0; i <= 50; i++)
        {
            System.out.println("\n");
        }
    }

    //
    public static void retornoInicio()
    {
        Main inicio = Main.getIntance();
        cls();

        try 
        {
            Thread.sleep(3000);
        } 
        catch (InterruptedException e) 
        {
            Thread.currentThread().interrupt();
        }

        inicio.inicio();
    }
}
