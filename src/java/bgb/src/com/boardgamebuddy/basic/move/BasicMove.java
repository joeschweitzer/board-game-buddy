package com.boardgamebuddy.basic.move;

import com.boardgamebuddy.core.board.Piece;
import com.boardgamebuddy.core.board.Space;
import com.boardgamebuddy.core.move.Move;
import com.boardgamebuddy.core.player.Player;

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
