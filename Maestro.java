public class Maestro extends Persona {
    private Carrera materias;

    public Maestro(String nombre, String apellido, String noIdentificacion, int NIP, Carrera materias) {
        super(nombre, apellido, noIdentificacion, NIP);
    }
    public Carrera getMaterias() {
        return materias;
    }
    public void setMaterias(Carrera materias) {
        this.materias = materias;
    }
    @Override
    public String toString() {
        String datos;
        datos = "\n*****************************DATOS DEL ALUMNO*****************************";
        datos += "\n\nNombre: "+ nombre + " " + apellido ;
        datos += "\nNumero de control: " + noIdentificacion;
        datos += "\nMaterias a repartir: " + materias;
        datos += "\n**************************************************************************";
        return datos;
    }
}