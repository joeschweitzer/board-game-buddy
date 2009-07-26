package com.boardgamebuddy.core.event;

public interface EventManager {

	void registerListener(String eventType, EventListener listener);
	
	void raiseEvent(Event event);
}
