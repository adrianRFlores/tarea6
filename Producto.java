import java.util.ArrayList;
import java.util.Date;

public abstract class Producto implements Comparable<Producto>{
	
	protected int precio;
	protected String serie;
	protected String marca;
	protected String articulo;
	protected Date fecha; 
	protected ArrayList<String> tags = new ArrayList<String>();

	public Producto(int precio, String serie, String marca, Date fecha){
		this.precio = precio;
		this.serie = serie;
		this.marca = marca;
		this.fecha = fecha;
	}

	public int getPrecio(){
		return precio;
	}

	public String getMarca(){
		return marca;
	}

	public String getSerie(){
		return serie;
	}

	public Date getFecha(){
		return fecha;
	}

	public ArrayList<String> getTags(){
		return tags;
	}

	public String getArticulo(){
		return articulo;
	}

	public abstract String accion(String cond);

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

	public String toString(){
		return getArticulo() + " " + getMarca() + " " + getSerie() + ": Q" + getPrecio();
	}

}