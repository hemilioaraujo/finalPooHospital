
package models;

import controllers.Login;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Medico extends Usuario implements Login {
    private String tipo;

    public Medico() {
    }

    public Medico(String login, String senha) {
        super(login, senha);
        setTipo("Medico");
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean login(ArrayList<Medico> medico, String login, String senha, int a) {
        for (int i = 0; i < medico.size(); i++) {
            if(login.equals(medico.get(i).getLogin()) && senha.equals(medico.get(i).getSenha()))
                return true;
        }
        return false;
    }

    @Override
    public boolean login(ArrayList<Secretaria> secretaria, String login, String senha, double a) {
        return false;
    }
    
    
    
    
    
}
