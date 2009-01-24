/**
 * 
 */
package com.iaic.problems.eightPuzzle;

import problema.interfacesFunciones.FuncionHeuristica;



/**
 * @author alberto
 *
 */
public class ochoPuzzleHeuristicaManhattan implements FuncionHeuristica {
	//public ochoPuzzleHeuristicaManhattan() {}
	
	private class coordenadas {
		int x,y;
		public coordenadas() {x=-1;y=-1;}
		public void setX(int a) {x=a;}
		public void setY(int a) {y=a;}
		public int getX() {return x;}
		public int getY() {return y;}
	}
	
	/* (non-Javadoc)
	 * @see problema.interfacesFunciones.FuncionHeuristica#valorHeuristico(java.lang.Object)
	 */
	@Override
	public double valorHeuristico(Object estado) {
		EightPuzzleState e=(EightPuzzleState)estado;
		EightPuzzleState obj=new EightPuzzleState();
		obj.hacerObjetivo();
		double suma=0;
		for (int i=0;i<=8;i++) {
			coordenadas ec=new coordenadas(),oc=new coordenadas();
			//Integer xx=new Integer(-1),yy=new Integer(-1),xxx=new Integer(-1),yyy=new Integer(-1);
			estaEn(i,e,ec);
			estaEn(i,obj,oc);
			suma+=Math.abs(ec.getX()-oc.getX());
			suma+=Math.abs(ec.getY()-oc.getY());		
		}
		return suma;
	}
	
	private void estaEn(int i,EightPuzzleState e,coordenadas o) {
		boolean encontrado=false;
		for (int x=0;x<3&&!encontrado;x++)
			for (int y=0;y<3&&!encontrado;y++)
				if (e.obtenerPieza(x, y)==i) {
					o.setX(x);o.setY(y);encontrado=true;
				}					
	}

}

