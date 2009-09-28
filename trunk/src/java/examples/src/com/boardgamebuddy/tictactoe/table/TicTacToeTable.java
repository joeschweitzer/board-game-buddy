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
package com.boardgamebuddy.tictactoe.table;

import java.util.ArrayList;
import java.util.Collection;

import com.boardgamebuddy.basic.player.BasicPlayer;
import com.boardgamebuddy.core.game.Game;
import com.boardgamebuddy.core.player.Player;
import com.boardgamebuddy.core.table.Table;
import com.boardgamebuddy.core.user.User;
import com.boardgamebuddy.tictactoe.board.TicTacToePiece.PieceType;
import com.boardgamebuddy.tictactoe.game.TicTacToeGame;

/**
 * Table implementation for TicTacToe
 */
public class TicTacToeTable implements Table {

	private Collection<User> users = new ArrayList<User>();
	private Game game;
	
	/**
	 * Adds the given user to this table
	 */
	public final void addUser(final User user) {
		
		users.add(user);
		
		if (game == null) {
			game = new TicTacToeGame("Game1");
		}
		
		String pieceTheme = PieceType.X.toString();
		
		if (users.size() > 1) {
			pieceTheme = PieceType.O.toString();
		}
		
		Player player = new BasicPlayer(user.getUserName(), pieceTheme);
		game.getPlayerManager().addPlayer(player);
		
		if (users.size() == 2) {
			game.start();
		}
	}

	/**
	 * Returns the game for this table
	 */
	public final Game getGame() {
		return game;
	}
}
