/**
 * El problema de 3-puzzle no siempre tiene solución. Muevas como
 * muevas el hueco, solo se permite rotar las piezas, bien en sentido
 * de las agujas del reloj o en sentido contrario, por lo que,
 * si las piezas están cruzadas es imposible colocarlas en orden
 * correcto. Esto lo diferencia del 8-puzzle.
 */
package com.iaic.problems.threePuzzle;
import java.io.*;
/*
 *    _________
 * y=0|___|___|
 * y=1|___|___|
 *     x=0 x=1 
 * 
 */


/**
 * Será la representación del estado para el problema del
 * 3-puzzle. Tomando como piezas del puzzle los números del
 * 1 al 3, y siendo el 0 el hueco.
 * @author alberto
 *
 */
public class tresPuzzleEstado implements Cloneable {
	/**
	 * La ruta del fichero del que se leerá el estado inicial
	 * del puzzle.
	 */
	private final String ESTADOINICIAL="3puzzle-estadoinicial.txt";
	/**
	 * El tablero del puzzle, representado como una matriz,
	 * donde la primera dimensión representa a las filas y la
	 * segunda representa a las columnas. Será una matriz de
	 * enteros, donde el 0 será el espacio y los números del
	 * 1 al 3 representarán las distintas fichas del juego.
	 */
	private int tablero[][];
	/**
	 * La coordenada horizontal donde se sitúa el espacio.
	 * No es estrictamente necesario guardar las coordenadas,
	 * pero facilita las cosas para determinadas funciones.
	 */
	private int xespacio;
	/**
	 * La coordenada vertical donde se sitúa el espacio.
	 * No es estrictamente necesario guardar las coordenadas,
	 * pero facilita las cosas para determinadas funciones.
	 */
	private int yespacio;
	/**
	 * Constructora por defecto. Crea un estado objetivo.
	 * Lo necesitaremos para las comparaciones en el test
	 * de objetivo.
	 */
	public tresPuzzleEstado() {
		tablero=new int[][] {{1,2},{0,3}};
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Object clone() {
		tresPuzzleEstado clone=new tresPuzzleEstado();
		for (int y=0;y<2;y++)
			for (int x=0;x<2;x++) {
				clone.tablero[y][x]=tablero[y][x];				
			}
		clone.xespacio=xespacio;
		clone.yespacio=yespacio;
		return clone;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String str="";
		for (int y=0;y<2;y++) {
			for (int x=0;x<2;x++)
				str=str+Integer.toString(tablero[y][x]);
			str=str+"\n";
		}
		str=str+"\n";return str;			
	}
	
	/**
	 * Convierte el estado en un estado objetivo.
	 */
	public void hacerObjetivo() {
		tablero[0][0]=1;tablero[0][1]=2;
		tablero[1][0]=0;tablero[1][1]=3;
		xespacio=0;yespacio=1;
	}
	/**
	 * Convierte el estado en un estado inicial, leyendo los datos de un 
	 * fichero de configuración.
	 */
	public void hacerEstadoInicial() {
		try {
			cargaEstadoInicial(ESTADOINICIAL);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	/**
	 * Función para acceder a una pieza del puzzle, indicada
	 * por sus coordenadas en el tablero.
	 * @param x La coordenada horizontal de la celda que queremos leer.
	 * @param y La coordenada vertical de la celda que queremos leer.
	 * @return La pieza que ocupa la celda x,y; o -1 en caso de error.
	 */
	public int obtenerPieza(int x,int y) {
		if (x<0 || y<0 || x>2 || y>2)
			return -1;
		return tablero[y][x];
	}
	/**
	 * 
	 * @return La coordenada X del espacio.
	 */
	public int getX() {
		return xespacio;
	}
	/**
	 * 
	 * @return La coordenada Y del espacio.
	 */
	public int getY() {
		return yespacio;
	}
	/**
	 * Mueve el espacio una posición arriba. NO SE HACE
	 * COMPROBACIÓN DE COORDENADAS.
	 */
	public void moverArriba() {
		tablero[yespacio][xespacio]=tablero[yespacio-1][xespacio];
		tablero[yespacio-1][xespacio]=0;
		yespacio--;
	}
	/**
	 * 
	 * @return True si es posible mover el espacio hacia
	 * arriba.
	 */
	public boolean puedoMoverArriba() {
		return yespacio==1;
	}
	/**
	 * Mueve el espacio una posición abajo. SIN COMPROBACIÓN
	 * DE COORDENADAS.
	 */
	public void moverAbajo() {
		tablero[yespacio][xespacio]=tablero[yespacio+1][xespacio];
		tablero[yespacio+1][xespacio]=0;
		yespacio++;
	}
	/**
	 * 
	 * @return True si puedo mover el espacio hacia abajo.
	 */
	public boolean puedoMoverAbajo() {
		return yespacio==0;
	}
	/**
	 * 
	 * @return True si se puede mover el espacio una posición
	 * a la izquierda.
	 */
	public boolean puedoMoverIzquierda() {
		return xespacio==1;
	}
	/**
	 * Desplaza el hueco una posición a la izquierda. NO SE 
	 * COMPRUEBAN LAS COORDENADAS.
	 */
	public void moverIzquierda() {
		tablero[yespacio][xespacio]=tablero[yespacio][xespacio-1];
		tablero[yespacio][xespacio-1]=0;
		xespacio--;
	}
	/**
	 * 
	 * @return True si se puede mover el espacio una posición
	 * a la izquierda.
	 */
	public boolean puedoMoverDerecha() {
		return xespacio==0;
	}
	/**
	 * Desplaza el hueco una posición a la izquierda. NO SE 
	 * COMPRUEBAN LAS COORDENADAS.
	 */
	public void moverDerecha() {
		tablero[yespacio][xespacio]=tablero[yespacio][xespacio+1];
		tablero[yespacio][xespacio+1]=0;
		xespacio++;
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object ee) {
		tresPuzzleEstado e=(tresPuzzleEstado)ee;
		boolean respuesta=true;
		for (int i=0;i<2&&respuesta;i++)
			for (int j=0;j<2&&respuesta;j++)
				if (tablero[i][j]!=e.tablero[i][j])
					respuesta=false;
		return respuesta;//no comprobamos xespacio ni yespacio
	}
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		int codigo=0;
		String a="";
		for (int y=0;y<2;y++)
			for (int x=0;x<2;x++)
				a=a+Integer.toString(tablero[y][x]);
		codigo=Integer.parseInt(a);
		return codigo;
	}
	/**
	 * Intenta recopilar el estado inicial de un fichero,
	 * situado en la ruta del parámetro. En caso de ser 
	 * una ruta parcial, la raiz es el directorio principal
	 * del proyecto.
	 * @param fichero La ruta del fichero del que se leeerá
	 * el estado.
	 * @throws Exception Excepciones de tipo IO.
	 */
	private void cargaEstadoInicial(String fichero) throws Exception {
		BufferedReader bf = new BufferedReader(new FileReader(fichero));
		String buf=bf.readLine();int i=0;
		while (buf!=null && buf.length()>=2 && i<2) {
			for (int j=0;j<2;j++) {
				String a=""+buf.charAt(j);
				tablero[i][j]=Integer.parseInt(a);
				if (tablero[i][j]==0) {
					xespacio=j;yespacio=i;
				}
			}
			buf=bf.readLine();
			i++;
		}
		if (i!=2) {
			System.out.println("Ha ocurrido un error en la lectura del fichero "+fichero+". No se ha terminado de cargar el estado inicial.");
		}
		bf.close();
	}
}
