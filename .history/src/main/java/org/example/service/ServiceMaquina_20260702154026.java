package org.example.service;

public class ServiceMaquina 
{
    public static String serviceCadastrarMaquina(String nome, String setor)
    {
        //Exec. 3 Nome
        if(nome.isBlank() || nome.isEmpty())
        {
            return "Nome é obrigatório";
        }
        //Exec. 3 Setor
        else if(setor.isBlank() || setor.isEmpty())
        {
            return "Setor é obrigatório"
        }

        return "";
    }
}
