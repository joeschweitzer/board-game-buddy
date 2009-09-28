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
package com.boardgamebuddy.tictactoe.game;

import com.boardgamebuddy.basic.board.BasicBoardManager;
import com.boardgamebuddy.basic.board.BasicPieceManager;
import com.boardgamebuddy.basic.event.BasicEventManager;
import com.boardgamebuddy.basic.event.BasicEvent.BasicEventType;
import com.boardgamebuddy.basic.log.BasicLogManager;
import com.boardgamebuddy.basic.player.BasicPlayerManager;
import com.boardgamebuddy.basic.round.BasicRoundManager;
import com.boardgamebuddy.basic.turn.BasicTurnManager;
import com.boardgamebuddy.core.board.Board;
import com.boardgamebuddy.core.board.BoardManager;
import com.boardgamebuddy.core.board.PieceManager;
import com.boardgamebuddy.core.event.Event;
import com.boardgamebuddy.core.event.EventListener;
import com.boardgamebuddy.core.event.EventManager;
import com.boardgamebuddy.core.game.Game;
import com.boardgamebuddy.core.log.LogManager;
import com.boardgamebuddy.core.move.MoveManager;
import com.boardgamebuddy.core.player.PlayerManager;
import com.boardgamebuddy.core.round.RoundManager;
import com.boardgamebuddy.core.score.ScoreManager;
import com.boardgamebuddy.core.turn.TurnManager;
import com.boardgamebuddy.tictactoe.board.TicTacToeBoard;
import com.boardgamebuddy.tictactoe.move.TicTacToeMoveManager;
import com.boardgamebuddy.tictactoe.score.TicTacToeScoreManager;

/**
 * Implementation of Game for TicTacToe
 */
public class TicTacToeGame implements Game, EventListener {

	private static final int BOARD_SIZE = 3;
	
	private EventManager eventManager = new BasicEventManager();
	private BoardManager boardManager = new BasicBoardManager();
	private PieceManager pieceManager = new BasicPieceManager();
	private MoveManager moveManager = new TicTacToeMoveManager(this);
	private TurnManager turnManager = new BasicTurnManager(this);
	private RoundManager roundManager = new BasicRoundManager(this);
	private PlayerManager playerManager = new BasicPlayerManager();
	private ScoreManager scoreManager = new TicTacToeScoreManager(this);
	private LogManager logManager = new BasicLogManager(this);
	
	private String name;
	private String status;
	
	/**
	 * Constructor with game name
	 */
	public TicTacToeGame(final String nameIn) {
		this.name = nameIn;
		this.status = "WAITING FOR PLAYERS";
		
		Board board = new TicTacToeBoard(BOARD_SIZE);
		boardManager.addBoard(board);
		
		eventManager.registerListener(
				BasicEventType.GAME_COMPLETE.toString(), this);
	}
	
	/**
	 * Start game
	 */
	public final void start() {
		this.status = "RUNNING";
	}
	
	/**
	 * End game
	 */
	public final void end() {
		this.status = "ENDED";
	}

	/**
	 * Callback when an event is raised in the game
	 */
	public final void eventRaised(final Event event) {
		if (BasicEventType.GAME_COMPLETE.equals(
				BasicEventType.valueOf(event.getEventType()))) {
			System.out.println("Winner = " + scoreManager.getWinner());
			end();
		}
	}

	/**
	 * Getter for boardManager
	 */
	public final BoardManager getBoardManager() {
		return boardManager;
	}

	/**
	 * Getter for pieceManager
	 */
	public PieceManager getPieceManager() {
		return pieceManager;
	}

	/**
	 * Getter for moveManager
	 */
	public final MoveManager getMoveManager() {
		return moveManager;
	}

	/**
	 * Getter for turnManager
	 */
	public final TurnManager getTurnManager() {
		return turnManager;
	}

	/**
	 * Getter for roundManager
	 */
	public final RoundManager getRoundManager() {
		return roundManager;
	}

	/**
	 * Getter for playerManager
	 */
	public final PlayerManager getPlayerManager() {
		return playerManager;
	}

	/**
	 * Getter for scoreManager
	 */
	public final ScoreManager getScoreManager() {
		return scoreManager;
	}

	/**
	 * Getter for eventManager
	 */
	public final EventManager getEventManager() {
		return eventManager;
	}

	/**
	 * Getter for logManager
	 */
	public final LogManager getLogManager() {
		return logManager;
	}

	/**
	 * Returns the game name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * Returns the game status
	 */
	public final String getStatus() {
		return status;
	}
}
