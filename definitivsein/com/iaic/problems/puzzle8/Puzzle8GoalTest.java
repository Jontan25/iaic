package com.iaic.problems.puzzle8;

import com.iaic.problems.puzzle3.Puzzle3State;
import com.iaic.problems.puzzle8.Puzzle8State;

import aima.search.framework.GoalTest;

public class Puzzle8GoalTest implements GoalTest {
	Puzzle8State estadoFinal;
	
	public Puzzle8GoalTest(){
		int []mat=new int[9];
		mat[0]=0;
		mat[1]=1;
		mat[2]=2;
		mat[3]=5;
		mat[4]=8;
		mat[5]=7;
		mat[6]=6;
		mat[7]=3;
		mat[8]=4;
		try{
			this.estadoFinal=new Puzzle8State(mat);
		}catch(Exception e){
		}
	}
	public Puzzle8GoalTest(Puzzle8State estado){
		try{
			this.estadoFinal=new Puzzle8State();
			this.estadoFinal=estado;
		}catch(Exception e){
		}
	}
	
	public boolean isGoalState(Object estado) {
		Puzzle8State puzzle8State= (Puzzle8State) estado;
		return (puzzle8State.dameUno()==estadoFinal.dameUno() && puzzle8State.dameDos()==estadoFinal.dameDos() &&
				puzzle8State.dameTres()==estadoFinal.dameTres() &&puzzle8State.dameCuatro()==estadoFinal.dameCuatro() &&
				puzzle8State.dameCinco()==estadoFinal.dameCinco() && puzzle8State.dameSeis()==estadoFinal.dameSeis() &&
				puzzle8State.dameSiete()==estadoFinal.dameSiete() &&puzzle8State.dameOcho()==estadoFinal.dameOcho() &&
				puzzle8State.dameHueco()==estadoFinal.dameHueco());
	}

}
