package com.google.code.bgb.tictactoe.board;

import com.google.code.bgb.tictactoe.player.Player;

public class TicTacToePiece {

	public enum PieceType {X, O};
	
	private Player player;
	private PieceType type;
	
	public TicTacToePiece(Player player, PieceType type) {
		this.player = player;
		this.type = type;
	}
}
