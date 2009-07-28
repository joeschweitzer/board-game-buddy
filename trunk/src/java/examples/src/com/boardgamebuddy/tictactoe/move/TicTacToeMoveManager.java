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
package com.boardgamebuddy.tictactoe.move;

import com.boardgamebuddy.basic.event.MoveEvent;
import com.boardgamebuddy.core.event.EventManager;
import com.boardgamebuddy.core.game.Game;
import com.boardgamebuddy.core.move.Move;
import com.boardgamebuddy.core.move.MoveManager;
import com.boardgamebuddy.core.player.Player;
import com.boardgamebuddy.tictactoe.event.TicTacToeEvent.TicTacToeEventType;

/**
 * TicTacToe implementation of MoveManager
 */
public class TicTacToeMoveManager implements MoveManager {

	private Game game;
	private EventManager eventManager;
	
	/**
	 * Constructor passing game
	 */
	public TicTacToeMoveManager(final Game gameIn) {
		this.game = gameIn;
		this.eventManager = this.game.getEventManager();
	}
	
	/**
	 * Makes the given move
	 */
	public final void makeMove(final Move move) {
		Player currPlayer = game.getTurnManager().getCurrentPlayer();
		
		if (!move.getPlayer().equals(currPlayer)) {
			throw new IllegalArgumentException(
					"Invalid move - player out of turn " + move);
		}
		
		if (move.getSpace().getPiece() != null) {
			throw new IllegalArgumentException(
					"Invalid move - space not empty " + move);
		}
		
		move.getSpace().setPiece(move.getPiece());
		
		eventManager.raiseEvent(new MoveEvent(
				TicTacToeEventType.MOVE_COMPLETE.toString(), move));
	}
}
