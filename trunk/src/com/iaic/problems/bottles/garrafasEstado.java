/**
 * Problema de las garrafas: Tenemos en principio dos garrafas de
 * 3 y 4 litros cada una. Podemos llenar cada una de ellas, 
 * vaciar cada una de ellas, y volcar cada una en la otra.
 * El problema consiste en que, partiendo preferiblemente de las
 * garrafas vacías, conseguir tener 2 litros en la de 4.
 */
package com.iaic.problems.bottles;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.Math;

/**
 * La representación del estado para el problema de las garrafas.
 * En este caso, las garrafas serán de 3 y 4 litros, y la 
 * representación será un par de números que significarán el
 * volumen de la garrafa de 3 litros y el de la garrafa de 4.
 * @author alberto
 *
 */
public class garrafasEstado implements Cloneable {
	/**
	 * La ruta del fichero del que se leerán los volúmenes
	 * iniciales de las garrafas.
	 */
	private final String ESTADOINICIAL="garrafas-estadoinicial.txt";
	/**
	 * La capacidad máxima de la primera garrafa, por si se 
	 * desea probar con otras capacidades. El resto de
	 * operaciones usa esta constante como capacidad total para
	 * esta garrafa (la de 3 litros en este caso).
	 */
	private final int MAX3=3;
	/**
	 * La capacidad máxima de la segunda garrafa, por si se 
	 * desea probar con otras capacidades. El resto de 
	 * operaciones usan esta constante como capacidad total para
	 * la segunda garrafa (que en nuestro caso es la de 4 litros).
	 */
	private final int MAX4=4;
	/**
	 * Un atajo para iniciar o vaciar garrafas.
	 */
	private final int GARRAFA_VACIA=0;
	
	
	/**
	 * Indica la capacidad de la primera garrafa. Tiene un rango de
	 * valores que va de 0 a MAX3.
	 */
	private int Vol3;
	/**
	 * La capacidad actual de la segunda garrafa. El rango va de 0
	 * a MAX4.
	 */
	private int Vol4;
	
	/**
	 * La constructora por defecto inicia las garrafas a vacías.
	 */
	public garrafasEstado() {
		Vol3=GARRAFA_VACIA;Vol4=GARRAFA_VACIA;		
	}
	/**
	 * Convierte el estado en un estado objetivo. Un estado objetivo
	 * es cualquiera con el que se tengan 2 litros en la garrafa de
	 * 4. El volumen de la garrafa de 3 litros da lo mismo, nosotros
	 * la dejamos vacía para evitar incoherencias.
	 */
	public void hacerObjetivo() {
		Vol4=2;Vol3=GARRAFA_VACIA;
		//en realidad Vol3 da lo mismo
	}
	/**
	 * Comprueba si el estado es un estado objetivo o no.
	 * @return True si es un estado objetivo; es decir, si en la garrafa
	 * de cuatro litros hay exactamente 2l de agua. False en caso contrario.
	 */
	public boolean esObjetivo() {
		return Vol4==2;
	}
	/**
	 * Método para acceder al volumen actual de la garrafa de 3 litros.
	 * @return Volumen actual de agua que contiene la garrafa de 3 litros.
	 */
	public int getVol3() {
		return Vol3;
	}
	/**
	 * Método para acceder al volumen actual de la garrafa de 4 litros.
	 * @return Volumen actual de agua en la garrafa de 4 litros.
	 */
	public int getVol4() {
		return Vol4;
	}
	/**
	 * Operador para llenar la garrafa de 3 litros
	 */
	public void llenarGarrafa3() {
		Vol3=MAX3;
	}
	/**
	 * Operador para llenar la garrafa de 4 litros
	 */
	public void llenarGarrafa4() {
		Vol4=MAX4;
	}
	/**
	 * Operador para vaciar la garrafa de 3 litros
	 */
	public void vaciarGarrafa3() {
		Vol3=GARRAFA_VACIA;
	}
	/**
	 * Operador para vaciar la garrafa de 4 litros
	 */
	public void vaciarGarrafa4() {
		Vol4=GARRAFA_VACIA;
	}
	/**
	 * Operador para volcar la garrafa de 3 litros en la de 4 litros.
	 * Se deposita el contenido de la garrafa 3 en la de 4 litros,
	 * hasta que, o bien se llena la de 4, o bien se vacía la de 3.
	 * Por tanto, la garrafa de 3 no tiene por qué quedarse vacía,
	 * ni la de 4 llena.
	 */
	public void volcarGarrafa3en4() {
		int litros=Math.min(MAX4-Vol4,Vol3);
		/* se calculan los litros que se traspasarán, que son el mínimo
		 * entre el hueco en la garrafa4 y el volumen de la garrafa3.
		 * No se pueden pasar más litros que los que le quedan a la 4
		 * para llenarse, ni se pueden pasar más litros de los que tiene
		 * la 3.
		 */
		Vol4+=litros;
		Vol3-=litros;
	}
	/**
	 * Operador para volcar la garrafa de 4 litros en la de 3 litros.
	 * Se deposita el contenido de la garrafa 4 en la de 3 litros,
	 * hasta que, o bien se llena la de 3, o bien se vacía la de 4.
	 * Por tanto, la garrafa de 4 no tiene por qué quedarse vacía,
	 * ni la de 3 llena.
	 */
	public void volcarGarrafa4en3() {
		int litros=Math.min(MAX3-Vol3,Vol4);
		/* se calculan los litros que se traspasarán, que son el mínimo
		 * entre el hueco en la garrafa3 y el volumen de la garrafa4.
		 * No se pueden pasar más litros que los que le quedan a la 3
		 * para llenarse, ni se pueden pasar más litros de los que tiene
		 * la 4.
		 */
		Vol3+=litros;
		Vol4-=litros;
	}
	
	/**
	 * Este método mira si se puede aplicar el operador de llenado de
	 * la garrafa 3, que corresponde a mirar si tiene hueco.
	 * @return True si la garrafa 3 tiene hueco y False en caso contrario.
	 */
	public boolean puedoLlenar3() {
		return Vol3<MAX3;
	}
	/**
	 * Este método mira si se puede aplicar el operador de llenado de
	 * la garrafa 4, que corresponde a mirar si tiene hueco.
	 * @return True si la garrafa 4 tiene hueco y False en caso contrario.
	 */
	public boolean puedoLlenar4() {
		return Vol4<MAX4;
	}
	/**
	 * Este método mira si se puede aplicar el operador de vaciado de
	 * la garrafa 3, que corresponde con mirar si no está ya vacía.
	 * @return True si la garrafa 3 no está vacía.
	 */
	public boolean puedoVaciar3() {
		return Vol3>GARRAFA_VACIA;
	}
	/**
	 * Este método mira si se puede aplicar el operador de vaciado de
	 * la garrafa 4, que corresponde con mirar si no está ya vacía.
	 * @return True si la garrafa 4 no está vacía.
	 */
	public boolean puedoVaciar4() {
		return Vol4>GARRAFA_VACIA;
	}
	/**
	 * Este método mira si se puede aplicar el operador de volcar
	 * la garrafa de 4 litros en la de 3 litros. Para ello, la
	 * garrafa de 4 debe tener algo, y la de 3 tener hueco.
	 * @return True si es posible aplicar el operador.
	 */
	public boolean puedoVolcar4en3() {
		return (Vol3<MAX3 && Vol4>GARRAFA_VACIA);
	}
	/**
	 * Este método mira si se puede aplicar el operador de volcar
	 * la garrafa de 3 litros en la de 4 litros. Para ello, la
	 * garrafa de 3 debe tener algo, y la de 4 tener hueco.
	 * @return True si es posible aplicar el operador.
	 */
	public boolean puedoVolcar3en4() {
		return (Vol4<MAX4 && Vol3>GARRAFA_VACIA);
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		BottlesState e=(BottlesState)o;
		return (e.getVol3()==Vol3 && e.getVol4()==Vol4);
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		int codigo=0;
		String a=Integer.toString(Vol3)+Integer.toString(Vol4);
		codigo=Integer.parseInt(a);
		return codigo;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		BottlesState clone=new BottlesState();
		clone.Vol3=Vol3;
		clone.Vol4=Vol4;
		return clone;		
	}
	
	public String toString() {
		return Integer.toString(Vol3)+","+Integer.toString(Vol4);
	}
	
	/**
	 * Intenta recopilar el estado inicial de un fichero,
	 * situado en la ruta del parámetro. En caso de ser 
	 * una ruta parcial, la raiz es el directorio principal
	 * del proyecto.
	 * El estado inicial son dos números de 0 a 4 sin separar.
	 * @param fichero La ruta del fichero del que se leeerá
	 * el estado.
	 * @throws Exception Excepciones de tipo IO.
	 */
	private void cargaEstadoInicial(String fichero) throws Exception {
		BufferedReader bf = new BufferedReader(new FileReader(fichero));
		String buf=bf.readLine();
		Vol3=Character.getNumericValue(buf.charAt(0));
		Vol4=Character.getNumericValue(buf.charAt(1));
		bf.close();
	}
	
	public void hacerEstadoInicial() {
		try {
			cargaEstadoInicial(ESTADOINICIAL);
		}
		catch (Exception e) {
			Vol3=GARRAFA_VACIA;Vol4=GARRAFA_VACIA;
			System.out.println(e.getMessage());
		}
	}
	
	
}
