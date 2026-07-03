package org.example.service;

import org.example.model.Maquina;

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
            return "Setor é obrigatório";
        }
        else
        {
            var Maquina = new Ma
        }

        return "";
    }
}
