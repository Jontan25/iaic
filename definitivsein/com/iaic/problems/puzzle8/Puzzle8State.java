package com.iaic.problems.puzzle8;

import java.util.Random;

import com.iaic.problems.puzzle8.Puzzle8State;



public class Puzzle8State implements Comparable{
	/*int one;
	int two;
	int three;
	int cuatro;
	int cinco;
	int seis;
	int siete;
	int ocho;
	int hole;*/
	int matriz[];

	public Puzzle8State(){
		matriz=new int[9];
	}
	
//	int one,int two,int three,	int cuatro,int cinco,int seis,int siete,int ocho,int hole
	
	public Puzzle8State (int mat[]) throws Exception{
		matriz=new int[9];
		//comprobamos que no sea un estado de peligro
		//todos los valores menores o iguales a 3
		if(mat.length==9){
			for(int i=0;i<9;i++){
				if(mat[i]>8||mat[i]<0){
					throw new Exception("Estado no valido: los valores se salen del rango permitido");
				}
				else{
					for(int j=0;j<9;j++){
						if(mat[i]==mat[j]&&i!=j)
							throw new Exception("Estado no valido: hay two fichas en la misma posición");
					}
				}
			}
			matriz=(int[])mat.clone();
		}
		else throw new Exception("Los data de entrada no son válidos: faltan valores");
/*		this.uno=one;
		this.dos=two;
		this.tres=three;
		this.hueco=hole;*/
	}
	
	public void CrearEstadoAleatorio (){
		matriz=new int[9];
		Random rand = new Random();
		for(int k=0;k<9;k++)
			matriz[k]=rand.nextInt(9);
		boolean encontrado=false;
		boolean enc=false;
		Puzzle8GoalTest g=new Puzzle8GoalTest(new Puzzle8State());
		while(!encontrado||g.isGoalState(this)){
			encontrado=true;
			for(int i=0;i<9;i++){
				enc=false;
				while(!enc&&!(matriz[i]>8||matriz[i]<0)){
					enc=true;
					matriz[i]=rand.nextInt(9);
					for(int j=0;j<9;j++){
						if(matriz[i]==matriz[j]&&i!=j) enc=false;
					}
				}
			}
		}		
	}
	
	public int dameUno(){
		return matriz[0];
		
	}
	public int dameDos(){
		return matriz[1];
		
	}
	public int dameTres(){
		return matriz[2];
		
	}
	public int dameCuatro(){
		return matriz[3];
		
	}
	
	public int dameCinco(){
		return matriz[4];
		
	}
	public int dameSeis(){
		return matriz[5];
		
	}
	public int dameSiete(){
		return matriz[6];
		
	}
	
	public int dameOcho(){
		return matriz[7];
		
	}
	public int dameHueco(){
		return matriz[8];
		
	}
	
	public int[] dameMatriz(){
		return matriz;
		
	}
	
	public int damePosicionX(int numero){
		int posicion=-1;
		posicion=matriz[numero-1];
		return posicion%2;
	}
	
	public int damePosicionY(int numero){
		int posicion=-1;
		posicion=matriz[numero-1];
		return posicion/2;
	}
	
	public String toString(){
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<9;i++){
			sb.append("Ficha "+(int)(i+1)+": ");
			if(matriz[i]==0){
				sb.append("arriba izquierda,  ");
			}
			if(matriz[i]==1){
				sb.append("arriba centro, ");
			}
			if(matriz[i]==2){
				sb.append("arriba derecha, ");
			}
			if(matriz[i]==3){
				sb.append("centro izquierda, ");
			}
			if(matriz[i]==4){
				sb.append("centro centro, ");
			}
			if(matriz[i]==5){
				sb.append("centro derecha, ");
			}
			if(matriz[i]==6){
				sb.append("abajo izquierda, ");
			}
			if(matriz[i]==7){
				sb.append("abajo centro, ");
			}
			if(matriz[i]==8){
				sb.append("abajo derecha, ");
			}
		}
		return sb.toString();
	}
	
	public boolean equals(Object comparado){
		boolean igual=true;
		if (comparado instanceof Puzzle8State){
			Puzzle8State estadoPuzzle8Comparado=(Puzzle8State) comparado;
			for(int i=0;i<9;i++){
				if(estadoPuzzle8Comparado.matriz[i]!=matriz[i]) igual=false;
			}
		}
		return igual;
	}
	
	public int compareTo(Object comparado){
		int comparacion=-1;
		if (this.equals(comparado)){
			comparacion=0;
		}else{
			if (comparado instanceof Puzzle8State){
				Puzzle8State estadoPuzzle8Comparado=(Puzzle8State) comparado;
				for(int i=0;i<9;i++){
					comparacion+=matriz[i]-estadoPuzzle8Comparado.matriz[i];
				}
			}
		}
		return comparacion;
	}

}
