
package models;

/**
 *
 * @author hemilio
 */
public class Consultas {
    private int id;
    private String data;
    private String cpfPaciente;

    public Consultas(String data, String cpfPaciente) {
        this.data = data;
        this.cpfPaciente = cpfPaciente;
    }

    public Consultas(int id) {
        this.id = id;
    }
    
    public Consultas(int id, String data){
        this.id = id;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
        
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }
}
