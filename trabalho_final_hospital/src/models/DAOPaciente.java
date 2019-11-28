/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author hemilio
 */
public class DAOPaciente {
    public static final String driver = "com.mysql.cj.jdbc.Driver";
    //IP do banco, porta e o nome do banco
    public static final String url = "jdbc:mysql://localhost:3306/bdaula";
    public static final String user = "root";
    public static final String psswd = "u2kW.#dp";
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public static java.sql.Connection conectar() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, psswd);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
    public static void fecharConexao(java.sql.Connection con) {
        if(con != null) {
            try {
                con.close();
            }catch(SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    
    public void salvar(Pacientes p) {
        String sql = "insert into paciente(nome, cpf, nascimento, sexo) "
                + "values(?,?,?,?)";
        
        conexao = this.conectar();
        
        try{
            pst = conexao.prepareStatement(sql);
            pst.setString(1, p.getNome());
            pst.setString(2, p.getCpf());
            pst.setString(3, p.getNascimento());
            pst.setString(4, p.getSexo());
            int adicionado = pst.executeUpdate();
            
            if(adicionado > 0)
                JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!");
            else
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar!");
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }finally {
            DAOPaciente.fecharConexao(conexao);
        }
    }
    
    public void atualizar(Pacientes p){
        String sql = "update paciente "
                + "set nome = ?, nascimento = ?, sexo = ?"
                + "where cpf = ?";;
        
        conexao = this.conectar();
        
        try{
            pst = conexao.prepareStatement(sql);
            pst.setString(1, p.getNome());
            pst.setString(2, p.getNascimento());
            pst.setString(3, p.getSexo());
            pst.setString(4, p.getCpf());
            int adicionado = pst.executeUpdate();
            
            if(adicionado > 0)
                JOptionPane.showMessageDialog(null, "Paciente alterado com sucesso!");
            else
                JOptionPane.showMessageDialog(null, "Erro ao salvar!");
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }finally {
            DAOPaciente.fecharConexao(conexao);
        }
    }
    
    public void excluir(Pacientes p){
        String sql = "delete from paciente "
                + "where cpf = ?";
        
        conexao = this.conectar();
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, p.getCpf());
            int adicionado = pst.executeUpdate();
            
            if(adicionado > 0)
                JOptionPane.showMessageDialog(null, "Deletado paciente!");
            else
                JOptionPane.showMessageDialog(null, "Erro ao deletar");
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }finally {
            DAOPaciente.fecharConexao(conexao);
        }
        
    }
    
    public ResultSet buscar(Pacientes p){
        String sql = "select * from paciente where cpf = ?";
        
        conexao = this.conectar();
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, p.getCpf());

            rs = pst.executeQuery();
            
            return rs;
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a busca!");
            
            return null;
        }
    }
    
    public ResultSet buscarConsultas(Pacientes p){
        String sql = "SELECT consulta.id, consulta.dataConsulta, paciente.nome "
                + "FROM paciente INNER JOIN consulta on paciente.cpf = consulta.cpfPaciente "
                + "and cpf = ?";
        
        conexao = this.conectar();
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, p.getCpf());

            rs = pst.executeQuery();
            
            return rs;
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a busca!");
            
            return null;
        }
    }
}
