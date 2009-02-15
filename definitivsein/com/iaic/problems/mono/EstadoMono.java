package com.iaic.problems.mono;


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
public class EstadoMono {
	public static final int VENTANA = 2;
	public static final int CENTRO = 1;
	public static final int PUERTA = 0;
	
	int posicionCaja;
	int posicionPlatano;
	int posicionMono;
	boolean monoSobreCaja;
	
	
	public EstadoMono (){
		posicionCaja=VENTANA;
		posicionPlatano=CENTRO;
		posicionMono=PUERTA;
		monoSobreCaja=false;
	}
	
	public EstadoMono (int posicionPlatano,int posicionCaja,int posicionMono,boolean monoSobreCaja) throws Exception{
		this.posicionPlatano=posicionPlatano;
		this.posicionCaja=posicionCaja;
		this.posicionMono=posicionMono;
		this.monoSobreCaja=monoSobreCaja;
		if (posicionPlatano<PUERTA || posicionPlatano>VENTANA ||
				posicionCaja<PUERTA || posicionCaja>VENTANA ||
				posicionMono<PUERTA || posicionMono>VENTANA){
			throw new Exception("El mono, el platano o la caja no se encuentran en ninguna posicion de la habitacion");
		}else if (monoSobreCaja && posicionMono!=posicionCaja){
			throw new Exception("No es posible que el mono este sobre la caja si la caja y el mono estan en posiciones distintas de la habitacion");
			
		}
		
	}
	
	public int damePosicionCaja(){
		return posicionCaja;	
	}
	
	public int damePosicionPlatano(){
		return posicionPlatano;	
	}
	
	public int damePosicionMono(){
		return posicionMono;	
	}
	
	public boolean estaMonoSobreCaja(){
		return monoSobreCaja;	
	}
	
	public String toString(){
		StringBuffer sb=new StringBuffer();

		sb.append("(Puerta: ");
		if (damePosicionPlatano()==PUERTA){
			sb.append("P");
		}
		if (damePosicionCaja()==PUERTA){
			sb.append("C");
		}
		if (damePosicionMono()==PUERTA){
			sb.append("M");
			if (estaMonoSobreCaja()){
				sb.append("+");
			}else{
				sb.append("-");
			}
		}
	
		sb.append(", Centro: ");
		if (damePosicionPlatano()==CENTRO){
			sb.append("P");
		}
		if (damePosicionCaja()==CENTRO){
			sb.append("C");
		}
		if (damePosicionMono()==CENTRO){
			sb.append("M");
			if (estaMonoSobreCaja()){
				sb.append("+");
			}else{
				sb.append("-");
			}
		}
		sb.append(", Ventana: ");
		if (damePosicionPlatano()==VENTANA){
			sb.append("P");
		}
		if (damePosicionCaja()==VENTANA){
			sb.append("C");
		}
		if (damePosicionMono()==VENTANA){
			sb.append("M");
			if (estaMonoSobreCaja()){
				sb.append("+");
			}else{
				sb.append("-");
			}
		}
		
		sb.append(")");
		return sb.toString();		
	}
	
	public boolean equals(Object comparado){
		boolean igual=false;
		if (comparado instanceof EstadoMono){
			EstadoMono estadoMono=(EstadoMono) comparado;
			igual= posicionCaja==estadoMono.damePosicionCaja()
				&& posicionPlatano==estadoMono.damePosicionPlatano() 
				&& posicionMono==estadoMono.damePosicionMono()
				&& monoSobreCaja==estadoMono.estaMonoSobreCaja();
		}
		return igual;
	}
	
}
