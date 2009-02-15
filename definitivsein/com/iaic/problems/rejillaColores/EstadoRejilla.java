package com.iaic.problems.rejillaColores;


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
public class EstadoRejilla {
	
	boolean[][] rejilla;
		
	public EstadoRejilla (){
		rejilla=new boolean[3][3];
		for (int i=0;i<rejilla.length;i++){
			for (int j=0;j<rejilla[0].length;j++){
				rejilla[i][j]=true;
			}
		}
	}
	
	public EstadoRejilla (boolean[][] rejilla) throws Exception{
		int tamanoX=rejilla.length;
		if (tamanoX>0){
			int tamanoY=rejilla[0].length;
			this.rejilla=new boolean[tamanoX][tamanoY];
			for (int i=0;i<rejilla.length;i++){
				for (int j=0;j<rejilla[0].length;j++){
					this.rejilla[i][j]=rejilla[i][j];
				}
			}
		}else{
			throw new Exception("La rejilla pasada esta vacia");
		}
	}
	public boolean damePosicion(int x,int y){
		return rejilla[x][y];	
	}
	
	public int dameTamanoX(){
		return rejilla.length;	
	}
	
	public int dameTamanoY(){
		return rejilla[0].length;	
	}
	
	public int dameNumeroAdyacencias(int x,int y){
		int numAdyacencias=0;
		try {			
			if (rejilla[x-1][y]==rejilla[x][y]){
				numAdyacencias++;;
			}
		}catch (ArrayIndexOutOfBoundsException e){
			//Quiere decir que no tiene casilla a su alrededor y no se cuenta
		}
		try{
			if (rejilla[x+1][y]==rejilla[x][y]){
				numAdyacencias++;;
			}
		}catch (ArrayIndexOutOfBoundsException e){
			//Quiere decir que no tiene casilla a su alrededor y no se cuenta
		}
		try{
			if (rejilla[x][y-1]==rejilla[x][y]){
				numAdyacencias++;;
			}
		}catch (ArrayIndexOutOfBoundsException e){
			//Quiere decir que no tiene casilla a su alrededor y no se cuenta
		}
		try{
			if (rejilla[x][y+1]==rejilla[x][y]){
				numAdyacencias++;;
			}
		}catch (ArrayIndexOutOfBoundsException e){
			//Quiere decir que no tiene casilla a su alrededor y no se cuenta
		}

		return numAdyacencias;	
	}
	
	public boolean[][] dameCopiaDeRejilla(){
		boolean[][] copia={};
		int tamanoX=rejilla.length;
		if (tamanoX>0){
			int tamanoY=rejilla[0].length;
			copia=new boolean[tamanoX][tamanoY];
			for (int i=0;i<rejilla.length;i++){
				for (int j=0;j<rejilla[0].length;j++){
					copia[i][j]=rejilla[i][j];
				}
			}
		}
		return copia;
	}
	
	
	public String toString(){
		StringBuffer sb=new StringBuffer();
		sb.append("{ ");
		for (int i=0;i<rejilla.length;i++){
			sb.append("{ ");
			for (int j=0;j<rejilla[0].length;j++){
				sb.append(rejilla[i][j]);
				sb.append(",");
			}
			sb.deleteCharAt(sb.length()-1);
			sb.append(" }, ");
		}
		sb.deleteCharAt(sb.length()-2);
		sb.append("}");
		return sb.toString();
	}
	
	public boolean equals(Object comparado){
		boolean igual=false;
		if (comparado instanceof EstadoRejilla){
			EstadoRejilla estadoRejilla=(EstadoRejilla) comparado;
			igual=true;
			int i=0;
			int j;
			while (igual && i<rejilla.length){
				j=0;
				while (igual && j<rejilla[0].length){
					igual= rejilla[i][j]==estadoRejilla.damePosicion(i,j);
					j++;
				}
				i++;
			}
		}
		return igual;
	}
	
}
