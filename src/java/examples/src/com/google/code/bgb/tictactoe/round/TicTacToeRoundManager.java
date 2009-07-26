package com.google.code.bgb.tictactoe.round;

import com.boardgamebuddy.core.event.Event;
import com.boardgamebuddy.core.event.EventListener;
import com.boardgamebuddy.core.event.EventManager;
import com.boardgamebuddy.core.game.Game;
import com.boardgamebuddy.core.round.RoundManager;
import com.google.code.bgb.tictactoe.event.TicTacToeEvent;
import com.google.code.bgb.tictactoe.event.TicTacToeEvent.TicTacToeEventType;

public class TicTacToeRoundManager implements RoundManager, EventListener {

	private Game game;
	private EventManager eventManager;
	private int numTurns = 0;
	
	public TicTacToeRoundManager(Game game) {
		this.game = game;
		this.eventManager = this.game.getEventManager();
		
		eventManager.registerListener(
				TicTacToeEventType.TURN_COMPLETE.toString(), this);
	}
	
	public void eventRaised(Event event) {
		if(TicTacToeEventType.TURN_COMPLETE.equals(
				TicTacToeEventType.valueOf(event.getEventType()))) {
			numTurns++;
			System.out.println("Turn complete");
		}
		
		if(numTurns % 2 == 0) {
			eventManager.raiseEvent(
					new TicTacToeEvent(TicTacToeEventType.ROUND_COMPLETE));
			System.out.println("Round complete");
		}
	}
}
