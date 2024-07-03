import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ITCH {
    private static Scanner scanner = new Scanner(System.in);
    public static Carrera[] nuevasCarreras;
    public static String nombre;
    public static String apellido;
    public static String noIdentificacion;
    public static int NIP;

    public static void main (String[]args){
        boolean salir = false;
        CoordinadorCarrera.verificarAdmin();
        while (!salir) {
            System.out.println("Selección del usuario: \n1.- CoordinadorCarrera \n2.- Alumno \n3.- Maestro");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada
            switch (opcion) {
                case 1:
                    opcionesAdmin();
                    break;
                case 2:
               //     opcionesAlumno();
                    break;
                case 3:
                //    opcionesMaestro();
                    break;
                case 4: 
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
            }
        }
    }
    public static void opcionesAdmin(){
        boolean salir = false;
        while (!salir) {
            System.out.println("Opciones de administrador: \n1.- Agregar alumnos \n2.- Agregar maestros \n3.- Dar de baja alumno \n4.- Dar de baja maestro \n5.- Crear carrera\n6.- Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada
            
            switch (opcion) {
                case 1:
                    agregarAlumnos();
                    break;
                case 2:
                 //   agregarMaestros();
                    break;
                case 3:
                  //  eliminarAlumnos();
                    break;
                case 4: 
                  //  eliminarMestro();
                case 5:
                    crearCarerra();
                case 6:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
            }
        }
    }
    public static void crearAdmin(){
        String nombreArchivo = "datosCoordinadorCarrera.dat";
        leerPersonas();
        String cargo = leerCadena("Ingrese su cargo", "Error: solo se aceptan letras");
        NIP = Persona.verificarNIP("Ingrese su NIP");
        CoordinadorCarrera coordinadorCarrera = new CoordinadorCarrera(nombre, apellido, noIdentificacion, NIP, cargo);
        ArchivoObjetos datos = new ArchivoObjetos(".\\CarpetaCoordinadorCarrera", nombreArchivo);
        datos.escribirObjeto(coordinadorCarrera);
        datos.cerrarArchivo();
        ArchivoObjetos.eliminarArchivo(".\\", "datosCoordinadorCarrera.dat");
    }
    public static void opcionesAlumno(){
        boolean salir = false;
        while (!salir) {
            System.out.println("Opciones de coordinador de carrera: \n1.- Agregar alumnos \n2.- Agregar maestros \n3.- Dar de baja alumno \n4.- Dar de baja maestro \n5.- Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada
            
            switch (opcion) {
                case 1:
                  //  agregarAlumnos();
                    break;
                case 2:
                   // agregarMaestros();
                    break;
                case 3:
                    //eliminarAlumnos();
                    break;
                case 4:
                    //eliminarMaestros();
                case 5: 
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
            }
        }
    }
    public static void opcionesMaestro(){
        boolean salir = false;
        while (!salir) {
            System.out.println("Opciones de maestro: \n1.- Agregar alumnos \n2.- Agregar maestros \n3.- Dar de baja alumno \n4.- Dar de baja maestro \n5.- Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada
            
            switch (opcion) {
                case 1:
                //    agregarAlumnos();
                    break;
                case 2:
                //    agregarMaestros();
                    break;
                case 3:
                //    eliminarAlumnos();
                    break;
                case 4: 
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
            }
        }
    }
    public static void leerPersonas(){
        String mensaje = "Los nombres no pueden contener numeros";
        nombre=leerCadena("Ingrese el nombre", mensaje);
        apellido=leerCadena("Ingrese el apellido", mensaje);
        leerEntero("Ingrese el numero de control");
       // leerEntero(nombre = scanner.nextLine(), 0, int.class)
    }
    public static String leerCadena(String mensaje, String mensajeError) {
        while (true) {
            System.out.println(mensaje);
            String input = scanner.nextLine();
            if (!contieneNumeros(input, mensajeError)) {
                return input;
            }
        }
    }
    
    public static int leerEntero(String mensaje) {
        while (true) {
            System.out.println(mensaje);
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número entero válido");
            }
        }
    }
    public static float leerFlotante(String mensaje, float min, float max) {
        while (true) {
            try {
                System.out.println(mensaje);
                float valor = scanner.nextFloat();
                if (valor >= min && valor <= max) {
                    scanner.nextLine(); // Consumir el salto de línea
                    return valor;
                } else {
                    System.out.printf("Error: El valor debe estar entre %.1f y %.1f\n", min, max);
                }
            } catch (InputMismatchException exc) {
                System.out.println("Error, no se puede asignar valores diferentes a números.");
                scanner.nextLine(); // Limpiar el buffer del scanner
            }
        }
    }
    public static boolean contieneNumeros(String cadena, String mensajeError) {
        for (char c : cadena.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
        //System.out.println(mensajeError);
    }
public static void agregarAlumnos() {
    // NIP generico que se cambia al ingresar por primera vez
    int nipGenerico = 0000;
    Scanner scanner = new Scanner(System.in);
    System.out.println("CREACION DE LOS ALUMNOS");
    System.out.println("------------------------------------------------");
    leerPersonas();
    // Mostrar las carreras disponibles y permitir al usuario seleccionar una
    System.out.println("\n--------------Carreras Disponibles--------------");
    List<Carrera> listaCarreras = ArchivoObjetos.leerArchivoCarrera(".\\Actividades\\Carreras.dat");
    for (int inicioMC = 0; inicioMC <= listaCarreras.size(); inicioMC++) {
        System.out.println((inicioMC + 1) + ". " + listaCarreras.get(inicioMC).getNombreCarrera());
    }
    System.out.println("------------------------------------------------\n");
    System.out.println("\nSeleccione una Carrera:");
    int seleccion = scanner.nextInt();
    Carrera carreraSeleccionada = listaCarreras.get(seleccion - 1);
    System.out.println("Carrera seleccionada: " + carreraSeleccionada.getNombreCarrera());

    // Fin de seleccionar la carrera
    
    // Mostrar las opciones disponibles al usuario de los estados del alumno
    System.out.println("\n--------------Estados disponibles para el alumno--------------");
    for (Alumno.Estado estadoAlumno : Alumno.Estado.values()) {
        System.out.println((estadoAlumno.ordinal() + 1) + ". " + estadoAlumno.name());
    }
    System.out.println("--------------------------------------------------------------\n");
    System.out.println("Selecciona el estado del alumno");
    // Leer la entrada del usuario
    int opcionEstatusAlumno = scanner.nextInt();
    scanner.nextLine(); // Consumir el salto de línea
    // Obtener el tipo de documento seleccionado
    Alumno.Estado tipoSeleccionado = Alumno.Estado.values()[opcionEstatusAlumno - 1];
    
    // Usar el tipo de estado seleccionado
    System.out.println("Has seleccionado: " + tipoSeleccionado);
    
    // Fin de seleccionar el estado del alumno
    // Crear un nuevo alumno y asignarle la carrera seleccionada
    Alumno nuevoAlumno = new Alumno(nombre, apellido, noIdentificacion, nipGenerico, tipoSeleccionado, carreraSeleccionada);
    String nombreArchivo = "Datos de " + nuevoAlumno.getNombre() + ".dat";
    ArchivoObjetos datos = new ArchivoObjetos(".\\CarpetaAlumnos\\Documentos de " + nuevoAlumno.getNoIdentificacion() + " " + nuevoAlumno.getCarreraPertenece(), nombreArchivo);
    datos.escribirObjeto(nuevoAlumno);
    datos.cerrarArchivo();
    
    System.out.println("Alumno agregado correctamente.\n");
}
public static void crearCarerra(){
        System.out.println("-----------------------------------------------------------\n");
        String mensaje = "\"Error: solo se aceptan letras\"";
        String nombreCarrera = leerCadena("Ingrese el nombre de la carrera a cursar", mensaje);
        String idCarerra = leerCadena("Ingrese el id de la carrera a cursar", mensaje);
        Carrera  carrera = new Carrera(idCarerra, nombreCarrera);
        ArchivoObjetos datos = new ArchivoObjetos(".\\Actividades", "Carreras.dat");
        datos.escribirCarrera(carrera);
        datos.cerrarArchivo();
        
        System.out.println("Carrera creada correctamente.\n");
    }
public static void agregarMaestro(){
    
}
}

