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
package com.boardgamebuddy.core.game;

import java.util.Collection;

import com.boardgamebuddy.core.board.BoardManager;
import com.boardgamebuddy.core.event.EventManager;
import com.boardgamebuddy.core.move.MoveManager;
import com.boardgamebuddy.core.player.PlayerManager;
import com.boardgamebuddy.core.round.RoundManager;
import com.boardgamebuddy.core.score.ScoreManager;
import com.boardgamebuddy.core.turn.TurnManager;
import com.boardgamebuddy.core.user.User;

/**
 * Interface for representing a game
 */
public interface Game {

	/**
	 * Adds the given users as players
	 */
	void addPlayers(Collection<User> users);
	
	/**
	 * Starts the game
	 */
	void start();
	
	/**
	 * Gets the board manager for this game
	 */
	BoardManager getBoardManager();
	
	/**
	 * Gets the event manager for this game
	 */
	EventManager getEventManager();
	
	/**
	 * Gets the move manager for this game
	 */
	MoveManager getMoveManager();
	
	/**
	 * Gets the player manager for this game
	 */
	PlayerManager getPlayerManager();
	
	/**
	 * Gets the round manager for this game
	 */
	RoundManager getRoundManager();
	
	/**
	 * Gets the score manager for this game
	 */
	ScoreManager getScoreManager();
	
	/**
	 * Gets the turn manager for this game
	 */
	TurnManager getTurnManager();
}
