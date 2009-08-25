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
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.boardgamebuddy.core.board.Space;

/**
 * Test for SquareAdjacencyManager
 */
public class TestSquareAdjacencyManager {

	private SquareAdjacencyManager adjacencyManager;
	private SquareBoard fullBoard;
	
	/**
	 * Setup for full board
	 */
	@Before
	public final void setupFullBoard() {
		fullBoard = SquareBoardHelper.getFullBoard();
		
		adjacencyManager = new SquareAdjacencyManager(fullBoard);
	}
	
	/**
	 * Test with full board for middle piece
	 */
	@Test
	public final void testGetAdjacentSpaceMiddle() {

		Space middleSpace = fullBoard.getSpaceByIndex(SquareBoardHelper.CENTER);

		assertEquals(fullBoard.getSpaceByIndex(SquareBoardHelper.TOP_LEFT),
				adjacencyManager.getAdjacentSpace(middleSpace, "NORTHWEST"));
		assertEquals(fullBoard.getSpaceByIndex(SquareBoardHelper.TOP),
				adjacencyManager.getAdjacentSpace(middleSpace, "NORTH"));
		assertEquals(fullBoard.getSpaceByIndex(SquareBoardHelper.TOP_RIGHT),
				adjacencyManager.getAdjacentSpace(middleSpace, "NORTHEAST"));
		assertEquals(fullBoard.getSpaceByIndex(SquareBoardHelper.LEFT),
				adjacencyManager.getAdjacentSpace(middleSpace, "WEST"));
		assertEquals(fullBoard.getSpaceByIndex(SquareBoardHelper.RIGHT),
				adjacencyManager.getAdjacentSpace(middleSpace, "EAST"));
		assertEquals(fullBoard.getSpaceByIndex(SquareBoardHelper.BOTTOM_LEFT),
				adjacencyManager.getAdjacentSpace(middleSpace, "SOUTHWEST"));
		assertEquals(fullBoard.getSpaceByIndex(SquareBoardHelper.BOTTOM),
				adjacencyManager.getAdjacentSpace(middleSpace, "SOUTH"));
		assertEquals(fullBoard.getSpaceByIndex(SquareBoardHelper.BOTTOM_RIGHT),
				adjacencyManager.getAdjacentSpace(middleSpace, "SOUTHEAST"));
	}
	
	/**
	 * Test with full board for corners
	 */
	@Test
	public final void testGetAdjacentSpaceCorners() {

		Space topLeftSpace = fullBoard.getSpaceByIndex(0);
		Space bottomRightSpace = 
			fullBoard.getSpaceByIndex(SquareBoardHelper.BOTTOM_RIGHT);

		assertNull(adjacencyManager.getAdjacentSpace(
				topLeftSpace, "NORTHWEST"));
		assertNull(adjacencyManager.getAdjacentSpace(
				topLeftSpace, "NORTH"));
		assertNull(adjacencyManager.getAdjacentSpace(
				topLeftSpace, "NORTHEAST"));
		assertNull(adjacencyManager.getAdjacentSpace(
				topLeftSpace, "WEST"));
		assertNull(adjacencyManager.getAdjacentSpace(
				bottomRightSpace, "EAST"));
		assertNull(adjacencyManager.getAdjacentSpace(
				bottomRightSpace, "SOUTHWEST"));
		assertNull(adjacencyManager.getAdjacentSpace(
				bottomRightSpace, "SOUTH"));
		assertNull(adjacencyManager.getAdjacentSpace(
				bottomRightSpace, "SOUTHEAST"));
	}
	
	/**
	 * Test with null space
	 */
	@Test
	public final void testGetAdjacentSpaceNullSpace() {
		assertNull(adjacencyManager.getAdjacentSpace(null, "NORTHWEST"));
	}
	
	/**
	 * Test with invalid direction specified
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testGetAdjacentSpaceInvalidDirection() {
		Space topLeftSpace = fullBoard.getSpaceByIndex(0);
		
		adjacencyManager.getAdjacentSpace(topLeftSpace, "BLAH");
	}
}
