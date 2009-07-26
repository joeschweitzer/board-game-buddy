package com.google.code.bgb.core.event;

public interface EventManager {

	void registerListener(String eventType, EventListener listener);
	
	void raiseEvent(Event event);
}
