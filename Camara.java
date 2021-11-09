import java.util.ArrayList;
import java.util.Date;

/**
 * Clase para las camaras fotograficas
 * 
 * @author Gabriel Garcia
 * @version 07/11/2021
 */

public class Camara extends Producto implements Fotos, Videos, Portable{
	
	/**
	 * Constructor
	 * 
	 * @param precio el precio en Q
	 * @param serie la serie del producto
	 * @param marca la marca del producto
	 * @param fecha la fecha en formato Date
	 */
	public Camara(int precio, String serie, String marca, Date fecha){
		super(precio, serie, marca, fecha);
		articulo = "Camara";
		tags.add("Toma fotos");
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
		if(cond.equals("Reproduce videos")){
			return reproducirVideo();
		}
		if(cond.equals("Portable")){
			return serPortable();
		}
		return " ";
	}

	@Override
	public String tomarFoto(){
		return "Tomando foto con mi " + getArticulo() + " "  + getMarca();
	}
	@Override
	public String reproducirVideo(){
		return "Reproduciendo el video de muestra 'demo.mp4' desde mi " + getArticulo() + " "  + getMarca();
	}
	@Override
	public String serPortable(){
		return "Bloqueando y guardando mi " + getArticulo() + " "  + getMarca();
	}

}