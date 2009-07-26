package com.google.code.bgb.tictactoe.turn;

import java.util.Collection;
import java.util.Iterator;

import com.google.code.bgb.basic.event.MoveEvent;
import com.google.code.bgb.core.event.Event;
import com.google.code.bgb.core.event.EventListener;
import com.google.code.bgb.core.event.EventManager;
import com.google.code.bgb.core.game.Game;
import com.google.code.bgb.core.player.Player;
import com.google.code.bgb.core.turn.TurnManager;
import com.google.code.bgb.tictactoe.event.TicTacToeEvent;
import com.google.code.bgb.tictactoe.event.TicTacToeEvent.TicTacToeEventType;

public class TicTacToeTurnManager implements TurnManager, EventListener {

	private Game game;
	private EventManager eventManager;
	private Player firstPlayer;
	private Player secondPlayer;
	private Player currentPlayer;
	
	public TicTacToeTurnManager(Game game) {
		this.game = game;
		this.eventManager = this.game.getEventManager();
		
		eventManager.registerListener(
				TicTacToeEventType.MOVE_COMPLETE.toString(), this);
	}
	
	public void orderPlayers(Collection<Player> players) {
		Iterator<Player> iter = players.iterator();
		firstPlayer = iter.next();
		secondPlayer = iter.next();
		currentPlayer = firstPlayer;
	}
	
	public void eventRaised(Event event) {
		if(TicTacToeEventType.MOVE_COMPLETE.equals(
				TicTacToeEventType.valueOf(event.getEventType()))) {
			MoveEvent moveEvent = (MoveEvent) event;
			if(firstPlayer.equals(moveEvent.getMove().getPlayer())) {
				currentPlayer = secondPlayer;
			} else {
				currentPlayer = firstPlayer;
			}

			eventManager.raiseEvent(
					new TicTacToeEvent(TicTacToeEventType.TURN_COMPLETE));
		}
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
}
