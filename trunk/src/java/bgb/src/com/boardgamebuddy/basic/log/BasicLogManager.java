package com.boardgamebuddy.basic.log;

import com.boardgamebuddy.basic.event.BasicEvent.BasicEventType;
import com.boardgamebuddy.core.event.Event;
import com.boardgamebuddy.core.event.EventListener;
import com.boardgamebuddy.core.event.EventManager;
import com.boardgamebuddy.core.game.Game;
import com.boardgamebuddy.core.log.LogManager;

/**
 * Basic implementation of log manager that prints out events/messages
 */
public class BasicLogManager implements LogManager, EventListener {

	private Game game;
	private EventManager eventManager;

	/**
	 * Constructor for game
	 */
	public BasicLogManager(final Game gameIn) {
		this.game = gameIn;
		this.eventManager = this.game.getEventManager();
		
		eventManager.registerListener(
				BasicEventType.MOVE_COMPLETE.toString(), this);
		eventManager.registerListener(
				BasicEventType.TURN_COMPLETE.toString(), this);
		eventManager.registerListener(
				BasicEventType.ROUND_COMPLETE.toString(), this);
		eventManager.registerListener(
				BasicEventType.GAME_COMPLETE.toString(), this);
	}
	
	/**
	 * Logs given event
	 */
	public final void logEvent(final Event event) {
		System.out.println(event);
	}

	/**
	 * Logs given message
	 */
	public final void logMessage(final String message) {
		System.out.println(message);
	}

	/**
	 * Log event when one is raised
	 */
	public final void eventRaised(final Event event) {
		logEvent(event);
	}
}
