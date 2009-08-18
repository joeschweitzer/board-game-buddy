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
package com.boardgamebuddy.basic.board;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

/**
 * Test case for BasicSpace
 */
public class TestBasicSpace {

	private BasicSpace space;
	private BasicSpace nullSpace;
	private String value;
	
	/**
	 * Set up for test case
	 */
	@Before
	public final void setUp() throws Exception {
		value = "value";
		space = new BasicSpace(value);
		nullSpace = new BasicSpace(null);
	}

	/**
	 * Test for getters and setters
	 */
	@Test
	public final void testSettersGetters() {
		space.setPiece(null);
		assertNull(space.getPiece());
		space.setValue(value);
		assertEquals(value, space.getValue());
	}
	
	/**
	 * Test for hashCode()
	 */
	@Test
	public final void testHashCode() {
		space.setValue(value);
		assertEquals(space.hashCode(), value.hashCode());
	}

	/**
	 * Test for equals() with nulls
	 */
	@Test
	public final void testEqualsNull() {
		BasicSpace anotherSpace = new BasicSpace(null);
		assertEquals(nullSpace, anotherSpace);
	}

	/**
	 * Test for equals() with nulls
	 */
	@Test
	public final void testEqualsOneNull() {
		assertFalse(space.equals(null));
		assertFalse(space.equals(nullSpace));
	}

	/**
	 * Test for equals() with non-nulls
	 */
	@Test
	public final void testEqualsNonNull() {
		BasicSpace anotherSpace = new BasicSpace(value);
		space.setValue(value);
		assertEquals(space, anotherSpace);
	}

	/**
	 * Test for equals() with non-nulls and not being equal
	 */
	@Test
	public final void testEqualsNonNullNotEqual() {
		BasicSpace anotherSpace = new BasicSpace(value + "blah");
		space.setValue(value);
		assertFalse(space.equals(anotherSpace));
	}

	/**
	 * Test for toString() with null
	 */
	@Test
	public final void testToStringNull() {
		assertEquals("null", nullSpace.toString());
	}

	/**
	 * Test for toString() with non-null
	 */
	@Test
	public final void testToStringNonNull() {
		space.setValue(value);
		assertEquals(value, space.toString());
	}
}
