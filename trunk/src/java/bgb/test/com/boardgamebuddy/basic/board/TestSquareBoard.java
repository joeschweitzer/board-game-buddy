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

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.boardgamebuddy.core.board.AdjacencyManager;
import com.boardgamebuddy.core.board.LineManager;
import com.boardgamebuddy.core.board.Space;

/**
 * Test for SquareBoard
 */
public class TestSquareBoard {

	private static final int BOARD_SIZE = 3;
	
	private static final int INVALID_BOARD_SIZE = 10;
	
	private SquareBoard board;
	private AdjacencyManager mockAdjacencyManager;
	private LineManager mockLineManager;
	
	/**
	 * Setup for board
	 */
	@Before
	public final void setupBoard() {
		mockAdjacencyManager = createMock(AdjacencyManager.class);
		mockLineManager = createMock(LineManager.class);
		
		board = new SquareBoard(BOARD_SIZE);
		board.setAdjacencyManager(mockAdjacencyManager);
		board.setLineManager(mockLineManager);
	}
	
	/**
	 * Test that constructor creates board with spaces correctly
	 */
	@Test
	public final void testConstructor() {
		assertEquals(BOARD_SIZE, board.getSize());
	}
	
	/**
	 * Test for getSpaceByValue() for valid and invalid values
	 */
	@Test
	public final void testGetSpaceByValue() {
		assertTrue(board.getSpaceByValue("0") != null);
		assertEquals("0", board.getSpaceByValue("0").getValue());
		
		assertNull(board.getSpaceByValue("10"));
	}
	
	/**
	 * Test for getSpaceByValue() with null 
	 */
	@Test (expected = IllegalArgumentException.class)
	public final void testGetSpaceByValueNull() {
		board.getSpaceByValue(null);
	}
	
	/**
	 * Test for getSpaceByIndex() for valid index
	 */
	@Test
	public final void testGetSpaceByIndex() {
		assertTrue(board.getSpaceByIndex(0) != null);
		assertTrue(board.getSpaceByIndex(
				(BOARD_SIZE * BOARD_SIZE) - 1) != null);
	}
	
	/**
	 * Test for getSpaceByValue() with invalid value (too high)
	 */
	@Test (expected = IllegalArgumentException.class)
	public final void testGetSpaceByIndexTooHigh() {
		board.getSpaceByIndex(INVALID_BOARD_SIZE);
	}
	
	/**
	 * Test for getSpaceByValue() with invalid value (too low)
	 */
	@Test (expected = IllegalArgumentException.class)
	public final void testGetSpaceByIndexTooLow() {
		board.getSpaceByIndex(-1);
	}
	
	/**
	 * Test for no empty spaces
	 */
	@Test
	public final void testNoEmptySpaces() {
		assertFalse(board.noEmptySpaces());
		
		for (int ctr = 0; ctr < (BOARD_SIZE * BOARD_SIZE); ctr++) {
			board.getSpaceByIndex(ctr).setPiece(
					new BasicPieceHelper(String.valueOf(ctr), null));
		}
		
		assertTrue(board.noEmptySpaces());
	}
	
	/**
	 * Test for doesCompleteStraightLine()
	 */
	@Test
	public final void testDoesCompleteStraightLine() {
		Space space = board.getSpaceByIndex(0);
		
		expect(mockLineManager.doesCompleteStraightLine(space)).andReturn(true);
		replay(mockLineManager);
		
		board.doesCompleteStraightLine(space);
		
		verify(mockLineManager);
	}
	
	/**
	 * Test for getAdjacentSpace()
	 */
	@Test
	public final void testGetAdjacentSpace() {
		Space space = board.getSpaceByIndex(0);
		Space adjacentSpace = board.getSpaceByIndex(1);
		
		expect(mockAdjacencyManager.getAdjacentSpace(space, "EAST"))
			.andReturn(adjacentSpace);
		
		replay(mockAdjacencyManager);
		
		board.getAdjacentSpace(space, "EAST");
		
		verify(mockAdjacencyManager);
	}
	
	/**
	 * Test for printBoard()
	 */
	@Test
	public final void testPrintBoard() {
		board.getSpaceByIndex(0).setPiece(new BasicPieceHelper("0", null));
		
		board.printBoard();
	}
	
	/**
	 * Test for manager getters - should never return null
	 */
	@Test
	public final void testGetManagers() {
		SquareBoard blankBoard = new SquareBoard(BOARD_SIZE);
		
		assertTrue(blankBoard.getLineManager() != null);
		assertTrue(blankBoard.getAdjacencyManager() != null);
	}
}
