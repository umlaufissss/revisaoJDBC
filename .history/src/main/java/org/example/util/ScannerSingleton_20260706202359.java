package org.example.util;

import java.util.Scanner;

public class ScannerSingleton 
{
    //Criação de Singleton para Scanner
    private static Scanner uniqueInstance;

    private ScannerSingleton() {}

    public static Scanner getInstance()
    {
        if(uniqueInstance == null)
        {
            uniqueInstance = new Scanner(System.in);
        }
        return uniqueInstance;
    }

    static Scanner SC = ScannerSingleton.getInstance();

    //Scanner para variaveis double
    public double scanDouble()
    {
        try
        {
            double num = SC.nextDouble();
            return num;
        }
        catch(Exception e)
        {
            SC.nextLine();
            throw e;
        }
    }

    //Scanner para variaveis int
    public int scanInt()
    {
        try
        {
            int num = SC.nextInt();
            return num;
        }
        catch(Exception e)
        {
            SC.nextLine();
            throw e;
        }
    }

    //Scanner para variaveis String
    public String scan
}
