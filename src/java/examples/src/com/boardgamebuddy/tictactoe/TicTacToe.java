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


public class TicTacToe {
	
	public static void main(String[] args) {
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
		
		game.getMoveManager().makeMove(getMove(game, 0));
		game.getMoveManager().makeMove(getMove(game, 1));
		game.getMoveManager().makeMove(getMove(game, 2));
		game.getMoveManager().makeMove(getMove(game, 3));
		game.getMoveManager().makeMove(getMove(game, 4));
		game.getMoveManager().makeMove(getMove(game, 5));
		game.getMoveManager().makeMove(getMove(game, 6));
		game.getMoveManager().makeMove(getMove(game, 7));
		game.getMoveManager().makeMove(getMove(game, 8));
		
		game.getBoardManager().getMainBoard().printBoard();
	}
	
	private static Move getMove(Game game, int index) {
		Player player = game.getTurnManager().getCurrentPlayer();
		Piece piece = null;
		if(player.getName().equals("Joe")) {
			piece = new TicTacToePiece(player, PieceType.X);
		} else {
			piece = new TicTacToePiece(player, PieceType.O);
		}
		
		Space space = game.getBoardManager().getMainBoard().getSpace(
				String.valueOf(index));
		
		return new BasicMove(player, space, piece);
	}
}
