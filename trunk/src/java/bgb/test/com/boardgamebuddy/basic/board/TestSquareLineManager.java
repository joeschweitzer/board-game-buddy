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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import com.boardgamebuddy.core.board.Space;

/**
 * Test for SquareLineManager
 */
public class TestSquareLineManager {

	private static final String VALUE = "X";
	private static final String DIFF_VALUE = "blahblah";
	
	private SquareBoard board;
	private SquareLineManager lineManager;
	private Space centerSpace;
	
	/**
	 * Setup for board
	 */
	@Before
	public final void setupBoard() {
		board = SquareBoardHelper.getEmptyBoard();
		
		centerSpace = board.getSpaceByIndex(SquareBoardHelper.CENTER);
		SquareBoardHelper.setPiece(board, SquareBoardHelper.CENTER, VALUE);
		
		lineManager = new SquareLineManager(board);
	}

	/**
	 * Test for whether a vertical line of empty spaces results in completing
	 * a line - should be false
	 */
	@Test
	public final void testDoesCompleteVerticalLineEmptySpaces() {
		assertFalse(lineManager.doesCompleteStraightLine(centerSpace));
	}

	/**
	 * Test for whether a vertical line of non-value spaces results in 
	 * completing a line - should be false
	 */
	@Test
	public final void testDoesCompleteVerticalLineNonValueSpaces() {
		SquareBoardHelper.setPiece(board, SquareBoardHelper.TOP, DIFF_VALUE);
		SquareBoardHelper.setPiece(board, SquareBoardHelper.BOTTOM, DIFF_VALUE);
		assertFalse(lineManager.doesCompleteStraightLine(centerSpace));
	}

	/**
	 * Test for whether a vertical line of value spaces results in 
	 * completing a line - should be true
	 */
	@Test
	public final void testDoesCompleteVerticalLineValueSpaces() {
		SquareBoardHelper.setPiece(board, SquareBoardHelper.TOP, VALUE);
		SquareBoardHelper.setPiece(board, SquareBoardHelper.BOTTOM, VALUE);
		assertTrue(lineManager.doesCompleteStraightLine(centerSpace));
	}

	/**
	 * Test for whether a horizontal line of empty spaces results in completing
	 * a line - should be false
	 */
	@Test
	public final void testDoesCompleteHorizontalLineEmptySpaces() {
		assertFalse(lineManager.doesCompleteStraightLine(centerSpace));
	}

	/**
	 * Test for whether a horizontal line of non-value spaces results in 
	 * completing a line - should be false
	 */
	@Test
	public final void testDoesCompleteHorizontalLineNonValueSpaces() {
		SquareBoardHelper.setPiece(board, SquareBoardHelper.LEFT, DIFF_VALUE);
		SquareBoardHelper.setPiece(board, SquareBoardHelper.RIGHT, DIFF_VALUE);
		assertFalse(lineManager.doesCompleteStraightLine(centerSpace));
	}

	/**
	 * Test for whether a horizontal line of value spaces results in 
	 * completing a line - should be true
	 */
	@Test
	public final void testDoesCompleteHorizontalLineValueSpaces() {
		SquareBoardHelper.setPiece(board, SquareBoardHelper.LEFT, VALUE);
		SquareBoardHelper.setPiece(board, SquareBoardHelper.RIGHT, VALUE);
		assertTrue(lineManager.doesCompleteStraightLine(centerSpace));
	}

	/**
	 * Test for whether an up diagonal line of empty spaces results in 
	 * completing a line - should be false
	 */
	@Test
	public final void testDoesCompleteUpDiagonalLineEmptySpaces() {
		assertFalse(lineManager.doesCompleteStraightLine(centerSpace));
	}

	/**
	 * Test for whether an up diagonal line of non-value spaces results in 
	 * completing a line - should be false
	 */
	@Test
	public final void testDoesCompleteUpDiagonalLineNonValueSpaces() {
		SquareBoardHelper.setPiece(
				board, SquareBoardHelper.BOTTOM_LEFT, DIFF_VALUE);
		SquareBoardHelper.setPiece(
				board, SquareBoardHelper.TOP_RIGHT, DIFF_VALUE);
		assertFalse(lineManager.doesCompleteStraightLine(centerSpace));
	}

	/**
	 * Test for whether an up diagonal line of value spaces results in 
	 * completing a line - should be true
	 */
	@Test
	public final void testDoesCompleteUpDiagonalLineValueSpaces() {
		SquareBoardHelper.setPiece(board, SquareBoardHelper.BOTTOM_LEFT, VALUE);
		SquareBoardHelper.setPiece(board, SquareBoardHelper.TOP_RIGHT, VALUE);
		assertTrue(lineManager.doesCompleteStraightLine(centerSpace));
	}

	/**
	 * Test for whether an down diagonal line of empty spaces results in 
	 * completing a line - should be false
	 */
	@Test
	public final void testDoesCompleteDownDiagonalLineEmptySpaces() {
		assertFalse(lineManager.doesCompleteStraightLine(centerSpace));
	}

	/**
	 * Test for whether an down diagonal line of non-value spaces results in 
	 * completing a line - should be false
	 */
	@Test
	public final void testDoesCompleteDownDiagonalLineNonValueSpaces() {
		SquareBoardHelper.setPiece(
				board, SquareBoardHelper.TOP_LEFT, DIFF_VALUE);
		SquareBoardHelper.setPiece(
				board, SquareBoardHelper.BOTTOM_RIGHT, DIFF_VALUE);
		assertFalse(lineManager.doesCompleteStraightLine(centerSpace));
	}

	/**
	 * Test for whether an down diagonal line of value spaces results in 
	 * completing a line - should be true
	 */
	@Test
	public final void testDoesCompleteDownDiagonalLineValueSpaces() {
		SquareBoardHelper.setPiece(board, SquareBoardHelper.TOP_LEFT, VALUE);
		SquareBoardHelper.setPiece(
				board, SquareBoardHelper.BOTTOM_RIGHT, VALUE);
		assertTrue(lineManager.doesCompleteStraightLine(centerSpace));
	}

	/**
	 * Test for whether a space is on an up diagonal
	 */
	@Test
	public final void testIsOnUpDiagonal() {
		//assertTrue(board.getSpaceByIndex(Square))
	}

}
