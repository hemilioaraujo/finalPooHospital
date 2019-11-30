/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.ArrayList;
import models.Medico;
import models.Secretaria;

/**
 *
 * @author hemilio
 */
public interface Login {
    public boolean login(ArrayList<Medico> medico, String login, String senha, int a);
    public boolean login(ArrayList<Secretaria> secretaria, String login, String senha, double a);
}
