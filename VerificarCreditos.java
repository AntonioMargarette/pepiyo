import java.util.List;

public class VerificarCreditos {
    //Arreglo de tipo CreditosComplementarios para guardar los Creditos Complemetarios que se van a ir agregando
    private CreditosComplementarios [] creditosGanados = new CreditosComplementarios[0];
    
    // Arreglo de contadores para mantener un registro de las repeticiones de cada tipo de actividad
    private List<Carrera> listaCarreras = ArchivoObjetos.leerArchivoCarrera(".\\Actividades\\Actividades.dat");

    private float [] creditosPorActividad = new float [listaCarreras.size()];
    
    // Definir el límite máximo de créditos
    private static final float LIMITE_MAXIMO_CREDITOS = 5.0f;
    
    //Contador de los creditos
    private int numCreditosActual = 0;
         //Total de creditos obtenidos
    private float totalCreditos = 0.0f;
    public float getTotalCreditos(){
        return totalCreditos;
    }
    public void setTotalCreditos(float totalCreditos){
        this.totalCreditos = totalCreditos;
    }
        
    public CreditosComplementarios[] getCreditos(){
        return creditosGanados;
    }
    
    public void setCreditos(CreditosComplementarios[] creditosGanados){
        this.creditosGanados = creditosGanados;
    }
    public void agregarCreditos(CreditosComplementarios creditoAsig, float sumarCreditos){   
        // Verificar si agregar este crédito excede el límite de créditos por actividad
        CreditosComplementarios.Actividad actividad = creditoAsig.getTipoActividad();
        
        int indice = actividad.ordinal();
        
        if (creditosPorActividad[indice] + sumarCreditos > 2.0f) {
            System.out.println("No se pueden agregar más créditos para esta actividad. Límite de 2 créditos alcanzado.");
            return; // Salir del método si se excede el límite de créditos por actividad
        }
        
        // Buscar un espacio para agregar el nuevo crédito
        if (numCreditosActual == creditosGanados.length) {
            // El arreglo está lleno, crear uno nuevo con el doble de tamaño
            CreditosComplementarios[] nuevoArreglo = new CreditosComplementarios[creditosGanados.length * 2];
            System.arraycopy(creditosGanados, 0, nuevoArreglo, 0, creditosGanados.length);
            creditosGanados = nuevoArreglo;
        }
        
        // Verificar si agregar este crédito excedería el límite máximo
        if (totalCreditos + sumarCreditos > LIMITE_MAXIMO_CREDITOS) {
            System.out.println("No se pueden agregar más créditos. Se alcanzó el límite máximo de " + LIMITE_MAXIMO_CREDITOS + " créditos.");
            return; // Salir del método si se excede el límite máximo
        }
        
        // Agregar el crédito al arreglo y actualizar los contadores
        creditosGanados[numCreditosActual++] = creditoAsig;
        totalCreditos += sumarCreditos;
        creditosPorActividad[indice] += sumarCreditos; // Actualizar el contador de créditos por actividad
    }
}
