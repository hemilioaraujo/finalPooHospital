/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.Consultas;
import models.DAOConsulta;
import models.Pacientes;
import java.sql.ResultSet;


/**
 *
 * @author hemilio
 */
public class ControllerConsulta {
    Consultas c;
    ResultSet rs = null;

    public ControllerConsulta(String data, String cpfPaciente) {
        this.c = new Consultas(data, cpfPaciente);
    }

    public ControllerConsulta(int id) {
        this.c = new Consultas(id);
    }
    
    public ControllerConsulta(int id, String data){
        this.c = new Consultas(id, data);
    }
    
    
    
    public void salvar(){
        DAOConsulta dc = new DAOConsulta();
        dc.salvar(c);
    }
    
    public ResultSet buscar(){
        DAOConsulta dc = new DAOConsulta();
        rs = dc.buscar(c);
        
        return rs;
    }
    
    public void atualizar(){
        DAOConsulta dc = new DAOConsulta();
        dc.atualizar(c);
    }
    
    public void excluir(){
        DAOConsulta dc = new DAOConsulta();
        dc.excluir(c);
    }
}
