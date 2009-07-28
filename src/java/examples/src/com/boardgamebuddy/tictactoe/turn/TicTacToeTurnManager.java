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
package com.boardgamebuddy.tictactoe.turn;

import java.util.Collection;
import java.util.Iterator;

import com.boardgamebuddy.basic.event.MoveEvent;
import com.boardgamebuddy.core.event.Event;
import com.boardgamebuddy.core.event.EventListener;
import com.boardgamebuddy.core.event.EventManager;
import com.boardgamebuddy.core.game.Game;
import com.boardgamebuddy.core.player.Player;
import com.boardgamebuddy.core.turn.TurnManager;
import com.boardgamebuddy.tictactoe.event.TicTacToeEvent;
import com.boardgamebuddy.tictactoe.event.TicTacToeEvent.TicTacToeEventType;

/**
 * Turn manager implementation for TicTacToe
 */
public class TicTacToeTurnManager implements TurnManager, EventListener {

	private Game game;
	private EventManager eventManager;
	private Player firstPlayer;
	private Player secondPlayer;
	private Player currentPlayer;
	
	/**
	 * Constructor for game
	 */
	public TicTacToeTurnManager(final Game gameIn) {
		this.game = gameIn;
		this.eventManager = this.game.getEventManager();
		
		eventManager.registerListener(
				TicTacToeEventType.MOVE_COMPLETE.toString(), this);
	}
	
	/**
	 * Order the given players for who goes first, second, etc.
	 */
	public final void orderPlayers(final Collection<Player> players) {
		Iterator<Player> iter = players.iterator();
		firstPlayer = iter.next();
		secondPlayer = iter.next();
		currentPlayer = firstPlayer;
	}
	
	/**
	 * Callback for when event is raised during the game
	 */
	public final void eventRaised(final Event event) {
		if (TicTacToeEventType.MOVE_COMPLETE.equals(
				TicTacToeEventType.valueOf(event.getEventType()))) {
			MoveEvent moveEvent = (MoveEvent) event;
			if (firstPlayer.equals(moveEvent.getMove().getPlayer())) {
				currentPlayer = secondPlayer;
			} else {
				currentPlayer = firstPlayer;
			}

			eventManager.raiseEvent(
					new TicTacToeEvent(TicTacToeEventType.TURN_COMPLETE));
		}
	}

	/**
	 * Returns the player for the current turn
	 */
	public final Player getCurrentPlayer() {
		return currentPlayer;
	}
	
}
