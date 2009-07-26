package com.google.code.bgb.basic.move;

import com.google.code.bgb.core.board.Piece;
import com.google.code.bgb.core.board.Space;
import com.google.code.bgb.core.move.Move;
import com.google.code.bgb.core.player.Player;

public class BasicMove implements Move {

	private Player player;
	private Space space;
	private Piece piece;

	public BasicMove(Player player, Space space, Piece piece) {
		this.player = player;
		this.space = space;
		this.piece = piece;
	}
	
	public Piece getPiece() {
		return piece;
	}

	public Player getPlayer() {
		return player;
	}

	public Space getSpace() {
		return space;
	}

}
