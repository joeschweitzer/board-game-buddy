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
package com.boardgamebuddy.tictactoe.score;

import com.boardgamebuddy.basic.event.MoveEvent;
import com.boardgamebuddy.core.board.BoardManager;
import com.boardgamebuddy.core.event.Event;
import com.boardgamebuddy.core.event.EventListener;
import com.boardgamebuddy.core.event.EventManager;
import com.boardgamebuddy.core.game.Game;
import com.boardgamebuddy.core.player.Player;
import com.boardgamebuddy.core.score.ScoreManager;
import com.boardgamebuddy.tictactoe.board.TicTacToeBoard;
import com.boardgamebuddy.tictactoe.event.TicTacToeEvent;
import com.boardgamebuddy.tictactoe.event.TicTacToeEvent.TicTacToeEventType;

/**
 * Score manager implementation for TicTacToe
 */
public class TicTacToeScoreManager implements ScoreManager, EventListener {

	private Game game;
	private EventManager eventManager;
	private Player winner = null;
	
	/**
	 * Constructor for game
	 */
	public TicTacToeScoreManager(final Game gameIn) {
		this.game = gameIn;
		this.eventManager = game.getEventManager();
		
		eventManager.registerListener(
				TicTacToeEventType.MOVE_COMPLETE.toString(), this);
	}
	
	/**
	 * Callback for when event is raised during the game
	 */
	public final void eventRaised(final Event event) {
		if (TicTacToeEventType.MOVE_COMPLETE.equals(
				TicTacToeEventType.valueOf(event.getEventType()))) {
			MoveEvent moveEvent = (MoveEvent) event;
			BoardManager boardManager = game.getBoardManager();
			TicTacToeBoard board = (TicTacToeBoard) boardManager.getMainBoard();
			
			if (board.doesCompleteStraightLine(moveEvent.getMove().getSpace())
				|| board.noEmptySpaces()) {
				winner = moveEvent.getMove().getPlayer();
				eventManager.raiseEvent(
						new TicTacToeEvent(TicTacToeEventType.GAME_COMPLETE));
			} else if (board.noEmptySpaces()) {
				eventManager.raiseEvent(
						new TicTacToeEvent(TicTacToeEventType.GAME_COMPLETE));
			}
		}
	}
	
	/**
	 * Returns the winner
	 */
	public final Player getWinner() {
		return winner;
	}

}
