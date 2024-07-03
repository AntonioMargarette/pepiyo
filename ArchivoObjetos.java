import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.io.ObjectInputStream;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;

public class ArchivoObjetos {
    private ObjectOutputStream salida;
    private ObjectInputStream entrada;

    public ArchivoObjetos(String ruta, String nombre) {
        try {
            salida = new ObjectOutputStream(new FileOutputStream(nombre, true));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // Copiar el archivo a la ruta especificada
        copiarArchivo(ruta, nombre);
    }

    private void copiarArchivo(String ruta, String nombre) {
        File carpetaDestino = new File(ruta);
        if (!carpetaDestino.exists()) {
            carpetaDestino.mkdirs();
        }
        File archivoDestino = new File(carpetaDestino, nombre);
        File archivoOrigen = new File(nombre);
        try (FileInputStream fis = new FileInputStream(archivoOrigen);
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

    public void cerrarArchivo() {
        try {
            if (salida != null) {
                salida.close();
            }
            if (entrada != null) {
                entrada.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void abrirArchivoParaLectura(String nombre) {
        try {
            entrada = new ObjectInputStream(new FileInputStream(nombre));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void escribirObjeto(Object obj) {
        try {
            salida.writeObject(obj);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void escribirCarrera(Carrera obj) {
        try {
            salida.writeObject(obj);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void leerDatos() {
        try {
            while (true) {
                Object obj = entrada.readObject();
                System.out.println(obj.toString());
            }
        } catch (EOFException ex) {
            System.out.println("Fin del archivo");
        } catch (ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
        }
    }
    public static boolean eliminarArchivo(String ruta, String nombre) {
        File archivo = new File(ruta, nombre);
        if (archivo.exists()) {
            if (archivo.delete()) {
                System.out.println("El archivo " + nombre + " ha sido eliminado correctamente.");
                return true;
            } else {
                System.out.println("Error: No se pudo eliminar el archivo " + nombre);
                return false;
            }
        } else {
            System.out.println("Error: El archivo " + nombre + " no existe en la ruta especificada.");
            return false;
        }
    }
    public static List<String> leerArchivo(String ruta) throws IOException {
        List<String> elementos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                elementos.add(linea);
            }
        }
        return elementos;
    }
    public static List<Carrera> leerArchivoCarrera(String ruta) {
        List<Carrera> carreras = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Suponiendo que cada línea representa una carrera con campos separados por comas
                String[] datosCarrera = linea.split(","); // Suponiendo que los campos están separados por comas
                // Crear un objeto Carrera con los datos y agregarlo a la lista
                Carrera carrera = new Carrera(datosCarrera[0], datosCarrera[1]);
                carreras.add(carrera);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return carreras;
    }
}

