/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controllers.Login;
import java.util.ArrayList;

/**
 *
 * @author hemilio
 */
public class Secretaria extends Usuario implements Login{
    private String tipo;

    public Secretaria() {
        
    }

    public Secretaria(String login, String senha) {
        super(login, senha);
        setTipo("secretaria");
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean login(ArrayList<Medico> medico, String login, String senha, int a) {
        return false;
    }

    @Override
    public boolean login(ArrayList<Secretaria> secretaria, String login, String senha, double a) {
        for (int i = 0; i < secretaria.size(); i++) {
            if(login.equals(secretaria.get(i).getLogin()) && senha.equals(secretaria.get(i).getSenha()))
                return true;
        }
        return false;
    }
    
    
}
