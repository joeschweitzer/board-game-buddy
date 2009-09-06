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
package com.boardgamebuddy.basic.round;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.isA;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.reset;
import static org.easymock.EasyMock.verify;

import org.junit.Before;
import org.junit.Test;

import com.boardgamebuddy.basic.event.BasicEvent;
import com.boardgamebuddy.basic.event.BasicEvent.BasicEventType;
import com.boardgamebuddy.core.event.Event;
import com.boardgamebuddy.core.event.EventManager;
import com.boardgamebuddy.core.game.Game;

/**
 * Test for BasicRoundManager
 */
public class TestBasicRoundManager {
	
	private BasicRoundManager roundManager;
	private Game mockGame;
	private EventManager mockEventManager;

	/**
	 * Setup
	 */
	@Before
	public final void setUp() throws Exception {
		mockGame = createMock(Game.class);
		mockEventManager = createMock(EventManager.class);
		
		expect(mockGame.getEventManager()).andReturn(mockEventManager);
		
		mockEventManager.registerListener(
				eq(BasicEventType.TURN_COMPLETE.toString()), 
				isA(BasicRoundManager.class));

		replay(mockGame);
		replay(mockEventManager);
		roundManager = new BasicRoundManager(mockGame);
		verify(mockGame);
		verify(mockEventManager);
		reset(mockGame);
		reset(mockEventManager);
	}

	/**
	 * Test raising one turn event does not trigger another round
	 */
	@Test
	public final void testOneTurnEventRaised() {
		Event event = new BasicEvent(BasicEventType.TURN_COMPLETE);
		
		replay(mockEventManager);
		
		roundManager.eventRaised(event);
		
		verify(mockEventManager);
		
	}

	/**
	 * Test raising two turn events does trigger another round
	 */
	@Test
	public final void testTwoTurnsEventRaised() {
		Event turnEvent = new BasicEvent(BasicEventType.TURN_COMPLETE);
		Event roundEvent = new BasicEvent(BasicEventType.ROUND_COMPLETE);
		
		mockEventManager.raiseEvent(roundEvent);
		
		replay(mockEventManager);
		
		roundManager.eventRaised(turnEvent);
		roundManager.eventRaised(turnEvent);
		
		verify(mockEventManager);
		
	}

	/**
	 * Test raising non-turn events does not trigger another round
	 */
	@Test
	public final void testNonTurnEventsRaised() {
		Event event = new BasicEvent(BasicEventType.MOVE_COMPLETE);
		
		replay(mockEventManager);
		
		roundManager.eventRaised(event);
		roundManager.eventRaised(event);
		roundManager.eventRaised(event);
		roundManager.eventRaised(event);
		
		verify(mockEventManager);
		
	}

}
