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

import com.boardgamebuddy.core.board.LineManager;
import com.boardgamebuddy.core.board.Space;

/**
 * Implementation of line manager for a square
 */
public class SquareLineManager implements LineManager {
	
	private SquareBoard board;
	
	/**
	 * Constructor for size and adjacencyManager
	 */
	public SquareLineManager(final SquareBoard boardIn) {
		board = boardIn;
	}
	
	/**
	 * Returns true if this space completes a straight vertical, 
	 * horizontal, or diagonal line across the whole board - to complete
	 * the line the piece that is on the given space must be the same
	 * piece as the other spaces that are in the same column, row, or
	 * diagonal, etc. as this space.
	 */
	public final boolean doesCompleteStraightLine(final Space space) {
		return doesCompleteVerticalLine(space) 
			|| doesCompleteHorizontalLine(space) 
			|| doesCompleteUpDiagonalLine(space) 
			|| doesCompleteDownDiagonalLine(space);
	}
	
	/**
	 * Determines if the given space completes a line in the given 
	 * direction.  To complete a line, the piece that is on the given
	 * space must be the same piece as the other spaces in the given
	 * direction.
	 */
	public final boolean doesCompleteLine(final Space space, 
			final String direction) {
		Space currSpace = space;
		
		while (currSpace != null) {
			if (currSpace.getPiece() == null 
					|| !currSpace.getPiece().equals(space.getPiece())) {
				return false;
			}
			currSpace = board.getAdjacentSpace(currSpace, direction);
		}
		
		return true;
	}
	
	/**
	 * Returns true if the given space completes a vertical line
	 */
	public final boolean doesCompleteVerticalLine(final Space space) {
		return doesCompleteLine(space, "NORTH") 
			&& doesCompleteLine(space, "SOUTH");
	}

	/**
	 * Returns true if the given space completes a horizontal line
	 */
	public final boolean doesCompleteHorizontalLine(final Space space) {
		return doesCompleteLine(space, "WEST") 
			&& doesCompleteLine(space, "EAST");
	}

	/**
	 * Returns true if the given space completes an "up" diagonal
	 * (southwest to northeast)
	 */
	public final boolean doesCompleteUpDiagonalLine(final Space space) {
		return isOnUpDiagonal(space) 
			&& doesCompleteLine(space, "SOUTHWEST") 
			&& doesCompleteLine(space, "NORTHEAST");
	}
	
	/**
	 * Returns true if the given space completes a "down" diagonal
	 * (northwest to southeast)
	 */
	public final boolean doesCompleteDownDiagonalLine(final Space space) {
		return isOnDownDiagonal(space) 
			&& doesCompleteLine(space, "NORTHWEST") 
			&& doesCompleteLine(space, "SOUTHEAST");
	}
	
	/**
	 * Returns true if this space is on an "up" diagonal
	 */
	public final boolean isOnUpDiagonal(final Space space) {
		return (
				countAdjacentSpaces(space, "SOUTHWEST") 
				+ countAdjacentSpaces(space, "NORTHEAST")
				) == board.getSize();
	}
	
	/**
	 * Returns true if this space is on a "down" diagonal
	 */
	public final boolean isOnDownDiagonal(final Space space) {
		return (
				countAdjacentSpaces(space, "NORTHWEST") 
				+ countAdjacentSpaces(space, "SOUTHEAST")
				) == board.getSize();
	}
	
	/**
	 * Counts the number of adjacent spaces to the given space in the
	 * given direction
	 */
	public final int countAdjacentSpaces(final Space space, 
			final String direction) {
		Space currSpace = board.getAdjacentSpace(space, direction);
		int adjacentSpaces = 0;
		
		do {
			adjacentSpaces++;
			currSpace = board.getAdjacentSpace(currSpace, direction);
		} while(currSpace != null);
		
		return adjacentSpaces;
	}
}
