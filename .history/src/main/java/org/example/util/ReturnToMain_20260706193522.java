package org.example.util;

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
        catch (N e) 
        {

        }
    }
}
