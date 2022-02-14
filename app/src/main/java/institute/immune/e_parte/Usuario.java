package institute.immune.e_parte;

public class Usuario {
    int id;
    String nombre;
    String correo;

    Usuario(int i, String n, String c){
        id = i;
        nombre = n;
        correo = c;
    }

    @Override
    public String toString() {

        return nombre + correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }
}
