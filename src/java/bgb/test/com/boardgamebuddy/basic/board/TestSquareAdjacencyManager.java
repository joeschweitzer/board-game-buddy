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

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.boardgamebuddy.core.board.Board;
import com.boardgamebuddy.core.board.Space;

/**
 * Test for SquareAdjacencyManager
 */
public class TestSquareAdjacencyManager {

	private static final int BOARD_SIZE = 3;
	
	private Board fullBoard;
	private SquareAdjacencyManager adjacencyManager;
	
	/**
	 * Setup for full board
	 */
	@Before
	public final void setupFullBoard() {
		fullBoard = new SquareBoard(BOARD_SIZE);
		
		for (int ctr = 0; ctr < (BOARD_SIZE * BOARD_SIZE); ctr++) {
			fullBoard.getSpaceByIndex(ctr).setPiece(
					new BasicPieceHelper(String.valueOf(ctr)));
		}
		
		adjacencyManager = new SquareAdjacencyManager(fullBoard);
	}
	
	/**
	 * Test with full board for middle piece
	 */
	@Test
	public final void testGetAdjacentSpaceMiddle() {

		Space middleSpace = fullBoard.getSpaceByIndex(4);

		assertEquals(fullBoard.getSpaceByIndex(0),
				adjacencyManager.getAdjacentSpace(middleSpace, "NORTHWEST"));
		assertEquals(fullBoard.getSpaceByIndex(1),
				adjacencyManager.getAdjacentSpace(middleSpace, "NORTH"));
		assertEquals(fullBoard.getSpaceByIndex(2),
				adjacencyManager.getAdjacentSpace(middleSpace, "NORTHEAST"));
		assertEquals(fullBoard.getSpaceByIndex(3),
				adjacencyManager.getAdjacentSpace(middleSpace, "WEST"));
		assertEquals(fullBoard.getSpaceByIndex(5),
				adjacencyManager.getAdjacentSpace(middleSpace, "EAST"));
		assertEquals(fullBoard.getSpaceByIndex(6),
				adjacencyManager.getAdjacentSpace(middleSpace, "SOUTHWEST"));
		assertEquals(fullBoard.getSpaceByIndex(7),
				adjacencyManager.getAdjacentSpace(middleSpace, "SOUTH"));
		assertEquals(fullBoard.getSpaceByIndex(8),
				adjacencyManager.getAdjacentSpace(middleSpace, "SOUTHEAST"));
	}
	
	/**
	 * Test with full board for corners
	 */
	@Test
	public final void testGetAdjacentSpaceCorners() {

		Space topLeftSpace = fullBoard.getSpaceByIndex(0);
		Space bottomRightSpace = fullBoard.getSpaceByIndex(8);

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
