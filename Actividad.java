import java.util.Calendar;
public class Actividad {
    // variables
    private Calendar fechaRealizacion;
    private Maestro responsable;
    private String organizador;
    private byte creditosObtener;
    private int limiteAlumnos;
    private String nombre;
    
    public Actividad(String nombre, Calendar fechaRealizacion, String organizador, Maestro responsable,
    byte creditosObtener, int limiteAlumnos) {
    this.nombre = nombre;
    this.fechaRealizacion = fechaRealizacion;
    this.organizador = organizador;
    this.responsable = responsable;
    this.creditosObtener = creditosObtener;
    this.limiteAlumnos = limiteAlumnos;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Calendar getFechaRealizacion() {
        return fechaRealizacion;
    }
    public void setFechaRealizacion(Calendar fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }
    public String getOrganizador() {
        return organizador;
    }
    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }
    public Maestro getResponsable() {
        return responsable;
    }
    public void setResponsable(Maestro responsable) {
        this.responsable = responsable;
    }
    public byte getCreditosObtener() {
        return creditosObtener;
    }
    public void setCreditosObtener(byte creditosObtener) {
        this.creditosObtener = creditosObtener;
    }
    public int getLimiteAlumnos() {
        return limiteAlumnos;
    }
    public void setLimiteAlumnos(int limiteAlumnos) {
        this.limiteAlumnos = limiteAlumnos;
    }
}
