import java.io.File;

public class CoordinadorCarrera extends Persona {
String cargo;
    public CoordinadorCarrera(String nombre, String apellido, String noIdentificacion, int NIP, String cargo) {
        super(nombre, apellido, noIdentificacion, NIP);
        this.cargo = cargo;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    @Override
    public String toString(){
        String datos;
        datos = "\n*****************************DATOS DEL ADMINISTRADOR*****************************";
        datos += "\n\nNombre: "+ nombre + " " + apellido ;
        datos += "\nNumero de control: " + noIdentificacion;
        datos += "\nCargo : " + cargo;
        datos += "\n********************************************************************************";
        return datos;
    }
    public void crearDirectorio () {
        //Instanciamos la clase file con la ruta del fichero
        File miDirectorio = new File(".\\CarpetaAdministrador\\Documentos del administrador ");   
        //Creamos el directorio
        miDirectorio.mkdir();
        System.out.println("Directorio creado satisfactoriamente");
    }
    public static void verificarAdmin(){
        String rutaAdmin = ".\\CarpetaAdministrador\\datosAdministrador.dat";
                File archivo = new File(rutaAdmin);
                // Verificar si el archivo no existe
                if (!archivo.exists()) {
                    ITCH.crearAdmin();
                } else {
                    System.out.println("Bienvenido Administrador");
                }
    }
}
