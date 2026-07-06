package org.example.util;

import java.util.Scanner;

public class ScannerSingleton 
{
    private static Scanner uniqueInstance;

    private ScannerSingleton() {}

    public static Scanner getInstance()
    {
        if(uniqueInstance == null)
        {
            uniqueInstance = new Scanner(System.in.)
        }
    }
}
