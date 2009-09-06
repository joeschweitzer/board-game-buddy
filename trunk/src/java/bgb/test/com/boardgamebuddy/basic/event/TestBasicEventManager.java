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
package com.boardgamebuddy.basic.event;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.junit.Before;
import org.junit.Test;

import com.boardgamebuddy.basic.event.BasicEvent.BasicEventType;
import com.boardgamebuddy.core.event.Event;
import com.boardgamebuddy.core.event.EventListener;

/**
 * Test for BasicEventManager
 */
public class TestBasicEventManager {

	private BasicEventManager eventManager;
	private EventListener mockEventListener;
	
	/**
	 * Setup
	 */
	@Before
	public final void setUp() throws Exception {
		eventManager = new BasicEventManager();
		mockEventListener = createMock(EventListener.class);
	}

	/**
	 * Test for registering listener for an event and raising a event
	 * that doesn't match
	 */
	@Test
	public final void testEventNoMatch() {
		Event event = new BasicEvent(BasicEventType.MOVE_COMPLETE);
		
		eventManager.registerListener("blah", mockEventListener);
		
		replay(mockEventListener);
		eventManager.raiseEvent(event);
		verify(mockEventListener);
	}

	/**
	 * Test for registering listener for an event and raising a event
	 * that does match
	 */
	@Test
	public final void testEventMatch() {
		Event event = new BasicEvent(BasicEventType.MOVE_COMPLETE);
		
		eventManager.registerListener(
				BasicEventType.MOVE_COMPLETE.toString(), mockEventListener);
		
		eventManager.registerListener(
				BasicEventType.MOVE_COMPLETE.toString(), mockEventListener);
		
		mockEventListener.eventRaised(event);
		mockEventListener.eventRaised(event);
		
		replay(mockEventListener);
		eventManager.raiseEvent(event);
		verify(mockEventListener);
	}

}
