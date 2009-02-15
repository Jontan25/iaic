package com.iaic.problems.puzzle8;

import java.util.List;
import java.util.Vector;

import com.iaic.problems.puzzle8.Puzzle8State;


import aima.search.framework.Successor;
import aima.search.framework.SuccessorFunction;

public class Puzzle8SuccessorFunction implements SuccessorFunction{
	public static String[] ACCIONES={"moverHuecoArriba","moverHuecoAbajo","moverHuecoIzquierda","moverHuecoDerecha"};

	public List getSuccessors(Object estado){
		List movimientos=new Vector();
		Puzzle8State puzzle8State= (Puzzle8State) estado;
		Puzzle8State nuevoEstado = new Puzzle8State();
		nuevoEstado.matriz=(int[])puzzle8State.matriz.clone();
		switch (puzzle8State.matriz[8]){
			case '0':{
				nuevoEstado.matriz[8]=3;
				int i=0;
				boolean enc=false;
				while(i<8&&!enc){
					if(nuevoEstado.matriz[i]==3){
						enc=true;
						nuevoEstado.matriz[i]=0;
					}
					i++;
				}
				movimientos.add(new Successor(ACCIONES[1],nuevoEstado));
				nuevoEstado.matriz[8]=1;
				i=0;
				enc=false;
				while(i<8&&!enc){
					if(nuevoEstado.matriz[i]==1){
						enc=true;
						nuevoEstado.matriz[i]=0;
					}
					i++;
				}
				movimientos.add(new Successor(ACCIONES[3],nuevoEstado));
				break;
			}
			case '1':{
				nuevoEstado.matriz[8]=4;
				int i=0;
				boolean enc=false;
				while(i<8&&!enc){
					if(nuevoEstado.matriz[i]==4){
						enc=true;
						nuevoEstado.matriz[i]=1;
					}
					i++;
				}
				movimientos.add(new Successor(ACCIONES[1],nuevoEstado));
				nuevoEstado.matriz[8]=2;
				i=0;
				enc=false;
				while(i<8&&!enc){
					if(nuevoEstado.matriz[i]==2){
						enc=true;
						nuevoEstado.matriz[i]=1;
					}
					i++;
				}
				movimientos.add(new Successor(ACCIONES[3],nuevoEstado));
				nuevoEstado.matriz[8]=0;
				i=0;
				enc=false;
				while(i<8&&!enc){
					if(nuevoEstado.matriz[i]==0){
						enc=true;
						nuevoEstado.matriz[i]=1;
					}
					i++;
				}
				movimientos.add(new Successor(ACCIONES[2],nuevoEstado));
				break;
			}
			case '2':{
				nuevoEstado.matriz[8]=5;
				int i=0;
				boolean enc=false;
				while(i<8&&!enc){
					if(nuevoEstado.matriz[i]==5){
						enc=true;
						nuevoEstado.matriz[i]=2;
					}
					i++;
				}
				movimientos.add(new Successor(ACCIONES[1],nuevoEstado));
				nuevoEstado.matriz[8]=1;
				i=0;
				enc=false;
				while(i<8&&!enc){
					if(nuevoEstado.matriz[i]==1){
						enc=true;
						nuevoEstado.matriz[i]=2;
					}
					i++;
				}
				movimientos.add(new Successor(ACCIONES[2],nuevoEstado));
				break;
			}
			case '3':{
				nuevoEstado.matriz[8]=0;
				int i=0;
				boolean enc=false;
				while(i<8&&!enc){
					if(nuevoEstado.matriz[i]==0){
						enc=true;
						nuevoEstado.matriz[i]=3;
					}
					i++;
				}
				movimientos.add(new Successor(ACCIONES[0],nuevoEstado));
				nuevoEstado.matriz[8]=6;
				i=0;
				enc=false;
				while(i<8&&!enc){
					if(nuevoEstado.matriz[i]==6){
						enc=true;
						nuevoEstado.matriz[i]=3;
					}
					i++;
				}
				movimientos.add(new Successor(ACCIONES[1],nuevoEstado));
				nuevoEstado.matriz[8]=4;
				i=0;
				enc=false;
				while(i<8&&!enc){
					if(nuevoEstado.matriz[i]==4){
						enc=true;
						nuevoEstado.matriz[i]=3;
					}
					i++;
				}
				movimientos.add(new Successor(ACCIONES[3],nuevoEstado));
				
				break;
			}
			case '4':{
				nuevoEstado.matriz[8]=1;
				int i=0;
				boolean enc=false;
				while(i<8&&!enc){
					if(nuevoEstado.matriz[i]==1){
						enc=true;
						nuevoEstado.matriz[i]=4;
					}
					i++;
				}
				movimientos.add(new Successor(ACCIONES[0],nuevoEstado));
				nuevoEstado.matriz[8]=7;
				i=0;
				enc=false;
				while(i<8&&!enc){
					if(nuevoEstado.matriz[i]==7){
						enc=true;
						nuevoEstado.matriz[i]=4;
					}
					i++;
				}
				movimientos.add(new Successor(ACCIONES[1],nuevoEstado));
				nuevoEstado.matriz[8]=5;
				i=0;
				enc=false;
				while(i<8&&!enc){
					if(nuevoEstado.matriz[i]==5){
						enc=true;
						nuevoEstado.matriz[i]=4;
					}
					i++;
				}
				movimientos.add(new Successor(ACCIONES[3],nuevoEstado));
				nuevoEstado.matriz[8]=3;
				i=0;
				enc=false;
				while(i<8&&!enc){
					if(nuevoEstado.matriz[i]==3){
						enc=true;
						nuevoEstado.matriz[i]=4;
					}
					i++;
				}
				movimientos.add(new Successor(ACCIONES[2],nuevoEstado));
				break;
			}
			case '5':{
				nuevoEstado.matriz[8]=2;
				int i=0;
				boolean enc=false;
				while(i<8&&!enc){
					if(nuevoEstado.matriz[i]==2){
						enc=true;
						nuevoEstado.matriz[i]=5;
					}
					i++;
				}
				movimientos.add(new Successor(ACCIONES[0],nuevoEstado));
				nuevoEstado.matriz[8]=8;
				i=0;
				enc=false;
				while(i<8&&!enc){
					if(nuevoEstado.matriz[i]==8){
						enc=true;
						nuevoEstado.matriz[i]=5;
					}
					i++;
				}
				movimientos.add(new Successor(ACCIONES[1],nuevoEstado));
				nuevoEstado.matriz[8]=4;
				i=0;
				enc=false;
				while(i<8&&!enc){
					if(nuevoEstado.matriz[i]==4){
						enc=true;
						nuevoEstado.matriz[i]=5;
					}
					i++;
				}
				movimientos.add(new Successor(ACCIONES[2],nuevoEstado));
				break;
			}
			case '6':{
				nuevoEstado.matriz[8]=3;
				int i=0;
				boolean enc=false;
				while(i<8&&!enc){
					if(nuevoEstado.matriz[i]==3){
						enc=true;
						nuevoEstado.matriz[i]=6;
					}
					i++;
				}
				movimientos.add(new Successor(ACCIONES[0],nuevoEstado));
				nuevoEstado.matriz[8]=7;
				i=0;
				enc=false;
				while(i<8&&!enc){
					if(nuevoEstado.matriz[i]==7){
						enc=true;
						nuevoEstado.matriz[i]=6;
					}
					i++;
				}
				movimientos.add(new Successor(ACCIONES[3],nuevoEstado));
				break;
			}
			case '7':{
				nuevoEstado.matriz[8]=4;
				int i=0;
				boolean enc=false;
				while(i<8&&!enc){
					if(nuevoEstado.matriz[i]==4){
						enc=true;
						nuevoEstado.matriz[i]=7;
					}
					i++;
				}
				movimientos.add(new Successor(ACCIONES[0],nuevoEstado));
				nuevoEstado.matriz[8]=8;
				i=0;
				enc=false;
				while(i<8&&!enc){
					if(nuevoEstado.matriz[i]==8){
						enc=true;
						nuevoEstado.matriz[i]=7;
					}
					i++;
				}
				movimientos.add(new Successor(ACCIONES[3],nuevoEstado));
				nuevoEstado.matriz[8]=6;
				i=0;
				enc=false;
				while(i<8&&!enc){
					if(nuevoEstado.matriz[i]==6){
						enc=true;
						nuevoEstado.matriz[i]=7;
					}
					i++;
				}
				movimientos.add(new Successor(ACCIONES[2],nuevoEstado));
				break;
			}
			case '8':{
				nuevoEstado.matriz[8]=5;
				int i=0;
				boolean enc=false;
				while(i<8&&!enc){
					if(nuevoEstado.matriz[i]==5){
						enc=true;
						nuevoEstado.matriz[i]=8;
					}
					i++;
				}
				movimientos.add(new Successor(ACCIONES[0],nuevoEstado));
				nuevoEstado.matriz[8]=7;
				i=0;
				enc=false;
				while(i<8&&!enc){
					if(nuevoEstado.matriz[i]==7){
						enc=true;
						nuevoEstado.matriz[i]=8;
					}
					i++;
				}
				movimientos.add(new Successor(ACCIONES[2],nuevoEstado));
				break;
			}
		}
		return movimientos;
	}

}
