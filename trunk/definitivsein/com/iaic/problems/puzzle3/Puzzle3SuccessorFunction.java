package com.iaic.problems.puzzle3;

import java.util.List;
import java.util.Vector;

import com.iaic.problems.puzzle3.Puzzle3State;


import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

public class Puzzle3SuccessorFunction implements SuccessorFunction{
	public static String[] ACCIONES={"moverHuecoArriba","moverHuecoAbajo","moverHuecoIzquierda","moverHuecoDerecha"};

	public List getSuccessors(Object estado) {
		List movimientos=new Vector();
		Puzzle3State puzzle3State= (Puzzle3State) estado;
		Puzzle3State nuevoEstado;
		int uno=puzzle3State.dameUno();
		int dos=puzzle3State.dameDos();
		int tres=puzzle3State.dameTres();
		int hueco=puzzle3State.dameHueco();
		if(hueco!=0&&hueco!=1){
			try {
				if(hueco==2){
					if(uno==0) nuevoEstado=new Puzzle3State(2,dos,tres,0);
					else if(dos==0)	nuevoEstado=new Puzzle3State(uno,2,tres,0);
					else nuevoEstado=new Puzzle3State(uno,dos,2,0);
				}
				else{
					if(uno==1) nuevoEstado=new Puzzle3State(3,dos,tres,1);
					else if(dos==1)	nuevoEstado=new Puzzle3State(uno,3,tres,1);
					else nuevoEstado=new Puzzle3State(uno,dos,3,1);
				}
				movimientos.add(new Successor(ACCIONES[0],nuevoEstado));
			} catch (Exception e) {
			}
		}
		if(hueco!=2&&hueco!=3){
			try {
				if(hueco==0){
					if(uno==2) nuevoEstado=new Puzzle3State(0,dos,tres,2);
					else if(dos==2)	nuevoEstado=new Puzzle3State(uno,0,tres,2);
					else nuevoEstado=new Puzzle3State(uno,dos,0,2);
				}
				else{
					if(uno==3) nuevoEstado=new Puzzle3State(1,dos,tres,3);
					else if(dos==3)	nuevoEstado=new Puzzle3State(uno,1,tres,3);
					else nuevoEstado=new Puzzle3State(uno,dos,1,3);
				}
				movimientos.add(new Successor(ACCIONES[1],nuevoEstado));
			} catch (Exception e) {
			}
		}
		if(hueco!=0&&hueco!=2){
			try {
				if(hueco==1){
					if(uno==0) nuevoEstado=new Puzzle3State(1,dos,tres,0);
					else if(dos==0)	nuevoEstado=new Puzzle3State(uno,1,tres,0);
					else nuevoEstado=new Puzzle3State(uno,dos,1,0);
				}
				else{
					if(uno==2) nuevoEstado=new Puzzle3State(3,dos,tres,2);
					else if(dos==2)	nuevoEstado=new Puzzle3State(uno,3,tres,2);
					else nuevoEstado=new Puzzle3State(uno,dos,3,2);
				}
				movimientos.add(new Successor(ACCIONES[2],nuevoEstado));
			} catch (Exception e) {
			}
		}
		if(hueco!=1&&hueco!=3){
			try {
				if(hueco==0){
					if(uno==1) nuevoEstado=new Puzzle3State(0,dos,tres,1);
					else if(dos==1)	nuevoEstado=new Puzzle3State(uno,0,tres,1);
					else nuevoEstado=new Puzzle3State(uno,dos,0,1);
				}
				else{
					if(uno==3) nuevoEstado=new Puzzle3State(2,dos,tres,3);
					else if(dos==3)	nuevoEstado=new Puzzle3State(uno,2,tres,3);
					else nuevoEstado=new Puzzle3State(uno,dos,2,3);
				}
				movimientos.add(new Successor(ACCIONES[3],nuevoEstado));
			} catch (Exception e) {
			}
		}
		return movimientos;
	}

}

