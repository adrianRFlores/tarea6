import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

/**
 * Clase para los smartwatch
 * 
 * @author Gabriel Garcia
 * @version 07/11/2021
 */

public class Smartwatch extends Producto implements Llamadas, Fotos, Portable{
	
	/**
	 * Constructor
	 * 
	 * @param precio el precio en Q
	 * @param serie la serie del producto
	 * @param marca la marca del producto
	 * @param fecha la fecha en formato Date
	 */
	public Smartwatch(int precio, String serie, String marca, Date fecha){
		super(precio, serie, marca, fecha);
		articulo = "Smartwatch";
		tags.add("Toma fotos");
		tags.add("Hace llamadas");
		tags.add("Portable");  
	}

	/**
	 * Determina la accion en realizar en base a la caracteristica seleccionada
	 * 
	 * @param cond la caracteristica a demostrar
	 * @return un string describiendo la accion
	 */
	public String accion(String cond){
		if(cond.equals("Hace llamadas")){
			return hacerLlamada();
		}
		if(cond.equals("Toma fotos")){
			return tomarFoto();
		}
		if(cond.equals("Portable")){
			return serPortable();
		}
		return " ";
	}

	/**
	 * Devuelve string con la llamada, override de la interfaz Llamada
	 * 
	 * @return el string con el contenido de la llamada
	 */
	@Override
	public String hacerLlamada(){
		System.out.println("Ingrese el numero a llamar: ");
		return "Llamando al numero " + new Scanner(System.in).nextLine() + " desde mi " + getArticulo() + " "  + getMarca();
	}

	/**
	 * Devuelve string con la foto, override de la interfaz Foto
	 * 
	 * @return el string con el contenido de la foto
	 */
	@Override
	public String tomarFoto(){
		return "Tomando foto con la camara de mi " + getArticulo() + " "  + getMarca();
	}
	
	/**
	 * Devuelve string con la portabilidad, override de la interfaz Portable
	 * 
	 * @return el string con el contenido del mensaje
	 */
	@Override
	public String serPortable(){
		return "Poniendo mi " + getArticulo() + " "  + getMarca() + " en mi muneca...";
	}

}