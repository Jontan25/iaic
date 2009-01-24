/**
 * Problema de los misioneros: Tenemos en principio tres misioneros y
 * tres canibales en la orilla de un rio, y una barca que solo puede ser conducida
 * como minimo por un misionero. El Objetivo es que los seis crucen a la otra orilla pero 
 * siempre teniendo cuidado de que el numero de canibales en cualquier orilla
 * no sea mayor que el de misioneros ya que se los comerían.
 */
package problems.farmerandlettuce;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.Math;

/**
 * @author mario
 */
public class farmerandlettuceState implements Cloneable {
	/**
	 * La ruta del fichero del que se leerá el estado
	 * inicial del juego.
	 * CREO QUE NO LO NECESITAMOS PORQUE DEBERIA EMPEZAR SIEMPRE EL MISMO
	 */
	private final String ESTADOINICIAL="farmerandlettuce-inicialstate.txt";
	
	
	
	/**
	 * Indica donde se encuentra el granjero y el bote.
	 * Tiene un rango de valores desde 0 a 1, con 1 para indicar la orilla izquierda
	 * y 0 para indicar la orilla derecha.
	 */
	private int Granjero_Bote;
	
	/**
	 * Indica donde se encuentra el lobo.
	 * Tiene un rango de valores desde 0 a 1, con 1 para indicar la orilla izquierda
	 * y 0 para indicar la orilla derecha.
	 */
	private int Lobo;
	
	/**
	 * Indica donde se encuentra la oveja.
	 * Tiene un rango de valores desde 0 a 1, con 1 para indicar la orilla izquierda
	 * y 0 para indicar la orilla derecha.
	 */
	private int Oveja;
	
	/**
	 * Indica donde se encuentra la lechuga.
	 * Tiene un rango de valores desde 0 a 1, con 1 para indicar la orilla izquierda
	 * y 0 para indicar la orilla derecha.
	 */
	private int Lechuga;
	
	
	/**
	 * La constructora por defecto crea el estado inicial.
	 */
	public granjeroylechugaEstado() {
		Granjero_Bote=1;Lobo=1;Oveja=1;Lechuga=1;	
	}
	
	/**
	 * Convierte el estado en un estado objetivo. El estado objetivo
	 * es aquel en el que el granjero, lobo, oveja y lechuga estan en el 
	 * lado derecho del rio.
	 */
	public void hacerObjetivo() {
		Granjero_Bote=0;Lobo=0;Oveja=0;Lechuga=0;
	}
	
	/**
	 * Comprueba si el estado es un estado objetivo o no.
	 * @return True si es un estado objetivo; es decir,si el numero
	 * de misioneros y canibales en la orilla izquierda es cero. False en caso contrario.
	 */
	public boolean esObjetivo() {
		return Granjero_Bote==0;Lobo==0;Oveja==0;Lechuga==0;
	}
	/**
	 * Método para acceder al numero de misioneros que hay en la orilla izquierda.
	 * @return NumMisioneros actual que hay en la orilla izquierda.
	 */
	public int getGranjero_Bote() {
		return Granjero_Bote;
	}
	/**
	 * Método para acceder al numero de canibales que hay en la orilla izquierda.
	 * @return NumCanibales actual que hay en la orilla izquierda.
	 */
	public int getLobo() {
		return Lobo;
	}
	
	/**
	 * Método para acceder al valor del bote y asi saber en que orilla esta.
	 * @return Bote, valor que indica en que orilla esta el bote.
	 */
	public int getOveja() {
		return Oveja;
	}
	
	/**
	 * Método para acceder al valor del bote y asi saber en que orilla esta.
	 * @return Bote, valor que indica en que orilla esta el bote.
	 */
	public int getLechuga() {
		return Lechuga;
	}
	
	/**
	 * Operador para que cruce el granjero solo
	 */
	public void cruzaSolo(){
	    if (Granjero_Bote == 1){
	    	Granjero_Bote = 0;
	    }
	    if (Granjero_Bote == 0){
	    	Granjero_Bote = 1;
	    }
	}
	
	/**
	 * Operador para que cruce el granjero con la lechuga
	 */
	public void cruzaLechuga(){
	    if (Lechuga == 1){
	    	Lechuga = 0;
	    }
	    if (Lechuga == 0){
	    	Lechuga = 1;
	    }
	}
	
	/**
	 * Operador para que crucen 2 misioneros
	 */
	public void cruzaOveja(){
		if (Oveja == 1){
			Oveja = 0;
	    }
	    if (Oveja == 0){
	    	Oveja = 1;
	    }
	}
	
	/**
	 * Operador para que crucen 2 canibales
	 */
	public void cruzaLobo(){
		if (Lobo == 1){
			Lobo = 0;
	    }
	    if (Lobo == 0){
	    	Lobo = 1;
	    }
	}
	
    
	/*
	 * Evalua la condicion de peligrosidad
	 */
	public boolean peligrosidad(int gb, int l, int o, int le){
		return (
				((gb==1)&&(l==o==0)) || ((gb==0)&&(l==o==1)) || 
				((gb==1)&&(o==le==0) || ((gb==0)&&(o==le==1))
		        );
	}
	

	
	/**
	 * Este método mira si se puede aplicar el operador de cruzaMisionero.
	 * @return True si el numero de misioneros en la 
	 * orilla izquierda es mayor que cero y el bote esta alli, o
	 * si el numero de misioneros en la orilla derecha es menor que 3 y el bote esta alli
	 * y False en caso contrario.
	 */
	public boolean puedoCruzarSolo() {
		return !peligrosidad()
	}
	
	/**
	 * Este método mira si se puede aplicar el operador de cruzaCanibal.
	 * @return True si el numero de canibales en la 
	 * orilla izquierda es mayor que cero y el bote esta alli, o
	 * si el numero de canibales en la orilla derecha es menor que 3 y el bote esta alli
	 * y False en caso contrario.
	 */
	public boolean puedoCruzarLechuga() {
		
	}
	
	/**
	 * Este método mira si se puede aplicar el operador de cruzaCanibal.
	 * @return True si el numero de canibales en la 
	 * orilla izquierda es mayor que cero y el bote esta alli, o
	 * si el numero de canibales en la orilla derecha es menor que 3 y el bote esta alli
	 * y False en caso contrario.
	 */
	public boolean puedoCruzarOveja() {
		
	}
	
	/**
	 * Este método mira si se puede aplicar el operador de cruzaCanibal.
	 * @return True si el numero de canibales en la 
	 * orilla izquierda es mayor que cero y el bote esta alli, o
	 * si el numero de canibales en la orilla derecha es menor que 3 y el bote esta alli
	 * y False en caso contrario.
	 */
	public boolean puedoCruzarLobo() {
	
	}
		

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		famerandlettuceState e=(famerandlettuceState)o;
		return (e.getGranjero_Bote()==Granjero_Bote && e.getLobo()==Lobo
				&& e.getOveja()==Oveja && e.getLechuga()==Lechuga);
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		int codigo=0;
		String a=Integer.toString(Granjero_Bote)+Integer.toString(Lobo)+
		       Integer.toString(Oveja)+Integer.toString(Lechuga);
		codigo=Integer.parseInt(a);
		return codigo;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		famerandlettuceState clone=new famerandlettuceState();
		clone.Granjero_Bote=Granjero_Bote;
		clone.Lobo=Lobo;
		clone.Oveja=Oveja;
		clone.Lechuga=Lechuga;
		return clone;		
	}
	
	public String toString() {
		return Integer.toString(Granjero_Bote)+","+Integer.toString(Lobo)+","
		   + Integer.toString(Oveja) + Integer.toString(Lechuga);
	}	
}
