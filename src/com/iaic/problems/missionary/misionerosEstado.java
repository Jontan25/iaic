/**
 * Problema de los misioneros: Tenemos en principio tres misioneros y
 * tres canibales en la orilla de un rio, y una barca que solo puede ser conducida
 * como minimo por un misionero. El Objetivo es que los seis crucen a la otra orilla pero 
 * siempre teniendo cuidado de que el numero de canibales en cualquier orilla
 * no sea mayor que el de misioneros ya que se los comerían.
 */
package problems.missionary;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.Math;

/**
 * @author mario
 */
public class misionerosEstado implements Cloneable {
	/**
	 * La ruta del fichero del que se leerá el estado
	 * inicial del juego.
	 * CREO QUE NO LO NECESITAMOS PORQUE DEBERIA EMPEZAR SIEMPRE EL MISMO
	 */
	private final String ESTADOINICIAL="misioneros-estadoinicial.txt";
	
	/**
	 * El numero máximo de misioneros que puede haber en la orilla izquierda.
	 */
	private final int MISIONEROSMAX=3;
	
	/**
	 * El numero máximo de canibales que puede haber en la orilla izquierda.
	 */
	private final int CANIBALESMAX=3;
	
	/**
	 * Indica el numero de misioneros que hay en la orilla izquierda.
	 * Tiene un rango de valores desde 0 a MISIONEROSMAX.
	 */
	private int NumMisioneros;
	/**
	 * Indica el numero de canibales que hay en la orilla izquierda.
	 * Tiene un rango de valores desde 0 a CANIBALESMAX.
	 */
	private int NumCanibales;
	
	/**
	 * Indica la orilla en la que se encuentra el bote.
	 * Tiene un rango de valores desde 0 a 1.
	 * Con 0 para representar que el bote esta en la orilla derecha y 1 para
	 * representar que el bote esta en la orilla izquierda.
	 */
	private int Bote;
	
	/**
	 * La constructora por defecto crea el estado inicial.
	 */
	public garrafasEstado() {
		NumMisioneros=3;NumCanibales=3;Bote=1;		
	}
	/**
	 * Convierte el estado en un estado objetivo. Un estado objetivo
	 * es cualquiera en el que los tres misioneros y los tres canibales
	 * estan en la orilla derecha, la posion del bote daria lo mismo, aunque ante
	 * el ultimo movimiento deberia estar en la orilla derecha.
	 */
	public void hacerObjetivo() {
		NumMisioneros=0;NumCanibales=0;Bote=0;
	}
	/**
	 * Comprueba si el estado es un estado objetivo o no.
	 * @return True si es un estado objetivo; es decir,si el numero
	 * de misioneros y canibales en la orilla izquierda es cero. False en caso contrario.
	 */
	public boolean esObjetivo() {
		return NumMisioneros==0;NumCanibales==0;Bote==0;
	}
	/**
	 * Método para acceder al numero de misioneros que hay en la orilla izquierda.
	 * @return NumMisioneros actual que hay en la orilla izquierda.
	 */
	public int getNumMisioneros() {
		return NumMisioneros;
	}
	/**
	 * Método para acceder al numero de canibales que hay en la orilla izquierda.
	 * @return NumCanibales actual que hay en la orilla izquierda.
	 */
	public int getNumCanibales() {
		return NumCanibales;
	}
	
	/**
	 * Método para acceder al valor del bote y asi saber en que orilla esta.
	 * @return Bote, valor que indica en que orilla esta el bote.
	 */
	public int getBote() {
		return Bote;
	}
	
	/**
	 * Operador para que cruce 1 solo misionero
	 */
	public void cruzaM() {
			if (Bote==1){
				NumMisioneros -=1;
				Bote = 0;
			}
			if (Bote==0){
				NumMisioneros +=1;
				Bote = 1;
			}
	}
	
	/**
	 * Operador para que cruce 1 solo canibal
	 */
	public void cruzaC() {
			if (Bote==1){
				NumCanibales -=1;
				Bote = 0;
			}
			if (Bote==0){
				NumCanibales +=1;
				Bote = 1;
			}
	}
	
	/**
	 * Operador para que crucen 2 misioneros
	 */
	public void cruzaMM() {
		if (((NumMisioneros>1)&&(Bote==1))||((NumCanibales<3) && (Bote==0))){
			if (Bote==1){
				NumCanibales -=1;
				Bote = 0;
			}
			if (Bote==0){
				NumCanibales +=1;
				Bote = 1;
			}
		}	
	}
	
	/**
	 * Operador para que crucen 2 canibales
	 */
	public void cruzaCC() {
		if (((NumMisioneros>1)&&(Bote==1))||((NumCanibales<3) && (Bote==0))){
			if (Bote==1){
				NumCanibales -=1;
				Bote = 0;
			}
			if (Bote==0){
				NumCanibales +=1;
				Bote = 1;
			}
		}	
	}
	
	/**
	 * Operador para que crucen 1 misionero y 1 canibal
	 */
	public void cruzaMC() {
		if (((NumMisioneros>1)&&(Bote==1))||((NumCanibales<3) && (Bote==0))){
			if (Bote==1){
				NumCanibales -=1;
				Bote = 0;
			}
			if (Bote==0){
				NumCanibales +=1;
				Bote = 1;
			}
		}	
	}
	
	
	/**
	 * Este método mira si se puede aplicar el operador de cruzaMisionero.
	 * @return True si el numero de misioneros en la 
	 * orilla izquierda es mayor que cero y el bote esta alli, o
	 * si el numero de misioneros en la orilla derecha es menor que 3 y el bote esta alli
	 * y False en caso contrario.
	 */
	public boolean puedoCruzarMisionero() {
		return ((NumMisioneros>0)&&(Bote==1))||((NumMisioneros<3) && (Bote==0));
	}
	
	/**
	 * Este método mira si se puede aplicar el operador de cruzaCanibal.
	 * @return True si el numero de canibales en la 
	 * orilla izquierda es mayor que cero y el bote esta alli, o
	 * si el numero de canibales en la orilla derecha es menor que 3 y el bote esta alli
	 * y False en caso contrario.
	 */
	public boolean puedoCruzarCanibal() {
		return ((NumCanibales>0)&&(Bote==1))||((NumCanibales<3) && (Bote==0));
	}
	
	/**
	 * Este método mira si se puede aplicar el operador de cruzaCanibal.
	 * @return True si el numero de canibales en la 
	 * orilla izquierda es mayor que cero y el bote esta alli, o
	 * si el numero de canibales en la orilla derecha es menor que 3 y el bote esta alli
	 * y False en caso contrario.
	 */
	public boolean puedoCruzar2Misioneros() {
		return ((NumMisioneros>1)&&(Bote==1))||((NumMisioneros<3) && (Bote==0));
	}
	
	/**
	 * Este método mira si se puede aplicar el operador de cruzaCanibal.
	 * @return True si el numero de canibales en la 
	 * orilla izquierda es mayor que cero y el bote esta alli, o
	 * si el numero de canibales en la orilla derecha es menor que 3 y el bote esta alli
	 * y False en caso contrario.
	 */
	public boolean puedoCruzar2Canibales() {
		return ((NumCanibales>1)&&(Bote==1))||((NumCanibales<3) && (Bote==0));
	}
	
	/**
	 * Este método mira si se puede aplicar el operador de cruzaCanibal.
	 * @return True si el numero de canibales en la 
	 * orilla izquierda es mayor que cero y el bote esta alli, o
	 * si el numero de canibales en la orilla derecha es menor que 3 y el bote esta alli
	 * y False en caso contrario.
	 */
	public boolean puedoCruzarMisioneroCanibal() {
		return ((NumCanibales>0)&&(NumCanibales>0)&&(Bote==1))||
		((NumCanibales<3)&&(NumCanibales<3)&& (Bote==0));
	}
	

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		misionerosEstado e=(misionerosEstado)o;
		return (e.getNumMisioneros()==NumMisioneros && e.getNumCanibales()==NumCanibales
				&& e.getBote()==Bote);
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		int codigo=0;
		String a=Integer.toString(NumMisioneros)+Integer.toString(NumCanibales)+
		       Integer.toString(Bote);
		codigo=Integer.parseInt(a);
		return codigo;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		misionerosEstado clone=new misionerosEstado();
		clone.NumMisioneros=NumMisioneros;
		clone.NumCanibales=NumCanibales;
		clone.Bote=Bote;
		return clone;		
	}
	
	public String toString() {
		return Integer.toString(NumMisioneros)+","+Integer.toString(NumCanibales)+","
		   + Integer.toString(Bote);
	}	
}
