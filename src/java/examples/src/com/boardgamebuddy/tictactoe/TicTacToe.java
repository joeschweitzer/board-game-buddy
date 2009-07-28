/**
 * Board Game Buddy - A board game framework
 * 
 * Copyright (c) 2009, Joe Schweitzer
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 *    1. Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *    2. Redistributions in binary form must reproduce the above
 *       copyright notice, this list of conditions and the following
 *       disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *    3. The name of the author may not be used to endorse or promote
 *       products derived from this software without specific prior
 *       written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER
 * IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN
 * IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.boardgamebuddy.tictactoe;

import com.boardgamebuddy.basic.move.BasicMove;
import com.boardgamebuddy.basic.table.BasicTableManager;
import com.boardgamebuddy.core.board.Piece;
import com.boardgamebuddy.core.board.Space;
import com.boardgamebuddy.core.game.Game;
import com.boardgamebuddy.core.move.Move;
import com.boardgamebuddy.core.player.Player;
import com.boardgamebuddy.core.table.Table;
import com.boardgamebuddy.core.table.TableManager;
import com.boardgamebuddy.core.user.User;
import com.boardgamebuddy.tictactoe.board.TicTacToePiece;
import com.boardgamebuddy.tictactoe.board.TicTacToePiece.PieceType;
import com.boardgamebuddy.tictactoe.table.TicTacToeTable;
import com.boardgamebuddy.tictactoe.user.TicTacToeUser;

/**
 * TicTacToe example
 */
public class TicTacToe {
	
	private static final int BOARD_SIZE = 9;
	
	/**
	 * Runs a complete game of TicTacToe
	 */
	public final void runGame() {
		TableManager tableManager = new BasicTableManager();
		
		User joe = new TicTacToeUser("Joe");
		User laura = new TicTacToeUser("Laura");
		
		Table table = new TicTacToeTable();
		tableManager.addNewTable(table);
		table.addUser(joe);
		table.addUser(laura);
		
		Game game = table.getGame();
		game.getTurnManager().orderPlayers(
				game.getPlayerManager().getPlayers());
		
		for (int ctr = 0; ctr < BOARD_SIZE; ctr++) {
			game.getMoveManager().makeMove(getMove(game, ctr));
		}
		
		game.getBoardManager().getMainBoard().printBoard();
	}
	
	/**
	 * Returns a move for the next player to go in the given game
	 * by placing their piece at the given board index
	 */
	private Move getMove(final Game game, final int index) {
		Player player = game.getTurnManager().getCurrentPlayer();
		Piece piece = null;
		if (player.getName().equals("Joe")) {
			piece = new TicTacToePiece(player, PieceType.X);
		} else {
			piece = new TicTacToePiece(player, PieceType.O);
		}
		
		Space space = game.getBoardManager().getMainBoard().getSpace(
				String.valueOf(index));
		
		return new BasicMove(player, space, piece);
	}
	
	/**
	 * Main driver
	 */
	public static void main(final String[] args) {
		TicTacToe ticTacToe = new TicTacToe();
		ticTacToe.runGame();
	}
}
