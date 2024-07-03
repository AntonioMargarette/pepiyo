
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;
public abstract class Persona implements Serializable {
    protected String nombre;
    protected String apellido;
    protected String noIdentificacion;
    protected int NIP;
    public Persona(String nombre, String apellido, String noIdentificacion, int NIP) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.noIdentificacion = noIdentificacion;
        this.NIP = NIP;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getNoIdentificacion() {
        return noIdentificacion;
    }
    public void setNoIdentificacion(String noIdentificacion) {
        this.noIdentificacion=noIdentificacion;
    }
    public int getNIP() {
        return NIP;
    }
    public void setNIP(int NIP) {
        this.NIP = NIP;
    }
    public static int verificarNIP(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(mensaje);
                int nip = scanner.nextInt();
                scanner.nextLine();    
                if (String.valueOf(nip).length() == 4) {
                    scanner.close();
                    return nip;   
                } else {
                    throw new IllegalArgumentException("NIP no válido. Debe ser un número de 4 dígitos.\n");
                }
            } catch (InputMismatchException exc) {
                System.out.println("Error, el NIP debe ser un número.");
            } catch (IllegalArgumentException exc) {
                System.out.print(exc.getMessage());
            }
        }
        
    }
    public abstract String toString();
}
