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

import com.boardgamebuddy.core.board.Board;

/**
 * Test helper for square boards
 */
public final class SquareBoardHelper {

	public static final int BOARD_SIZE = 3;
	
	public static final int TOP_LEFT = 0;
	public static final int TOP = 1;
	public static final int TOP_RIGHT = 2;
	public static final int LEFT = 3;
	public static final int CENTER = 4;
	public static final int RIGHT = 5;
	public static final int BOTTOM_LEFT = 6;
	public static final int BOTTOM = 7;
	public static final int BOTTOM_RIGHT = 8;

	/**
	 * Private constructor
	 */
	private SquareBoardHelper() {
		
	}
	
	/**
	 * Returns a 3x3 board full of pieces
	 */
	public static SquareBoard getFullBoard() {

		SquareBoard fullBoard = new SquareBoard(BOARD_SIZE);
		
		for (int ctr = 0; ctr < (BOARD_SIZE * BOARD_SIZE); ctr++) {
			fullBoard.getSpaceByIndex(ctr).setPiece(
					new BasicPieceHelper(String.valueOf(ctr), null));
		}
		
		return fullBoard;
	}

	/**
	 * Returns a 3x3 board with no pieces
	 */
	public static SquareBoard getEmptyBoard() {

		SquareBoard emptyBoard = new SquareBoard(BOARD_SIZE);
		
		return emptyBoard;
	}
	
	/**
	 * Sets a piece on the board
	 */
	public static void setPiece(final Board board, final int index, 
			final String value) {
		board.getSpaceByIndex(index).setPiece(
				new BasicPieceHelper(value, null));
	}
}
