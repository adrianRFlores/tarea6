import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Clase principal para manejar el flujo del programa
 * 
 * @author Adrián Flores
 * @version 09/11/2021
 */

class Driver{
	
	/**
	 * @deprecated LA NOTA DE DEPRECATED ES POR EL CONSTRUCTOR DE DATE(INT, INT, INT) QUE USÉ PARA CREAR FECHAS CUSTOMIZADAS, IGNORAR LAS ADVERTENCIAS 
	 * obviamente no está obseleta esta funcion, solamente es para que el compilador deje de hacer berrinche :)
	 */
	@Deprecated
	public static void main(String[] args){
		Vista v = new Vista();
		int menu = 0;
		Producto[] prods = {new Smartphone(2500, "Galaxy S9", "Samsung", new Date(118, 02, 25)),
							new Celular(300, "Cityman 300", "Nokia", new Date(92, 05, 17)),
							new Fijo(500, "S850+Bt", "Gigaset", new Date(120, 01, 10)),
							new Camara(6000, "EOS R5", "Canon", new Date(120, 07, 30)),
							new Desktop(13000, "Aurora Ryzen Edition R14", "Alienware", new Date(121, 10, 27)),
							new Laptop(8500, "G3 15", "Dell", new Date(120, 07, 23)),
							new SmartTV(11000, "QN90A QLED", "Samsung", new Date(121, 02, 13)),
							new Tablet(8000, "IPad Pro 12.9", "Apple", new Date(121, 07, 9)),
							new Smartwatch(4000, "Watch 7", "Apple", new Date(121, 01, 26))};
		ArrayList<Producto> carrito = new ArrayList<Producto>();
		int op = -1;
		int accion = 0;
		ArrayList<String> sucursales = v.leer();

		while(menu != 3){
			menu = v.menu();
			switch(menu){
				case 1:
					op = -1;
					while (op != 0){
						op = v.mostrarProductos(prods);
						accion = 0;
						while(accion != 3){
							accion = v.mostrarAcciones();
						 	switch(accion){
						 		case 1:
						 			v.mostrar(prods[op-1].accion(v.getFunc(prods[op-1])));
						 			break;

						 		case 2:
						 			carrito.add(prods[op-1]);
						 			v.mostrar("Agregado al carrito exitosamente");
						 			break;
						 	}
						}
						op = 0;
					}
					break;

				case 2:
					op = 0;
					while(op != 4){
						op = v.mostrarCarrito(carrito);
						switch(op){
							case 1:
								switch(v.getParam()){
									case 1: //Gracias a Domchi en Stack Overflow por el código para
										//Ordenar, el cual fue adaptado a este proyecto.
										//https://stackoverflow.com/questions/5927109/sort-objects-in-arraylist-by-date
										Collections.sort(carrito, new Comparator<Producto>() { //wtf???????
  											public int compare(Producto o1, Producto o2) {
     											return o1.getFecha().compareTo(o2.getFecha());
  											}
										});
										break;

									case 2:
										Collections.sort(carrito, new Comparator<Producto>() { 
  											public int compare(Producto o1, Producto o2) {	   
     											return o1.compareTo(o2);
  											}
										});
										break;

									case 3:
										Collections.sort(carrito, new Comparator<Producto>() { 
  											public int compare(Producto o1, Producto o2) {	   
     											return o1.getMarca().compareTo(o2.getMarca());
  											}
										});
										break;

								}
								
								break;

							case 2:
								carrito.remove(v.eliminar(carrito.size()));
								if(carrito.size() == 0){
									op = 4;
								}
								break;

							case 3:
								v.generarFactura(carrito, sucursales);
								carrito = new ArrayList<Producto>();
								op = 4;
								break;

						}
					}
					break;
			}
		}
	}
}
