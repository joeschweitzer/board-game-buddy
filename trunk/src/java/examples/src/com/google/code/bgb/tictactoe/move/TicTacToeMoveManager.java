package com.google.code.bgb.tictactoe.move;

import com.google.code.bgb.basic.event.MoveEvent;
import com.google.code.bgb.core.event.EventManager;
import com.google.code.bgb.core.game.Game;
import com.google.code.bgb.core.move.Move;
import com.google.code.bgb.core.move.MoveManager;
import com.google.code.bgb.core.player.Player;
import com.google.code.bgb.tictactoe.event.TicTacToeEvent.TicTacToeEventType;

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
