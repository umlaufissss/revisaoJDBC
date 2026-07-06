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

    static Scanner SC = Scanner.getInstance();
    
    public static double scanDouble()
    {
        try
        {
            double num = SC
        }
    }
}
