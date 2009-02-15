package com.iaic.problems.orientatedBlocks;

/*
 * Created on 21-ene-2008
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author francisco.jose.sanch
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class EstadoBloquesConOrientacion {
	String[] listaSobre;
	boolean[] listaVertical;

	public final static String[] NOMBRES_MESAS={"P","Q"};
	public final static String[] NOMBRES_BLOQUES={"A","B"};
	
	public EstadoBloquesConOrientacion (){
		listaSobre=new String[2];
		listaSobre[0]=NOMBRES_MESAS[0];//A sobre P
		listaSobre[1]=NOMBRES_MESAS[1];//B sobre Q
		listaVertical=new boolean[2];
		listaVertical[0]=false;//A en horizontal
		listaVertical[1]=false;//B en horizontal
	}
	
	public EstadoBloquesConOrientacion (String posicionA,String posicionB,boolean verticalA,boolean verticalB) throws Exception{
		listaSobre=new String[2];
		listaSobre[0]=posicionA;//A sobre P
		listaSobre[1]=posicionB;//B sobre Q
		listaVertical=new boolean[2];
		listaVertical[0]=verticalA;//A en horizontal
		listaVertical[1]=verticalB;//B en horizontal
		//comprobamos que no sea un estado de peligro
		if (!esValida(NOMBRES_BLOQUES[0]) || !esValida(NOMBRES_BLOQUES[1])){
			throw new Exception("Estado no valido: Alguno de los bloques esta mal colocado");
		}
	}
	
	public static boolean esBloque(String bloqueOMesa){
		boolean registrado=false;
		int i=0;
		while (!registrado && i<NOMBRES_BLOQUES.length){
			if (NOMBRES_BLOQUES[i].equals(bloqueOMesa)){
				registrado=true;
			}else{
				i++;
			}
		}
		return registrado;	
	}
	
	public static boolean esMesa(String bloqueOMesa){
		boolean registrado=false;
		int i=0;
		while (!registrado && i<NOMBRES_MESAS.length){
			if (NOMBRES_MESAS[i].equals(bloqueOMesa)){
				registrado=true;
			}else{
				i++;
			}
		}
		return registrado;
		
	}
	
	private boolean esValida(String bloque){
		boolean valida=true;
				
		if (esBloque(bloque)){
			int posicion=-1;
			if (bloque.equals(NOMBRES_BLOQUES[0])){
				if (listaSobre[0].equals(bloque) //El bloque no puede estar sobre si mismo  
					|| listaSobre[0].equals(listaSobre[1])//El bloque A no puede estar sobre la misma posicion que B
					|| (listaSobre[0].equals(NOMBRES_BLOQUES[1]) && listaVertical[1] && !listaVertical[0])//El bloque A no puede estar horizontalmente sobre el bloque B verticalmente
					|| (esMesa(listaSobre[0]) && listaVertical[0])){//El bloque A no puede estar verticalmente sobre una mesa
					
					valida=false;
				}
				posicion=0;
			}else if (bloque.equals(NOMBRES_BLOQUES[1])){
				if (listaSobre[1].equals(bloque) //El bloque no puede estar sobre si mismo  
						|| listaSobre[1].equals(listaSobre[0])//El bloque B no puede estar sobre la misma posicion que A
						|| (listaSobre[1].equals(NOMBRES_BLOQUES[0]) && listaVertical[0] && !listaVertical[1]) //El bloque B no puede estar horizontalmente sobre el bloque A verticalmente
						|| (esMesa(listaSobre[1]) && listaVertical[1])){//El bloque B no puede estar verticalmente sobre una mesa	
					valida=false;
					}
				posicion=1;
			}
			if (valida){
				valida=esBloque(listaSobre[posicion]) || esMesa(listaSobre[posicion]);;
			}
		}else{
			valida=false;
		}
		return valida;
	}
	
	public String dameSobreA(){
		return listaSobre[0];
	}
	
	public String dameSobreB(){
		return listaSobre[1];
	}
	
	public boolean dameVerticalA(){
		return listaVertical[0];
	}
	
	public boolean dameVerticalB(){
		return listaVertical[1];
	}
	
	
	public int dameAlturaA(){
		int altura=1;
		String posicionA=listaSobre[0];
		if (posicionA.equals(NOMBRES_BLOQUES[1])){
			altura=dameAlturaB()+1;
		}
		return altura;
	}
	
	public int dameAlturaB(){
		int altura=1;
		String posicionB=listaSobre[1];
		if (posicionB.equals(NOMBRES_BLOQUES[0])){
			altura=dameAlturaA()+1;
		}
		return altura;
	}
	
	public String dameMesa(String bloqueOMesa){
		String mesa=null;
		if (esBloque(bloqueOMesa)){
			String bajoBloque=null; 
			if (bloqueOMesa.equals(NOMBRES_BLOQUES[0])){
				bajoBloque=listaSobre[0];
			}else if (bloqueOMesa.equals(NOMBRES_BLOQUES[1])){
				bajoBloque=listaSobre[1];
			}
			mesa=dameMesa(bajoBloque);
		}else if (esMesa(bloqueOMesa)){
			mesa=bloqueOMesa;
		}
		return mesa;
	}
	
	public String dameCima(String bloqueOMesa){
		String buscado=bloqueOMesa;
		int i=0;
		while (i<listaSobre.length){
			if (listaSobre[i].equals(buscado)){
				buscado=NOMBRES_BLOQUES[i];
				i=0;
			}else{
				i++;
			}
		}
		return buscado;
	}
	
	
	
	public String toString(){
		StringBuffer sb=new StringBuffer();

		sb.append("(A sobre "+listaSobre[0]);
		if (listaVertical[0]){
			sb.append(" en vertical, ");
		}else{
			sb.append(" en horizontal, ");
		}
		sb.append(" B sobre "+listaSobre[1]);
		if (listaVertical[1]){
			sb.append(" en vertical");
		}else{
			sb.append(" en horizontal");
		}
		sb.append(")");
		return sb.toString();		
	}
	
	public boolean equals(Object comparado){
		boolean igual=false;
		if (comparado instanceof EstadoBloquesConOrientacion){
			EstadoBloquesConOrientacion estadoBloques=(EstadoBloquesConOrientacion) comparado;
			igual= listaSobre[0].equals(estadoBloques.dameSobreA()) 
				&& listaSobre[1].equals(estadoBloques.dameSobreB())
				&& listaVertical[0]==estadoBloques.dameVerticalA() 
				&& listaVertical[1]==estadoBloques.dameVerticalB();
		}
		return igual;
	}
	
}
