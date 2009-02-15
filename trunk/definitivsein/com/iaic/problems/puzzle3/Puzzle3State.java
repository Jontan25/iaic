package com.iaic.problems.puzzle3;

import java.util.*;

import com.iaic.problems.puzzle3.Puzzle3GoalTest;


public class Puzzle3State {
	int one;
	int two;
	int three;
	int hole;
	
	public Puzzle3State() throws Exception{
		this.CreateRandomState();
	}
	
	public Puzzle3State (int uno,int dos,int tres,int hueco) throws Exception{
		if (uno>3||dos>3||tres>3||hueco>3){
			throw new Exception("Estado no valido: los valores se salen del rango permitido");
		}
		
		if (uno<0||dos<0||tres<0||hueco<0){
			throw new Exception("Estado no valido: los valores se salen del rango permitido");
		}
		
		if (uno==dos||uno==tres||uno==hueco||
			dos==tres||dos==hueco||
			tres==hueco){
			throw new Exception("Estado no valido: los valores se salen del rango permitido");
		}
		this.one=uno;
		this.two=dos;
		this.three=tres;
		this.hole=hueco;
	}

	public void CreateRandomState (){
		Random rand = new Random();
		this.one=rand.nextInt(4);
		this.two=rand.nextInt(4);
		this.three=rand.nextInt(4);
		this.hole=rand.nextInt(4);
		boolean encontrado=false;
		Puzzle3GoalTest g;
		try {
			g = new Puzzle3GoalTest(new Puzzle3State());
			while(!encontrado||g.isGoalState(this)){
				encontrado=true;
				this.one=rand.nextInt(4);
				this.two=rand.nextInt(4);
				this.three=rand.nextInt(4);
				this.hole=rand.nextInt(4);
				while(this.two==this.one){
					this.two=rand.nextInt(4);
				}
				while(this.three==this.one||this.three==this.two){
					this.three=rand.nextInt(4);
				}
				while(this.hole==this.one||this.hole==this.two||this.hole==this.three){
					this.hole=rand.nextInt(4);
				}
				
				if (one>3||two>3||three>3||hole>3){
					encontrado=false;
				}
				if (one<0||two<0||three<0||hole<0){
					encontrado=false;
				}
				if (one==two||one==three||one==hole||
					two==three||two==hole||
					three==hole){
					encontrado=false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int damePosicionX(int numero){
		int posicion=-1;
		if (numero==1){
			posicion=one;
		}else if (numero==2){
			posicion=two;
		}else if (numero==3){
			posicion=three;
		}
		return posicion%2;
	}
	
	public int damePosicionY(int numero){
		int posicion=-1;
		if (numero==1){
			posicion=one;
		}else if (numero==2){
			posicion=two;
		}else if (numero==3){
			posicion=three;
		}
		return posicion/2;
	}
	
	public int dameUno(){
		return one;
		
	}
	
	public int dameDos(){
		return two;
		
	}
	public int dameTres(){
		return three;
		
	}
	public int dameHueco(){
		return hole;
		
	}
	
	public String toString(){
		StringBuffer sb=new StringBuffer();
		sb.append("Posición one: ");
		if(one==0){
			sb.append("arriba izquierda");
		}
		else if(one==1){
			sb.append("arriba derecha");
		}
		else if(one==2){
			sb.append("abajo izquierda");
		}
		else{
			sb.append("abajo derecha");
		}
		sb.append(", Posición two: ");
		if(two==0){
			sb.append("arriba izquierda");
		}
		else if(two==1){
			sb.append("arriba derecha");
		}
		else if(two==2){
			sb.append("abajo izquierda");
		}
		else{
			sb.append("abajo derecha");
		}
		sb.append(", Posición three: ");
		if(three==0){
			sb.append("arriba izquierda");
		}
		else if(three==1){
			sb.append("arriba derecha");
		}
		else if(three==2){
			sb.append("abajo izquierda");
		}
		else{
			sb.append("abajo derecha");
		}
		sb.append(", Posición hole: ");
		if(hole==0){
			sb.append("arriba izquierda");
		}
		else if(hole==1){
			sb.append("arriba derecha");
		}
		else if(hole==2){
			sb.append("abajo izquierda");
		}
		else{
			sb.append("abajo derecha");
		}
		return sb.toString();
	}
	
	public boolean equals(Object comparado){
		boolean igual=false;
		if (comparado instanceof Puzzle3State){
			Puzzle3State estadoPuzzle3Comparado=(Puzzle3State) comparado;
			igual= one==estadoPuzzle3Comparado.dameUno() 
				&& two==estadoPuzzle3Comparado.dameDos() 
				&& three==estadoPuzzle3Comparado.dameTres()
				&& hole==estadoPuzzle3Comparado.dameHueco();
		}
		return igual;
	}

	public int compareTo(Object comparado){
		int comparacion=-1;
		if (this.equals(comparado)){
			comparacion=0;
		}else{
			if (comparado instanceof Puzzle3State){
				Puzzle3State estadoPuzzle3Comparado=(Puzzle3State) comparado;
				
				int unoInt=one-estadoPuzzle3Comparado.dameUno(); 
				int dosInt=two-estadoPuzzle3Comparado.dameDos(); 
				int tresInt=three-estadoPuzzle3Comparado.dameTres();
				int huecoInt=hole-estadoPuzzle3Comparado.dameHueco();
				comparacion=unoInt+dosInt+tresInt+huecoInt;
			}
		}
		return comparacion;
	}

}