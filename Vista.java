import java.util.Scanner;
import java.util.Date;
import java.io.File;
import java.lang.Math;
import java.util.Random;
import java.util.ArrayList;

/**
 * Maneja todos los flujos de entrada y salida del programa
 * 
 * @author Adrian Flores
 * @version 09/11/2021
 */

class Vista{
	
	/**
	 * Instancia de Scanner para permitir la entrada de datos
	 */
	Scanner scan = new Scanner(System.in);

	/**
	 * Lector de archivos
	 */
	Scanner lector;

	/**
	 * Lee un archivo y devuelve los contenidos en un arraylist
	 * 
	 * @return los contenidos del archivo en un arraylist
	 */
	public ArrayList<String> leer(){
		try{
			lector = new Scanner(new File("Sucursales.txt"));
		} catch(Exception e){
			System.out.println("xd");
		}
		ArrayList<String> sucursal = new ArrayList<String>(); 
		while(lector.hasNextLine()){
			sucursal.add(lector.nextLine());
		}
		return sucursal;
	}

	/**
	 * Método para mostrar el menu principal y devolver la opcion escogida por el usuario
	 * 
	 * @return la opcion del usuario
	 */
	public int menu(){
		System.out.println("\n-----------------MENU-----------------");
		System.out.println("1. Ver productos");
		System.out.println("2. Ver carrito");
		System.out.println("3. Salir");
		while(true){
			try{
				while(true){
					int num = scan.nextInt();
					if(num > 0 && num < 4){
						return num;
					} else{
						System.out.println("Ingrese una opcion valida");
					}
				}
			} catch(Exception e){
				System.out.println("Ingrese una opcion valida");
				scan.next();
			}
		}
	}

	/**
	 * Muestra los productos y devuelve un entero con la opcion del usuario
	 * 
	 * @param prods array de los productos
	 * @return la opcion del usuario
	 */
	public int mostrarProductos(Producto[] prods){
		for(int i = 0; i<prods.length; i++){
			System.out.println((i+1) + ". " + prods[i].toString());
			System.out.println("   Fecha de fabricacion: " + prods[i].getFecha());
			mostrarAtr(prods[i]);
		}
		System.out.println("Con que producto desea interactuar?: ");
		while(true){
			try{
				while(true){
					int num = scan.nextInt();
					if(num > 0 && num <= prods.length){
						return num;
					} else{
						System.out.println("Ingrese una opcion valida");
					}
				}
			} catch(Exception e){
				System.out.println("Ingrese una opcion valida");
				scan.next();
			}
		}
	}

	/**
	 * Muestra los tags de un producto
	 * 
	 * @param prod el producto
	 */
	public void mostrarAtr(Producto prod){
		ArrayList<String> tags = prod.getTags();
		for(int i = 0; i<tags.size(); i++){
			System.out.println("    - " + tags.get(i));
		}
		System.out.println();
	}

	/**
	 * Muestra las acciones posibles y devuelve la opcion del usuario
	 * 
	 * @return la opcion del usuario
	 */
	public int mostrarAcciones(){
		System.out.println("\n1. Interactuar con alguna funcionalidad");
		System.out.println("2. Agregar al carrito");
		System.out.println("3. Regresar");
		while(true){
			try{
				while(true){
					int num = scan.nextInt();
					if(num > 0 && num < 4){
						return num;
					} else{
						System.out.println("Ingrese una opcion valida");
					}
				}
			} catch(Exception e){
				System.out.println("Ingrese una opcion valida");
				scan.next();
			}
		}
	}

	/**
	 * Muestra las funcionalidades de un producto y devuelve un entero con la eleccion del usuario
	 * 
	 * @param prod el producto
	 * @return la eleccion del usuario
	 */
	public String getFunc(Producto prod){
		ArrayList<String> tags = prod.getTags();
		for(int i = 0; i<tags.size(); i++){
			System.out.println((i+1) + ". " + tags.get(i));
		}
		System.out.println("Escoja una: ");
		while(true){
			try{
				while(true){
					int num = scan.nextInt();
					if(num > 0 && num <= tags.size()){
						return tags.get(num-1);
					} else{
						System.out.println("Ingrese una opcion valida");
					}
				}
			} catch(Exception e){
				System.out.println("Ingrese una opcion valida");
				scan.next();
			}
		}
	}

	/**
	 * Muestra el mensaje dado
	 * 
	 * @param mensaje el mensaje a mostrar
	 */
	public void mostrar(String mensaje){
		System.out.println(mensaje);
	}

	/**
	 * Muestra los articulos en el carrito y devuelve un entero con la accion del usuario
	 * 
	 * @param carrito el carrito
	 * @return la eleccion del usuario
	 */
	public int mostrarCarrito(ArrayList<Producto> carrito){
		int tot = 0;
		if(carrito.size() != 0){
			System.out.println("--------------CARRITO--------------");
			for(int i = 0; i<carrito.size(); i++){
				System.out.println((i+1) + ". " + carrito.get(i).toString());
				System.out.println("   Fecha de fabricacion: " + carrito.get(i).getFecha());
				tot += carrito.get(i).getPrecio();
			}
			System.out.println("TOTAL: Q" + tot);
			System.out.println("\nQue desea hacer?: ");
			System.out.println("1. Ordenar elementos");
			System.out.println("2. Eliminar un producto");
			System.out.println("3. Realizar compra");
			System.out.println("4. Regresar");
			while(true){
				try{
					while(true){
						int num = scan.nextInt();
						if(num > 0 && num < 5){
							return num;
						} else{
							System.out.println("Ingrese una opcion valida");
						}
					}
				} catch(Exception e){
					System.out.println("Ingrese una opcion valida");
					scan.next();
				}
			}
		} else {
			System.out.println("No hay elementos para mostrar");
			return 4;
		}
	}

	/**
	 * devuelve un entero en el rango para eliminarlo del carrito
	 * 
	 * @param s el limite superior
	 * @return la entrada del usuario
	 */
	public int eliminar(int s){
		System.out.println("Que elemento desea eliminar?: ");
		while(true){
			try{
				while(true){
					int num = scan.nextInt();
					if(num > 0 && num <= s){
						return num-1;
					} else{
						System.out.println("Ingrese una opcion valida");
					}
				}
			} catch(Exception e){
				System.out.println("Ingrese una opcion valida");
				scan.next();
			}
		}
	}

	/**
	 * Muestra los parametros de sorteo y devuelve la entrada del usuario
	 * 
	 * @return la entrada del usuario
	 */
	public int getParam(){
		System.out.println("En base a que criterio desea ordenar el carrito?: ");
		System.out.println("1. Fecha de fabricacion");
		System.out.println("2. Precio");
		System.out.println("3. Marca");
		while(true){
			try{
				while(true){
					int num = scan.nextInt();
					if(num > 0 && num < 4){
						return num;
					} else{
						System.out.println("Ingrese una opcion valida");
					}
				}
			} catch(Exception e){
				System.out.println("Ingrese una opcion valida");
				scan.next();
			}
		}
	}

	/**
	 * Devuelve un numero dado el limite superior
	 * 
	 * @param lim el limite (inclusivo)
	 * @return la entrada del usuario
	 */
	public int getNum(int lim){
		int num;
		while(true){
			try{
				while(true){
					num = scan.nextInt();
					if(num > 0 && num <= lim){
						return num-1;
					} else{
						System.out.println("Ingrese una opcion valida");
					}
				}
			} catch(Exception e){
				System.out.println("Ingrese una opcion valida");
				scan.next();
			}
		}
	}

	/**
	 * Genera un numero aleatorio de x digitos
	 * 
	 * @param la cantidad de digitos -1
	 * @return el numero
	 */
	public int genNumAleatorio(int digitos){
		Random rand = new Random();
		int temp = digitos;
		int num = 0;
		for(int i = 0; i<digitos ; i++){
			num += rand.nextInt(10)*Math.pow(10, temp - i);
		}
		return num;
	}

	/***
	 * Pide algunos detalles del cliente y genera una factura
	 * 
	 * @param carrito el carrito
	 * @param s las sucursales disponibles
	 */
	public void generarFactura(ArrayList<Producto> carrito, ArrayList<String> s){
		String su;
		int tot = 0;
		System.out.println("Ingrese la sucursal en la que se hara la compra: ");
		for(int i = 0; i<s.size(); i++){
			System.out.println((i+1) +". "+ s.get(i));
		}
		su = s.get(getNum(s.size()));
		scan.nextLine();
		System.out.println("Ingrese su nombre: ");
		String nombre = scan.nextLine();
		System.out.println("Ingrese su NIT: ");
		String nit = scan.nextLine();

		System.out.println("\n--------------FACTURA--------------\n");
		System.out.println(su);
		System.out.println(new Date());
		System.out.println("Numero de factura: " + genNumAleatorio(6));
		System.out.println("\nCliente: " + nombre);
		System.out.println("NIT: " + nit);
		System.out.println("\n-------ARTICULOS-------");

		for(int i = 0; i<carrito.size(); i++){
			System.out.println((i+1) + ". " + carrito.get(i).toString());
			tot += carrito.get(i).getPrecio();
		}

		System.out.println("\nTOTAL: Q" + tot);

	}


}