package org.example.service;

import org.example.model.Peca;
import org.example.repository.PecaDAO;

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

        var peca = new Peca(nome, estoque);
        //Exec. 3 Validar duplicidade
        try
        {
            Nexiste = PecaDAO.pecaExiste(peca);
        }
        catch

        return "";
    }
}
