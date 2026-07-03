package org.example.service;

public class ServicePeca 
{
    serviceCadastroPeca(String nome, double estoque)
    {
        //Exec. 3 Validar nome
        if(nome.isBlank() || nome.isEmpty())
        {
            return "Nome é obrigatório";
        }
    }
}
