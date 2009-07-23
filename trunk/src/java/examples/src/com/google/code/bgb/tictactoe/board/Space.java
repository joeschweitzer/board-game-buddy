package com.google.code.bgb.tictactoe.board;

import com.google.code.bgb.core.board.Piece;

public class Space {

	private String value;
	private Piece piece;
	
	public Space(String value) {
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
}
