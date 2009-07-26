package com.google.code.bgb.tictactoe.score;

import com.boardgamebuddy.basic.event.MoveEvent;
import com.boardgamebuddy.core.board.BoardManager;
import com.boardgamebuddy.core.event.Event;
import com.boardgamebuddy.core.event.EventListener;
import com.boardgamebuddy.core.event.EventManager;
import com.boardgamebuddy.core.game.Game;
import com.boardgamebuddy.core.player.Player;
import com.boardgamebuddy.core.score.ScoreManager;
import com.google.code.bgb.tictactoe.board.TicTacToeBoard;
import com.google.code.bgb.tictactoe.event.TicTacToeEvent;
import com.google.code.bgb.tictactoe.event.TicTacToeEvent.TicTacToeEventType;

public class TicTacToeScoreManager implements ScoreManager, EventListener {

	private Game game;
	private EventManager eventManager;
	private Player winner = null;
	
	public TicTacToeScoreManager(Game game) {
		this.game = game;
		this.eventManager = game.getEventManager();
		
		eventManager.registerListener(
				TicTacToeEventType.MOVE_COMPLETE.toString(), this);
	}
	
	public void eventRaised(Event event) {
		if(TicTacToeEventType.MOVE_COMPLETE.equals(
				TicTacToeEventType.valueOf(event.getEventType()))) {
			MoveEvent moveEvent = (MoveEvent) event;
			BoardManager boardManager = game.getBoardManager();
			TicTacToeBoard board = (TicTacToeBoard) boardManager.getMainBoard();
			
			if(board.doesCompleteStraightLine(moveEvent.getMove().getSpace())
				|| board.noEmptySpaces()) {
				winner = moveEvent.getMove().getPlayer();
				eventManager.raiseEvent(
						new TicTacToeEvent(TicTacToeEventType.GAME_COMPLETE));
			} else if(board.noEmptySpaces()) {
				eventManager.raiseEvent(
						new TicTacToeEvent(TicTacToeEventType.GAME_COMPLETE));
			}
		}
	}
	
	public Player getWinner() {
		return winner;
	}

}
