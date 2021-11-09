import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

/**
 * Clase para los telefonos fijos
 * 
 * @author Gabriel Garcia
 * @version 07/11/2021
 */

public class Fijo extends Producto implements Llamadas{
	
	/**
	 * Constructor
	 * 
	 * @param precio el precio en Q
	 * @param serie la serie del producto
	 * @param marca la marca del producto
	 * @param fecha la fecha en formato Date
	 */
	public Fijo(int precio, String serie, String marca, Date fecha){
		super(precio, serie, marca, fecha);
		articulo = "Tel. Fijo";
		tags.add("Hace llamadas");
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
		return " ";
	}

	@Override
	public String hacerLlamada(){
		System.out.println("Ingrese el numero a llamar: ");
		return "Llamando al numero " + new Scanner(System.in).nextLine() + " desde mi " + getArticulo() + " "  + getMarca();
	}

}