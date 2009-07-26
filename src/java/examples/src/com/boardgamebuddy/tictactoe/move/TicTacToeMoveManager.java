package com.boardgamebuddy.tictactoe.move;

import com.boardgamebuddy.basic.event.MoveEvent;
import com.boardgamebuddy.core.event.EventManager;
import com.boardgamebuddy.core.game.Game;
import com.boardgamebuddy.core.move.Move;
import com.boardgamebuddy.core.move.MoveManager;
import com.boardgamebuddy.core.player.Player;
import com.boardgamebuddy.tictactoe.event.TicTacToeEvent.TicTacToeEventType;

public class TicTacToeMoveManager implements MoveManager {

	private Game game;
	private EventManager eventManager;
	
	public TicTacToeMoveManager(Game game) {
		this.game = game;
		this.eventManager = this.game.getEventManager();
	}
	
	public void makeMove(Move move) {
		Player currPlayer = game.getTurnManager().getCurrentPlayer();
		
		if(!move.getPlayer().equals(currPlayer)) {
			throw new IllegalArgumentException(
					"Invalid move - player out of turn " + move);
		}
		
		if(move.getSpace().getPiece() != null ) {
			throw new IllegalArgumentException(
					"Invalid move - space not empty " + move);
		}
		
		move.getSpace().setPiece(move.getPiece());
		
		eventManager.raiseEvent(new MoveEvent(
				TicTacToeEventType.MOVE_COMPLETE.toString(), move));
	}
}
