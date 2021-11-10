import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

/**
 * Clase para las tablets
 * 
 * @author Gabriel Garcia
 * @version 07/11/2021
 */

public class Tablet extends Producto implements Fotos, Internet, Videos, Portable{
	
	/**
	 * Constructor
	 * 
	 * @param precio el precio en Q
	 * @param serie la serie del producto
	 * @param marca la marca del producto
	 * @param fecha la fecha en formato Date
	 */
	public Tablet(int precio, String serie, String marca, Date fecha){
		super(precio, serie, marca, fecha);
		articulo = "Tablet";
		tags.add("Toma fotos");
		tags.add("Navega por el internet");
		tags.add("Reproduce videos");
		tags.add("Portable");  
	}

	/**
	 * Determina la accion en realizar en base a la caracteristica seleccionada
	 * 
	 * @param cond la caracteristica a demostrar
	 * @return un string describiendo la accion
	 */
	public String accion(String cond){
		if(cond.equals("Toma fotos")){
			return tomarFoto();
		}
		if(cond.equals("Navega por el internet")){
			return navegarInternet();
		}
		if(cond.equals("Reproduce videos")){
			return reproducirVideo();
		}
		if(cond.equals("Portable")){
			return serPortable();
		}
		return " ";
	}

	/**
	 * Devuelve string con la foto, override de la interfaz Foto
	 * 
	 * @return el string con el contenido de la foto
	 */
	@Override
	public String tomarFoto(){
		return "Tomando foto con la camara frontal de mi " + getArticulo() + " "  + getMarca();
	}

	/**
	 * Devuelve string con la pagina web, override de la interfaz Internet
	 * 
	 * @return el string con el contenido de la pagina web
	 */
	@Override
	public String navegarInternet(){
		System.out.println("Ingrese la pagina a la que desea navegar: ");
		return "Visitando direccion web: " + new Scanner(System.in).nextLine() + " desde mi " + getArticulo() + " "  + getMarca();
	}

	/**
	 * Devuelve string con el, override de la interfaz Videos
	 * 
	 * @return el string con el contenido del video
	 */
	@Override
	public String reproducirVideo(){
		return "Reproduciendo el video de muestra 'demo.mp4' desde mi " + getArticulo() + " "  + getMarca();
	}

	/**
	 * Devuelve string con la portabilidad, override de la interfaz Portable
	 * 
	 * @return el string con el contenido del mensaje
	 */
	@Override
	public String serPortable(){
		return "Bloqueando y guardando mi " + getArticulo() + " "  + getMarca();
	}

}