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

import com.boardgamebuddy.core.board.AdjacencyManager;
import com.boardgamebuddy.core.board.Board;
import com.boardgamebuddy.core.board.Space;

/**
 * Adjacency manager for a square
 */
public class SquareAdjacencyManager implements AdjacencyManager {

	private Board board;
	
	/**
	 * Constructor for board
	 */
	public SquareAdjacencyManager(final Board boardIn) {
		board = boardIn;
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
	 * Returns the space which is directly north of the given space or null
	 * if the given space is at the top of the board
	 */
	public final Space getAdjacentNorth(final Space space) {
		int index = Integer.parseInt(space.getValue());
		
		int north = index - board.getSize();
		
		if (north < 0) {
			return null;
		} else {
			return board.getSpaceByIndex(north);
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
		
		if (east % board.getSize() == 0) {
			return null;
		} else {
			return board.getSpaceByIndex(east);
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
		
		int south = index + board.getSize();
		
		if (south > (board.getSize() * board.getSize()) - 1) {
			return null;
		} else {
			return board.getSpaceByIndex(south);
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
		
		if (index % board.getSize() == 0) {
			return null;
		} else {
			return board.getSpaceByIndex(west);
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
}
