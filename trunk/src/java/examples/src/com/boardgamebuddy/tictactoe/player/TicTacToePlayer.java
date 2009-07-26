package com.boardgamebuddy.tictactoe.player;

import com.boardgamebuddy.core.player.Player;

public class TicTacToePlayer implements Player {

	private String name;
	
	public TicTacToePlayer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name == null ? "" : name;
	}
}
