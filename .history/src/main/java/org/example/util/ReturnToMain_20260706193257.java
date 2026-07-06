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
        
    }
}
