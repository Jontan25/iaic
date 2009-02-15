package com.iaic.problems.peasant;

/*
 * Created on 21-ene-2008
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

/**
 * @author francisco.jose.sanch
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class PeasantState {
	private boolean granjero;
	private boolean lobo;
	private boolean oveja;
	private boolean col;

	public PeasantState (){
		granjero=false;
		lobo=false;
		oveja=false;
		col=false;
	}
	
	public PeasantState (boolean granjero,boolean lobo,boolean oveja,boolean col) throws Exception{
		this.granjero=granjero;
		this.lobo=lobo;
		this.oveja=oveja;
		this.col=col;
		
		//comprobamos que no sea un estado de peligro
		if (granjero!=lobo
			//Si el granjero no esta con el lobo
			&& lobo==oveja){
			//y el lobo esta con la oveja
			throw new Exception("Estado no valido: El lobo se come a la oveja");
		}
		if (granjero!=oveja
			//Si el granjero no esta con la oveja
			&& oveja==col){
			//y la oveja esta con la col
			throw new Exception("Estado no valido: La oveja se come la col");
		}
	}
	
	public boolean dameGranjero(){
		return granjero;		
	}
	
	public boolean dameLobo(){
		return lobo;
	}
	
	public boolean dameOveja(){
		return oveja;
	}
	
	public boolean dameCol(){
		return col;	
	}
	
	public String toString(){
		StringBuffer sb=new StringBuffer();
		sb.append("(G-");
		if (granjero){
			sb.append("1");
		}else{
			sb.append("0");
		}
		sb.append(", L-");
		if (lobo){
			sb.append("1");
		}else{
			sb.append("0");
		}
		sb.append(", O-");
		if (oveja){
			sb.append("1");
		}else{
			sb.append("0");
		}
		sb.append(", C-");
		if (col){
			sb.append("1");
		}else{
			sb.append("0");
		}
		sb.append(") ");
		return sb.toString();
	}
	
	public boolean equals(Object comparado){
		boolean igual=false;
		if (comparado instanceof PeasantState){
			PeasantState estadoGranjeroComparado=(PeasantState) comparado;
			igual= granjero==estadoGranjeroComparado.dameGranjero() 
				&& lobo==estadoGranjeroComparado.dameLobo() 
				&& oveja==estadoGranjeroComparado.dameOveja()
				&& col==estadoGranjeroComparado.dameCol();
		}
		return igual;
	}

	public int compareTo(Object comparado){
		int comparacion=-1;
		if (this.equals(comparado)){
			comparacion=0;
		}else{
			if (comparado instanceof PeasantState){
				PeasantState estadoGranjeroComparado=(PeasantState) comparado;
				
				int granjeroInt; 
				int loboInt; 
				int ovejaInt;
				int colInt;
				if (granjero){
					granjeroInt=1;
				}else{
					granjeroInt=0;
				}
				if (lobo){
					loboInt=1;
				}else{
					loboInt=0;
				}
				if (oveja){
					ovejaInt=1;
				}else{
					ovejaInt=0;
				}
				if (col){
					colInt=1;
				}else{
					colInt=0;
				}
				
				
				int granjero2Int; 
				int lobo2Int; 
				int oveja2Int;
				int col2Int;
				if (estadoGranjeroComparado.dameGranjero()){
					granjero2Int=1;
				}else{
					granjero2Int=0;
				}
				if (estadoGranjeroComparado.dameLobo()){
					lobo2Int=1;
				}else{
					lobo2Int=0;
				}
				if (estadoGranjeroComparado.dameOveja()){
					oveja2Int=1;
				}else{
					oveja2Int=0;
				}
				if (estadoGranjeroComparado.dameCol()){
					col2Int=1;
				}else{
					col2Int=0;
				}
				
				
				if ((8*granjeroInt+4*loboInt+2*ovejaInt+colInt)
					<(8*granjero2Int+4*lobo2Int+2*oveja2Int+col2Int)){
					comparacion=-1;
				}else{
					comparacion=1;
				}
			}
		}
		return comparacion;
	}
	
}
