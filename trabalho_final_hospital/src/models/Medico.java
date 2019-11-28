
package models;

public class Medico extends Usuario {
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
    
    
    
    
    
}
