package clases;

// definicion de la clase
public class Persona {
    // atributos
    private String nombres;
    private String apellidos;
    
    // constructor
    public Persona() {
    }

    // geter nombres
    public String getNombres() {
        return nombres;
    }
    
    // seter nombres
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    // geter apellidos
    public String getApellidos() {
        return apellidos;
    }

    // seter apellidos
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
