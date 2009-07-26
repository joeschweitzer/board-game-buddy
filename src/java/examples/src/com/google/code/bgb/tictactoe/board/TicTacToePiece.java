package com.google.code.bgb.tictactoe.board;

import com.boardgamebuddy.core.board.Piece;
import com.boardgamebuddy.core.player.Player;

public class TicTacToePiece implements Piece {

	public enum PieceType {X, O};
	
	private Player player;
	private PieceType type;
	
	public TicTacToePiece(Player player, PieceType type) {
		this.player = player;
		this.type = type;
	}

	public String getValue() {
		return type.toString();
	}

	@Override
	public String toString() {
		return type == null ? "" : type.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicTacToePiece other = (TicTacToePiece) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
}
