package com.google.code.bgb.basic.board;

import com.google.code.bgb.core.board.Piece;
import com.google.code.bgb.core.board.Space;

public class BasicSpace implements Space {

	private String value;
	private Piece piece;
	
	public BasicSpace(String value) {
		this.value = value;
	}

	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}


	@Override
	public boolean equals(Object obj) {
		BasicSpace space = (BasicSpace) obj;
		
		if(space.getValue().equals(value)) {
			return true;
		}
		
		return false;
	}
}
