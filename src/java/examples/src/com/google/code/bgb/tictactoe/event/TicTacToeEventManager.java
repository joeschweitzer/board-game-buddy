package com.google.code.bgb.tictactoe.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.code.bgb.core.event.Event;
import com.google.code.bgb.core.event.EventListener;
import com.google.code.bgb.core.event.EventManager;

public class TicTacToeEventManager implements EventManager {

	Map<String, List<EventListener>> eventMap = 
		new HashMap<String, List<EventListener>>();
	
	public void raiseEvent(Event event) {
		List<EventListener> listeners = eventMap.get(event.getEventType());
		
		if(listeners == null) {
			return;
		}
		
		for(EventListener listener : listeners) {
			listener.eventRaised(event);
		}
	}

	public void registerListener(String eventType, EventListener listener) {
		List<EventListener> listeners = eventMap.get(eventType);
		
		if(listeners == null) {
			listeners = new ArrayList<EventListener>();
		}
		
		listeners.add(listener);
		
		eventMap.put(eventType, listeners);
	}

	
}
