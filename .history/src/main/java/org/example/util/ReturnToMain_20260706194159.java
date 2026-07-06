package org.example.util;

import org.example.Main;

public class ReturnToMain 
{

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

    public static void cls()
    {
        for(int i = 0; i <= 50; i++)
        {
            System.out.println("\n");
        }
    }

    public static void retornoInicio()
    {
        cls();

        try 
        {
            Thread.sleep(3000);
        } 
        catch (InterruptedException e) 
        {
            Thread.currentThread().interrupt();
        }

        Main.inicio();
    }
}
