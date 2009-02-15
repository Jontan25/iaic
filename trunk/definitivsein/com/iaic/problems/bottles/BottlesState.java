/**
 * 
 */
package com.iaic.problems.bottles;

import java.util.Random;

import com.iaic.problems.bottles.BottlesGoalTest;

/**
 * @author Enrique López Mañas
 */

public class BottlesState {
	private int _bottle1;
	private int _bottle2;
	
	public BottlesState( ){
		_bottle1 = 0;
		_bottle2 = 0;
	}
	
	public BottlesState ( int bottle1 , int bottle2 ) throws Exception{
		if ( bottle1 > 4 || bottle2 > 3 ){
			throw new Exception("Estado no valido: Límite de capacidades sobrepasado");
		}
		this._bottle1 = bottle1;
		this._bottle2 = bottle2;
	}
	
	public int getBottle1( ){
		return _bottle1;
		
	}
	
	public int getBottle2( ){
		return _bottle2;
		
	}
	
	public String toString( ){
		StringBuffer sb=new StringBuffer();
		sb.append("Garrafa1: ");
		sb.append(_bottle1);
     	sb.append(", Garrafa2:");
		sb.append(_bottle2);
		return sb.toString(  );
	}
	
	public boolean equals( Object compared ){
		boolean gleich = false;
		if ( compared instanceof BottlesState ){
			BottlesState bottlesStateCompared = ( BottlesState ) compared;
			gleich= _bottle1 == bottlesStateCompared.getBottle1( ) 
				&& _bottle2 == bottlesStateCompared.getBottle2( );
		}
		return gleich;
	}

	public int compareTo( Object compared ){
		int comparation = -1;
		if ( this.equals ( compared ) ) {
			comparation = 0 ;
		} else {
			if ( compared instanceof BottlesState ){
				BottlesState bottlesStateCompared = (BottlesState) compared;
				int ac1 =_bottle1+_bottle2;
				int ac2 = bottlesStateCompared.getBottle1( ) + bottlesStateCompared.getBottle2( ) ;
				if(ac1<ac2)
					comparation = ac2 - ac1;
				else
					comparation = ac1 - ac2;
			}
		}
		return comparation;
	}

}