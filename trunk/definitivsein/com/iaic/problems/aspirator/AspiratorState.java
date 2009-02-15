package com.iaic.problems.aspirator;

/**
 * @author Enrique López Mañas
 */

public class AspiratorState {
	
	public static final int RIGHT = 2;
	public static final int LEFT = 0;
	int _aspiratorPosition;
	boolean[] _roomCleaning;
	
	public AspiratorState (){
		this._aspiratorPosition=0;
		_roomCleaning=new boolean[3];
		_roomCleaning[0]=false;//Room on the dirty left
		_roomCleaning[1]=false;//Room on the dirty center
		_roomCleaning[2]=false;//Room on the dirty right
	}
	
	public AspiratorState ( int robotPosition , boolean cleaningLeft , boolean cleaningCenter , boolean cleaningRight){
		this._aspiratorPosition=robotPosition;
		_roomCleaning=new boolean[3];
		_roomCleaning[0]=cleaningLeft;//Cleaning room on the left
		_roomCleaning[1]=cleaningCenter;//Cleaning room on the center
		_roomCleaning[2]=cleaningRight;//Cleaning room on the right
	}
	
	public int getAspiratorPositon(){
		return _aspiratorPosition;	
	}
	
	public boolean getLeftCleaning(){
		return _roomCleaning[0];	
	}
	
	public boolean getMiddleCleaning(){
		return _roomCleaning[1];	
	}
	
	public boolean getRightCleaning(){
		return _roomCleaning[2];	
	}
	
	public boolean getAspiratorCleaning() {
		return _roomCleaning[_aspiratorPosition];
	}
	
	public String toString(){
		StringBuffer sb=new StringBuffer();
		sb.append("(Aspirator: ");
		if ( _aspiratorPosition == 0 ){
			sb.append( "Left" );
		} else if ( _aspiratorPosition == 1 ) {
			sb.append("Center");
		} else if ( _aspiratorPosition==2){
			sb.append( "Right" );
		}
		
		sb.append(", Left: ");
		if ( _roomCleaning[0] ){
			sb.append("Cleany");
		} else {
			sb.append( "Dirty" );
		}
		sb.append(", Center: ");
		if ( _roomCleaning[1] ){
			sb.append( "Clean" );
		} else {
			sb.append( "Dirty" );
		}
		sb.append(", Right: ");
		if ( _roomCleaning[2] ){
			sb.append( "Cleany" );
		} else {
			sb.append( "Dirty" );
		}
		
		sb.append(")");
		return sb.toString();		
	}
	
	public boolean equals(Object compared){
		boolean equal = false;
		if ( compared instanceof AspiratorState ){
			AspiratorState aspiratorState = ( AspiratorState ) compared;
			equal = _aspiratorPosition==aspiratorState.getAspiratorPositon( ) 
				&& _roomCleaning[0] == aspiratorState.getLeftCleaning( ) 
				&& _roomCleaning[1] == aspiratorState.getMiddleCleaning( ) 
				&& _roomCleaning[2] == aspiratorState.getRightCleaning( );
		}
		return equal;
	}
	
}
