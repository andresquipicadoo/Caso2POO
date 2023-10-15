package UIClima;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class validarFecha {
	private String fechaDigitada;
	public validarFecha(String fechaIngresada) {
		
        this.fechaDigitada = fechaIngresada;

		
	}
	public boolean validarFecha() {
		//Explicacion: Este metodo se encarga de validar de que la fecha digitada por el
		// usuario cumpla con el formato d/m/a. Ademas valida que los dias, meses y annios sean validos. Ejemplo 
		// que la cantidad de meses sea del 1 al 12
        SimpleDateFormat formatoFecha = new SimpleDateFormat("d/M/yyyy");// Esta linea de codigo se encarga de que unicamente acepte el formato de fecha
        // establecido
        formatoFecha.setLenient(false); 

        try {
            Date fecha = formatoFecha.parse(fechaDigitada);
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(fecha);
            //Estas tres variables que son integer  obtienen el día, el mes y el año de la fecha analizada
            int dia = calendario.get(Calendar.DAY_OF_MONTH);
            int mes = calendario.get(Calendar.MONTH) + 1;
            int año = calendario.get(Calendar.YEAR);
            // Este if verifica que el mes esté en el rango válido (1 al 12)
            if (mes >= 1 && mes <= 12) {
                int maxDias = validarMesAnnio(mes, año);
                //Esta linea de codigo se encarga de que el dia  se encuentre en un rango valido
                return dia >= 1 && dia <= maxDias;
            } else {
                return false; 
            }
        } catch (ParseException e) {
            return false; 
        }
    }
	 public int validarMesAnnio(int mes, int annio) {
		    //Explicacion:Este metodo se encarga de validar la cantidad de dias que
		     //posee un mes en especifco como por ejemplo setiembre que posee un total de 30 dias.,
         // Si el mes es 4, 6, 9 u 11, devuelve 30 días.
	        switch (mes) {
	            case 4:
	            case 6:
	            case 9:
	            case 11:
	                return 30;
	            case 2:
	                if ((annio % 4 == 0 && annio % 100 != 0) || (annio % 400 == 0)) {
	                	// Verifica si el año es bisiesto que en este caso seria febrero.
	                    return 29; 
	                } else {
	                	//En caso de que el mes de febrero no sea bisiesto tiene 28 dias
	                    return 28;
	                }
	            default:
	            	 // Si no son los meses 4, 6, 9 u 11 o febrebro entonces  devuelve 31 días.
	                return 31;
	        }
	    }
	}


