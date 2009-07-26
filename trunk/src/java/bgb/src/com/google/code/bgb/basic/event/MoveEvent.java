package com.google.code.bgb.basic.event;

import com.google.code.bgb.core.event.Event;
import com.google.code.bgb.core.move.Move;

public class MoveEvent implements Event {

	private String type;
	private Move move;
	
	public MoveEvent(String type, Move move) {
		this.type = type;
		this.move = move;
	}
	
	public String getEventType() {
		return type;
	}
	
	public Move getMove() {
		return move;
	}

	
}
