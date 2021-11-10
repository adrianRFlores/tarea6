import java.util.ArrayList;
import java.util.Date;

/**
 * Clase padre de los demás productos, es abstracta y comparable
 * 
 * @author Adrian Flores
 * @version 08/11/2021
 */

public abstract class Producto implements Comparable<Producto>{
	
	/**
	 * presio? B)
	 */
	protected int precio;

	/**
	 * serie
	 */
	protected String serie;

	/**
	 * marca
	 */
	protected String marca;

	/**
	 * Tipo de objeto
	 */
	protected String articulo;

	/**
	 * Fecha de fabricacion
	 */
	protected Date fecha; 

	/**
	 * los tags ar del objeto
	 */
	protected ArrayList<String> tags = new ArrayList<String>();

	/**
	 * Constructor
	 * 
	 * @param precio el precio
	 * @param serie la serie del producto
	 * @param marca la marca
	 * @param fecha la fecha de fabricacion
	 */
	public Producto(int precio, String serie, String marca, Date fecha){
		this.precio = precio;
		this.serie = serie;
		this.marca = marca;
		this.fecha = fecha;
	}

	/**
	 * Getter del precio
	 * 
	 * @return presio B)? complal!!11!!
	 */
	public int getPrecio(){
		return precio;
	}

	/**
	 * getter de la marca
	 * 
	 * @return la marca
	 */
	public String getMarca(){
		return marca;
	}

	/**
	 * getter de la serie
	 * 
	 * @return la serie
	 */
	public String getSerie(){
		return serie;
	}

	/**
	 * getter de la fecha
	 * 
	 * @return la fecha
	 */
	public Date getFecha(){
		return fecha;
	}

	/**
	 * getter de los tags
	 * 
	 * @return los tags
	 */
	public ArrayList<String> getTags(){
		return tags;
	}

	/**
	 * getter de articulo
	 * 
	 * @return el articulo
	 */
	public String getArticulo(){
		return articulo;
	}

	/**
	 * Abstraccion del metodo para interactuar con el producto
	 * 
	 * @param cond el tipo de interaccion
	 * @return un string describiendo la interaccion, " " si no se encuentra la interaccion
	 */
	public abstract String accion(String cond);

	/**
	 * Compara el precio del producto dado
	 * 
	 * @param o el producto con el cual comparar
	 * @return -1 si el precio es menor al del producto dado, 0 si son iguales o 1 si es mayor
	 */
	@Override
	public int compareTo(Producto o){
		if(precio < o.getPrecio()){
			return -1;
		}
		else if(precio > o.getPrecio()){
			return 1;
		} else{
			return 0;
		}
	}

	/**
	 * Override para mostrar los aspectos basicos del producto
	 * 
	 * @return los aspectos basicos del producto en un string
	 */
	@Override
	public String toString(){
		return getArticulo() + " " + getMarca() + " " + getSerie() + ": Q" + getPrecio();
	}

}