package com.boardgamebuddy.basic.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.boardgamebuddy.basic.event.BasicEvent.BasicEventType;

/**
 * Test for BasicEvent
 */
public class TestBasicEvent {

	/**
	 * Basic event test
	 */
	@Test
	public final void testBasicEvent() {
		BasicEvent moveComplete = new BasicEvent(BasicEventType.MOVE_COMPLETE);
		assertEquals(moveComplete.getEventType(), 
				BasicEventType.MOVE_COMPLETE.toString());
		assertEquals(moveComplete.toString(), 
				BasicEventType.MOVE_COMPLETE.toString());
	}
	
	/**
	 * Test for equals
	 */
	@Test
	public final void testEquals() {
		BasicEvent firstMoveEvent = 
			new BasicEvent(BasicEventType.MOVE_COMPLETE);
		BasicEvent secondMoveEvent = 
			new BasicEvent(BasicEventType.MOVE_COMPLETE);
		BasicEvent turnEvent = new BasicEvent(BasicEventType.TURN_COMPLETE);
		BasicEvent nullEvent = new BasicEvent(null);

		assertEquals(firstMoveEvent, firstMoveEvent);
		assertEquals(firstMoveEvent, secondMoveEvent);
		assertEquals(nullEvent, nullEvent);
		assertFalse(firstMoveEvent.equals(turnEvent));
		assertFalse(nullEvent.equals(firstMoveEvent));
		assertFalse(firstMoveEvent.equals("hello"));
		assertFalse(firstMoveEvent.equals(null));
	}
	
	/**
	 * Test for hashCode
	 */
	@Test
	public final void testHashCode() {
		BasicEvent turnEvent = new BasicEvent(BasicEventType.TURN_COMPLETE);
		BasicEvent nullEvent = new BasicEvent(null);

		assertEquals(turnEvent.hashCode(), turnEvent.hashCode());
		assertFalse(turnEvent.hashCode() == nullEvent.hashCode());
	}

}
