package com.google.code.bgb.tictactoe.board;

import com.google.code.bgb.core.board.Board;
import com.google.code.bgb.core.board.BoardManager;

public class TicTacToeBoardManager implements BoardManager {

	private Board board;
	
	public void addBoard(Board board) {
		this.board = board;
	}

	public Board getMainBoard() {
		return board;
	}

}
