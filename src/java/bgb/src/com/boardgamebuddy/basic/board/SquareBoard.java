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

import java.util.ArrayList;
import java.util.List;

import com.boardgamebuddy.core.board.Board;
import com.boardgamebuddy.core.board.Space;

/**
 * Board implementation for a square board
 */
public class SquareBoard implements Board {

	private int size;
	private List<Space> spaces;
	
	/**
	 * Constructor with size parameter (same size for width and height)
	 * 
	 * @param sizeIn Number of spaces for width (or height)
	 */
	public SquareBoard(final int sizeIn) {
		this.size = sizeIn;
		spaces = new ArrayList<Space>();
		
		for (int index = 0; index < (size * size); index++) {
			spaces.add(new BasicSpace(String.valueOf(index)));
		}
	}

	/**
	 * Retrieves the space on the board with the given value
	 */
	public final Space getSpace(final String value) {
		int index = Integer.parseInt(value);
		
		if (index >= 0 && index < spaces.size()) {
			return spaces.get(index);
		} else {
			throw new IllegalArgumentException("Invalid space value " + value);
		}
	}
	
	/**
	 * Returns the space which is directly north of the given space or null
	 * if the given space is at the top of the board
	 */
	public final Space getAdjacentNorth(final Space space) {
		int index = Integer.parseInt(space.getValue());
		
		int north = index - size;
		
		if (north < 0) {
			return null;
		} else {
			return spaces.get(north);
		}
	}

	/**
	 * Returns the space which is directly northeast of the given space or null
	 * if the given space is at the top or right side of the board
	 */
	public final Space getAdjacentNorthEast(final Space space) {
		Space northEast = null;
		Space north = getAdjacentNorth(space);
		
		if (north != null) {
			northEast = getAdjacentEast(north);
		}
		
		return northEast;
	}
	
	/**
	 * Returns the space which is directly east of the given space or null
	 * if the given space is at the right side of the board
	 */
	public final Space getAdjacentEast(final Space space) {
		int index = Integer.parseInt(space.getValue());
		
		int east = index + 1;
		
		if (east % size == 0) {
			return null;
		} else {
			return spaces.get(east);
		}
	}
	
	/**
	 * Returns the space which is directly southeast of the given space or null
	 * if the given space is at the bottom or right side of the board
	 */
	public final Space getAdjacentSouthEast(final Space space) {
		Space southEast = null;
		Space south = getAdjacentSouth(space);
		
		if (south != null) {
			southEast = getAdjacentEast(south);
		}
		
		return southEast;
	}
	
	/**
	 * Returns the space which is directly south of the given space or null
	 * if the given space is at the bottom of the board
	 */
	public final Space getAdjacentSouth(final Space space) {
		int index = Integer.parseInt(space.getValue());
		
		int south = index + size;
		
		if (south > ((spaces.size())) - 1) {
			return null;
		} else {
			return spaces.get(south);
		}
	}

	/**
	 * Returns the space which is directly southwest of the given space or null
	 * if the given space is at the bottom or left side of the board
	 */
	public final Space getAdjacentSouthWest(final Space space) {
		Space southWest = null;
		Space south = getAdjacentSouth(space);
		
		if (south != null) {
			southWest = getAdjacentWest(south);
		}
		
		return southWest;
	}

	/**
	 * Returns the space which is directly west of the given space or null
	 * if the given space is at the left side of the board
	 */
	public final Space getAdjacentWest(final Space space) {
		int index = Integer.parseInt(space.getValue());
		
		int west = index - 1;
		
		if (index % size == 0) {
			return null;
		} else {
			return spaces.get(west);
		}
	}

	/**
	 * Returns the space which is directly northwest of the given space or null
	 * if the given space is at the top or left side of the board
	 */
	public final Space getAdjacentNorthWest(final Space space) {
		Space northWest = null;
		Space north = getAdjacentNorth(space);
		
		if (north != null) {
			northWest = getAdjacentWest(north);
		}
		
		return northWest;
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
			currSpace = getAdjacentSpace(currSpace, direction);
		}
		
		return true;
	}
	
	/**
	 * Returns the space that is adjacent to the given space in the
	 * given direction or null if no such space exists
	 */
	public final Space getAdjacentSpace(
			final Space space, final String direction) {
		if (space == null) {
			return null;
		}
		
		if ("NORTH".equals(direction)) {
			return getAdjacentNorth(space);
		} else if ("SOUTH".equals(direction)) {
			return getAdjacentSouth(space);
		} else if ("EAST".equals(direction)) {
			return getAdjacentEast(space);
		} else if ("WEST".equals(direction)) {
			return getAdjacentWest(space);
		} else if ("NORTHWEST".equals(direction)) {
			return getAdjacentNorthWest(space);
		} else if ("NORTHEAST".equals(direction)) {
			return getAdjacentNorthEast(space);
		} else if ("SOUTHWEST".equals(direction)) {
			return getAdjacentSouthWest(space);
		} else if ("SOUTHEAST".equals(direction)) {
			return getAdjacentSouthEast(space);
		} else {
			throw new IllegalArgumentException(
					"Unknown direction: " + direction);
		}
	}
	
	/**
	 * Counts the number of adjacent spaces to the given space in the
	 * given direction
	 */
	public final int countAdjacentSpaces(final Space space, 
			final String direction) {
		Space currSpace = getAdjacentSpace(space, direction);
		int adjacentSpaces = 0;
		
		do {
			adjacentSpaces++;
			currSpace = getAdjacentSpace(currSpace, direction);
		} while(currSpace != null);
		
		return adjacentSpaces;
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
		return (countAdjacentSpaces(space, "SOUTHWEST") 
				+ countAdjacentSpaces(space, "NORTHEAST")) == size;
	}
	
	/**
	 * Returns true if this space is on a "down" diagonal
	 */
	public final boolean isOnDownDiagonal(final Space space) {
		return (countAdjacentSpaces(space, "NORTHWEST") 
				+ countAdjacentSpaces(space, "SOUTHEAST")) == size;
	}
	
	/**
	 * Returns true if there are no more empty spaces on the board
	 */
	public final boolean noEmptySpaces() {
		for (Space space : spaces) {
			if (space.getPiece() == null) {
				return false;
			}
		}
		
		return true;
	}

	/**
	 * Prints the board in its current state
	 */
	public final void printBoard() {
		String allSpaces = "";
		
		for (Space space : spaces) {
			int index = Integer.valueOf(space.getValue());
			String value = "";
			
			if (space.getPiece() != null) {
				space.getPiece().getValue();
			}
			
			if (index % size == 0) {
				allSpaces += "\n";
			}
			allSpaces += value + " ";
		}
		System.out.println(allSpaces);
	}
}
