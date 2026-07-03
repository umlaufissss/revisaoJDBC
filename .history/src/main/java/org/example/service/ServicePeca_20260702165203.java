package org.example.service;

public class ServicePeca 
{
    public static String serviceCadastroPeca(String nome, double estoque)
    {
        boolean Nexiste = false;
        //Exec. 3 Validar nome
        if(nome.isBlank() || nome.isEmpty())
        {
            return "Nome é obrigatório";
        }

        //Exec. 3 Validar estoque
        if(estoque < 0)
        {
            return "Estoque deve conter um valor positivo";
        }

        //Exec. 3 Validar duplicidade
        try
        {
            Nexiste = Pec
        }

        return "";
    }
}
