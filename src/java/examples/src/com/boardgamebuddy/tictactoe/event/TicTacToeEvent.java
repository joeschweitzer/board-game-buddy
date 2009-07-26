package com.boardgamebuddy.tictactoe.event;

import com.boardgamebuddy.core.event.Event;

public class TicTacToeEvent implements Event {

	public enum TicTacToeEventType { MOVE_COMPLETE, TURN_COMPLETE, 
		ROUND_COMPLETE, GAME_COMPLETE };
	
	private TicTacToeEventType eventType;
	
	public TicTacToeEvent(TicTacToeEventType eventType) {
		this.eventType = eventType;
	}
	
	public String getEventType() {
		return eventType.toString();
	}

}
