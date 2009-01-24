/**
 * Hanoi Towers Problem. Using three different discs of three differents sizes in a given initial position we have to 
 * achieve a final state where the three discs are located in a different position. Initally the discs are located 
 * as the following draw:
 * 
 *   First Mast             Second Mast			Third Mast
 *   
 *     Small Disc               Empty 				Empty
 *     Medium Disc				Empty				Empty
 *     Big Disc					Empty				Empty
 *     
 * The final state must be considered as follows:
 * 
 * 
 *  First Mast             Second Mast			Third Mast
 *   
 *     Empty                    Empty 				Small Disc
 *     Empty				    Empty				Medium Disc
 *     Empty					Empty				Big Disc
 */
package com.iaic.problems.hanoi;

public class HanoiState {

	/*From 1 to 2*/
	
	private int posSmallDisc;
	
	private int posMediumDisc;
	
	private int posBigDisc;
	
	/*From 1 to 3*/
	
	private int mastSmallDisc;
	
	private int mastMediumDisc;
	
	private int mastBigDisc;
	
	
	public HanoiState() {
		this.posSmallDisc = 1;
		this.posMediumDisc = 2;
		this.posBigDisc = 3;
		
		this.mastSmallDisc = 1;
		this.mastMediumDisc = 1;
		this.mastBigDisc = 1;		
	}
	
	public void objectiveState( ) {
		this.posSmallDisc = 1;
		this.posMediumDisc = 2;
		this.posBigDisc = 3;
		
		this.mastSmallDisc = 3;
		this.mastMediumDisc = 3;
		this.mastBigDisc = 3;
	}
	
	public boolean isObjectiveState( ) {
		return ( this.posSmallDisc == 1 && this.posMediumDisc == 2 && this.posBigDisc == 3 &&
				 this.mastSmallDisc == 3 && this.mastMediumDisc == 3 && this.mastBigDisc == 3);
	}
	
	public int whichMastIsSmall( ) {
		return this.mastSmallDisc;
	}
	
	
	public int whichPosIsSmall( ){
		return this.posSmallDisc;
	}
	
	public int whichMastIsMedium( ) {
		return this.mastMediumDisc;
	}
	
	
	public int whichPosIsMedium( ){
		return this.posMediumDisc;
	}
	
	public int whichMastIsBig( ) {
		return this.mastBigDisc;
	}
	
	
	public int whichPosIsBig( ){
		return this.posBigDisc;
	}
	
	public void moveFromFirstToSecond( ) {
		//If we have to move the small disc...
		if ( this.mastSmallDisc == 1) {
			//Direct Move
			this.mastSmallDisc = 2;
			//If there are two more discs...
			if ( this.mastMediumDisc == 2 && this.mastBigDisc == 2 )
				this.posSmallDisc = 1;
			//... else, if there is either one of other two discs...
			else if (this.mastMediumDisc == 2|| this.mastBigDisc == 2)
				this.posSmallDisc = 2;
			else
			//...else, if there is nothing else
				this.posSmallDisc = 3;
			//If we have to move the medium disc...
		} else if (this.mastMediumDisc == 1) {
			this.mastMediumDisc
			//If there is no small disc..
			if (this.mastSmallDisc != 2 ) 
				//...and no big disc...
				if (this.mastBigDisc != 2)
					this.posMediumDisc = 3;
				
			
		}
	}
	
	public void moveFromFirstToThird( ) {
		if ( this.mastSmallDisc == 1) {
			this.mastSmallDisc = 2;
			if ( this.mastMediumDisc == 2 && this.mastBigDisc == 2 )
				this.posSmallDisc = 1;
			else if (this.mastMediumDisc == 2|| this.mastBigDisc == 2)
				this.posSmallDisc = 2;
			else
				this.posSmallDisc = 3;
			
		}	
	}
	
	public void moveFromSecondToThird( ) {
		
	}
	
	public void moveFromSecondToFirst( ) {
		
	}
	
	public void moveFromThirdToSecond( ) {
		
	}

	public void moveFromThirdToFirst( ) {
	
}
}
