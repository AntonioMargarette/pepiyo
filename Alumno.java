
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Alumno extends Persona
{

    //Variable de tipo Carrera para guardar la carrera a la que pertenece
    Carrera perteneceCarrera;
    //Opcion de los tipos de Estados de los alumnos
    public enum Estado{
                        Activo, 
                        BajaTemporal,
                        BajaDefinitiva,
                        Egresado
                                        };
    
    private Estado estadoEscuela;

    public Alumno(String nombre, String apellido, String noIdentificacion, int NIP, Estado estadoEscuela, Carrera perteneceCarrera) {
        super(nombre, apellido, noIdentificacion, NIP);
        this.estadoEscuela = estadoEscuela;
        this.perteneceCarrera = perteneceCarrera;
    }
    
    public Estado getEstadoEscuela(){
        return estadoEscuela;
    }
    
    public void setEstadoEscuela(Estado estadoEscuela){
        this.estadoEscuela = estadoEscuela;
    }
    
    public Carrera getCarreraPertenece(){
        return perteneceCarrera;
    }
    
    public void setCarreraPertenece(Carrera perteneceCarrera)
    {
        this.perteneceCarrera = perteneceCarrera;
    }
    @Override
    public String toString(){
        String datos;
        datos = "\n*****************************DATOS DEL ALUMNO*****************************";
        datos += "\n\nNombre: "+ nombre + " " + apellido ;
        datos += "\nNumero de control: " + noIdentificacion;
        datos += "\nEstado escolar: " + estadoEscuela;
        datos += "\nCarrera: " + perteneceCarrera.getNombreCarrera();
        datos += "\n**************************************************************************";
        return datos;
    }

  //  public void imprimirCreditos(){
   //     System.out.println("\nCreditos de: " + noIdentificacion );
  //      for (int i = 0; i < creditosGanados.length; i++) {
    //        //CreditosComplementarios mostrarCreditos = getCreditos()[i];
    //        CreditosComplementarios mostrarCreditos = creditosGanados[i];
         //   if (mostrarCreditos != null) { // Verificar si mostrarCreditos no es null
       //         System.out.println("\nCredito " + (i + 1));
       //         
       //         System.out.println("---------------------------------------------------------------------------------------------------");
       //         System.out.printf("| %-17s | %-21s | %-17s | %-17s |\n", "Fecha de acreditación", "Nombre de la actividad", "Tipo de actividad", "Cantidad de creditos");   
      //          System.out.println("---------------------------------------------------------------------------------------------------");
      //          System.out.printf("| %-21s | %-22s | %-17s | %-20f |\n",mostrarCreditos.getCalendarioAsString(),
     //           mostrarCreditos.getNombreActividad(), mostrarCreditos.getTipoActividad(),mostrarCreditos.getNumeroCreditos());
     //       }
     //   }
       // System.out.println("---------------------------------------------------------------------------------------------------");
  //  }
   // public void checarCreditosEgresado(){
     //   if (estadoEscuela == Alumno.Estado.Egresado && totalCreditos < 5){
     //       System.out.println("Opcion invalida, el usuario no puede egresar sin los 5 creditos correspondientes");
     //   }
 //   }

    public void crearDirectorio () {
        //Instanciamos la clase file con la ruta del fichero
        File miDirectorio = new File(".\\CarpetaAlumnos\\Documentos de " + getNoIdentificacion() +" " + perteneceCarrera.getNombreCarrera());   
        //Creamos el directorio
        miDirectorio.mkdir();
        System.out.println("Directorio creado satisfactoriamente");
    }

    public void guardarArchivo() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG & PNG images and PDF archives", "jpg", "png", "pdf");
            fileChooser.setFileFilter(filtro);
            int userSelection = fileChooser.showOpenDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File archivoSeleccionado = fileChooser.getSelectedFile();
                // Crear la ruta de destino
                String destinoRuta = ".\\CarpetaAlumnos\\Documentos de " + getNoIdentificacion() + " " + perteneceCarrera.getNombreCarrera();
                File carpetaDestino = new File(destinoRuta);
                
                // Crear la carpeta si no existe
                if (!carpetaDestino.exists()) {
                    carpetaDestino.mkdirs();
                }
                File archivoDestino = new File(carpetaDestino, archivoSeleccionado.getName());
                // Copiar el archivo seleccionado al destino
                try (FileInputStream fis = new FileInputStream(archivoSeleccionado);
                    FileOutputStream fos = new FileOutputStream(archivoDestino)) {
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = fis.read(buffer)) > 0) {
                        fos.write(buffer, 0, length);
                    }
                    JOptionPane.showMessageDialog(null, "El archivo se ha subido exitosamente", "Información", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al subir el archivo: " + ex.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
}
