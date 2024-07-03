import java.util.Calendar;
import java.text.SimpleDateFormat;
public class CreditosComplementarios
{
    // variables
    private Calendar fechaAcreditacion;
    private String nombreActividad;
    private Actividad tipoActividad;
    private float numeroCreditos;
    private float MaximoCreditos = 2.0f;
    
    public CreditosComplementarios (Calendar fechaAcreditacion, String nombreActividad, Actividad tipoActividad,
                                    float numeroCreditos){
        this.fechaAcreditacion = fechaAcreditacion;
        this.nombreActividad = nombreActividad;
        this.tipoActividad = tipoActividad;
        this.numeroCreditos = numeroCreditos;
    }
    public String getCalendarioAsString() {
        // crear formato de fecha
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        // formatear la fecha
        return formato.format(fechaAcreditacion.getTime());
    }
    public void setCalendario(Calendar fechaAcreditacion){
        this.fechaAcreditacion = fechaAcreditacion;
    }
    public String getNombreActividad(){
        return nombreActividad;
    }
    public void setNombreActividad(String nombreActividad){
        this.nombreActividad = nombreActividad;
    }
    public Actividad getTipoActividad(){
        return tipoActividad;
    }
    public void setTipoActividad(Actividad tipoActividad){
        this.tipoActividad = tipoActividad;
    }
    public float getNumeroCreditos(){
        return numeroCreditos;
    }
    public void setNumeroCreditos(float numeroCreditos){
        this.numeroCreditos = numeroCreditos;
        if (numeroCreditos > MaximoCreditos) {
            this.numeroCreditos = 2.0f;
        }
    }
    
}
