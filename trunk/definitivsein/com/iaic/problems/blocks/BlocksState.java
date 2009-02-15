package com.iaic.problems.blocks;

/**
 * @author Enrique López Mañas
 */

public class BlocksState {
	String[] _overList;

	public final static String[] TABLE_NAMES={"P","Q","R"};
	public final static String[] BLOCKS_NAMES={"A","B","C"};
	
	public BlocksState (){
		_overList=new String[3];
		_overList[0]=TABLE_NAMES[0];//A over P
		_overList[1]=TABLE_NAMES[1];//B over Q
		_overList[2]=TABLE_NAMES[2];//C over R
	}
	
	public BlocksState (String posicionA,String posicionB,String posicionC) throws Exception{
		_overList=new String[3];
		_overList[0]=posicionA;//A over P
		_overList[1]=posicionB;//B over Q
		_overList[2]=posicionC;//C over R
		
		//We check if this is a dangerous state
		if (!isValid(BLOCKS_NAMES[0]) || !isValid(BLOCKS_NAMES[1]) || !isValid(BLOCKS_NAMES[2])){
			throw new Exception("Non-valid state: Some blocks are bad situated");
		}
	}
	
	public static boolean isBlock( String blockOrTable ){
		boolean registered = false;
		int i=0;
		while (!registered && i<BLOCKS_NAMES.length){
			if (BLOCKS_NAMES[i].equals( blockOrTable ) ) {
				registered = true;
			} else {
				i++;
			}
		}
		return registered;	
	}
	
	public static boolean isTable(String bloqueOMesa){
		boolean registered = false;
		int i=0;
		while ( !registered && i<TABLE_NAMES.length ){
			if ( TABLE_NAMES[i].equals( bloqueOMesa )){
				registered = true;
			} else {
				i++;
			}
		}
		return registered;
		
	}
	
	private boolean isValid(String block){
		boolean valid = true;
				
		if (isBlock( block )){
			int position = -1;
			if ( block.equals(BLOCKS_NAMES[0] ) ){
				if ( _overList[0].equals( block ) //The block cannot be over itself 
					|| _overList[0].equals( _overList[1] ) || _overList[0].equals( _overList[2] ) ){
					//The block cannot be in the same position as a different block
					valid = false;
				}
				position = 0;
			} else if ( block.equals ( BLOCKS_NAMES[1] ) ){
				if (_overList[1].equals(block) //The block cannot be over itself  
					|| _overList[1].equals( _overList[0]) || _overList[1].equals( _overList[2] ) ){
						//The block cannot be in the same position as a different block
					valid = false;							
				}
				position = 1;
			} else if (block.equals( BLOCKS_NAMES[2] ) ){
				if (_overList[2].equals(block) //The block cannot be over itself  
					|| _overList[2].equals( _overList[0] ) || _overList[2].equals( _overList[1] ) ){
						//The block cannot be in the same position as a different block
					valid = false;							
				}
				position = 2;
			}
			if ( valid ){
				valid = isBlock( _overList[position] ) || isTable( _overList[position] );
			}
		} else {
			valid = false;
		}
		return valid;
	}
	
	public String getOverA( ){
		return _overList[0];
	}
	
	public String getOverB( ){
		return _overList[1];
	}
	
	public String getOverC( ){
		return _overList[2];
	}
	
	public int dameAlturaA(){
		int altura=1;
		String posicionA=_overList[0];
		if (posicionA.equals(BLOCKS_NAMES[1])){
			altura=dameAlturaB()+1;
		}else if (posicionA.equals(BLOCKS_NAMES[2])){	
			altura=dameAlturaC()+1;
		}
		return altura;
	}
	
	public int dameAlturaB(){
		int altura=1;
		String posicionB=_overList[1];
		if (posicionB.equals(BLOCKS_NAMES[0])){
			altura=dameAlturaA()+1;
		}else if (posicionB.equals(BLOCKS_NAMES[2])){	
			altura=dameAlturaC()+1;
		}
		return altura;
	}
	
	public int dameAlturaC(){
		int altura=1;
		String posicionC=_overList[2];
		if (posicionC.equals(BLOCKS_NAMES[0])){
			altura=dameAlturaA()+1;
		}else if (posicionC.equals(BLOCKS_NAMES[1])){	
			altura=dameAlturaB()+1;
		}
		return altura;
	}
	
	public String dameMesa(String bloqueOMesa){
		String mesa=null;
		if (isBlock(bloqueOMesa)){
			String bajoBloque=null; 
			if (bloqueOMesa.equals(BLOCKS_NAMES[0])){
				bajoBloque=_overList[0];
			}else if (bloqueOMesa.equals(BLOCKS_NAMES[1])){
				bajoBloque=_overList[1];
			}else if (bloqueOMesa.equals(BLOCKS_NAMES[2])){
				bajoBloque=_overList[2];
			}
			mesa=dameMesa(bajoBloque);
		}else if (isTable(bloqueOMesa)){
			mesa=bloqueOMesa;
		}
		return mesa;
	}
	
	public String dameCima(String bloqueOMesa){
		String buscado=bloqueOMesa;
		int i=0;
		while (i<_overList.length){
			if (_overList[i].equals(buscado)){
				buscado=BLOCKS_NAMES[i];
				i=0;
			}else{
				i++;
			}
		}
		return buscado;
	}
	
	public String toString(){
		return "(A sobre "+_overList[0]+", B sobre "+_overList[1]+", C sobre "+_overList[2]+")";
		
	}
	
	public boolean equals(Object comparado){
		boolean igual=false;
		if (comparado instanceof BlocksState){
			BlocksState blocksState=(BlocksState) comparado;
			igual= _overList[0].equals(blocksState.getOverA()) 
				&& _overList[1].equals(blocksState.getOverB()) 
				&& _overList[2].equals(blocksState.getOverC());
		}
		return igual;
	}
	
}
