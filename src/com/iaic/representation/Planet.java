package com.iaic.representation;

import java.util.*;

public class Planet {
	
	int _idir;
	String _name;
	Set _connections;
	
	Planet() {
		this._id = 0;
		this._name = "random";
		this._connections = new TreeSet();
		
	}
	
	Planet( int id, String name, Set connections ) {
		this._id = id;
		this._name = name;
		this._connections = connections;
	}
	
	void setID( int id ) {
		this._id = id;
	}
	
	void setName( String name ) {
		this._name = name;
	}
	
	void setConnections( Set connections ) {
		this._connections = connections;
	}
	
	int getID( ) {
		return this._id;
	}
	
	String getName() {
		return this._name;
	}
	
	double doPing(Planet planet) {
		this._planet
	}
}

