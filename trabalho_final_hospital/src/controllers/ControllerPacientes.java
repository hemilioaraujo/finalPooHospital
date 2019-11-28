
package controllers;

import java.sql.ResultSet;
import models.DAOPaciente;
import models.Pacientes;

/**
 *
 * @author hemilio
 */
public class ControllerPacientes {
    Pacientes p;
    ResultSet rs = null;
    
    public ControllerPacientes(String nome, String cpf, String nascimento, String sexo) {
        p = new Pacientes(nome, cpf, nascimento,sexo);
    }
    
    public void salvar() {
        DAOPaciente dp = new DAOPaciente();
        dp.salvar(p);
    }
    
    public void atualizar(){
        DAOPaciente dp = new DAOPaciente();
        dp.atualizar(p);
    }
    
    public void excluir(){
        DAOPaciente dp = new DAOPaciente();
        dp.excluir(p);
    }
    
    public ResultSet buscar(){
        DAOPaciente dp = new DAOPaciente();
        rs = dp.buscar(p);
        
        return rs;
    }
    
    public ResultSet buscarConsultas(){
        DAOPaciente dp = new DAOPaciente();
        rs = dp.buscarConsultas(p);
        
        return rs;
    }
}
