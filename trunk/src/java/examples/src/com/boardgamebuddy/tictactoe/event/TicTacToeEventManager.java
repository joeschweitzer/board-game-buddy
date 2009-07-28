/**
 * Board Game Buddy - A board game framework
 * 
 * Copyright (c) 2009, Joe Schweitzer
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 *    1. Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *    2. Redistributions in binary form must reproduce the above
 *       copyright notice, this list of conditions and the following
 *       disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *    3. The name of the author may not be used to endorse or promote
 *       products derived from this software without specific prior
 *       written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER
 * IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN
 * IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.boardgamebuddy.tictactoe.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.boardgamebuddy.core.event.Event;
import com.boardgamebuddy.core.event.EventListener;
import com.boardgamebuddy.core.event.EventManager;

/**
 * EventManager implementation for TicTacToe
 */
public class TicTacToeEventManager implements EventManager {

	private Map<String, List<EventListener>> eventMap = 
		new HashMap<String, List<EventListener>>();
	
	/**
	 * Raise the given event
	 */
	public final void raiseEvent(final Event event) {
		List<EventListener> listeners = eventMap.get(event.getEventType());
		
		if (listeners == null) {
			return;
		}
		
		for (EventListener listener : listeners) {
			listener.eventRaised(event);
		}
	}

	/**
	 * Register the given listener for the given event type
	 */
	public final void registerListener(final String eventType, 
			final EventListener listener) {
		List<EventListener> listeners = eventMap.get(eventType);
		
		if (listeners == null) {
			listeners = new ArrayList<EventListener>();
		}
		
		listeners.add(listener);
		
		eventMap.put(eventType, listeners);
	}
}
