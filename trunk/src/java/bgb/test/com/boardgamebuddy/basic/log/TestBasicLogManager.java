package com.boardgamebuddy.basic.log;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.isA;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.*;

import org.junit.Before;
import org.junit.Test;

import com.boardgamebuddy.basic.event.BasicEvent;
import com.boardgamebuddy.basic.event.BasicEvent.BasicEventType;
import com.boardgamebuddy.core.event.EventManager;
import com.boardgamebuddy.core.game.Game;

/**
 * Test for BasicLogManager]
 */
public class TestBasicLogManager {

	private BasicLogManager logManager;
	private Game mockGame;
	private EventManager mockEventManager;
	
	/**
	 * Setup mocks
	 */
	@Before
	public final void setUp() throws Exception {
		mockGame = createMock(Game.class);
		mockEventManager = createMock(EventManager.class);
		
		expect(mockGame.getEventManager()).andReturn(mockEventManager);
		
		mockEventManager.registerListener(
				eq(BasicEventType.MOVE_COMPLETE.toString()), 
				isA(BasicLogManager.class));
		mockEventManager.registerListener(
				eq(BasicEventType.TURN_COMPLETE.toString()), 
				isA(BasicLogManager.class));
		mockEventManager.registerListener(
				eq(BasicEventType.ROUND_COMPLETE.toString()), 
				isA(BasicLogManager.class));
		mockEventManager.registerListener(
				eq(BasicEventType.GAME_COMPLETE.toString()), 
				isA(BasicLogManager.class));

		replay(mockGame);
		replay(mockEventManager);
		logManager = new BasicLogManager(mockGame);
		verify(mockGame);
		verify(mockEventManager);
	}

	/**
	 * Test for constructor
	 */
	@Test
	public final void testLogging() {
		logManager.logEvent(new BasicEvent(BasicEventType.MOVE_COMPLETE));
		logManager.eventRaised(new BasicEvent(BasicEventType.MOVE_COMPLETE));
		logManager.logMessage("hello");
	}
}
