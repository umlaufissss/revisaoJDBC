package org.example.util;

import java.util.Scanner;

public class ScannerSingleton 
{

    private static Scanner 
    private ScannerSingleton() {}

    public static Scanner getInstance()
    {
        if(uniqueInstance == null)
        {
            uniqueInstance
        }
    }
}
