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

import com.boardgamebuddy.core.board.AdjacencyManager;
import com.boardgamebuddy.core.board.Board;
import com.boardgamebuddy.core.board.LineManager;
import com.boardgamebuddy.core.board.Space;

/**
 * Board implementation for a square board
 */
public class SquareBoard implements Board {

	private int size;
	private List<Space> spaces;
	private AdjacencyManager adjacencyManager;
	private LineManager lineManager;
	
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
	 * Return size of board
	 */
	public final int getSize() {
		return size;
	}

	/**
	 * Retrieves the space on the board with the given value
	 */
	public final Space getSpaceByValue(final String value) {
		
		if (value == null) {
			throw new IllegalArgumentException("Cannot find null space");
		}
		
		Space returnSpace = null;
		
		for (Space space : spaces) {
			if (value.equals(space.getValue())) {
				returnSpace = space;
				break;
			}
		}
		
		return returnSpace;
	}

	/**
	 * Getting space by index
	 */
	public final Space getSpaceByIndex(final int index) {
		if (index >= 0 && index < spaces.size()) {
			return spaces.get(index);
		} else {
			throw new IllegalArgumentException("Invalid space value " + index);
		}
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
	 * Returns true if this space completes a straight vertical, 
	 * horizontal, or diagonal line across the whole board - to complete
	 * the line the piece that is on the given space must be the same
	 * piece as the other spaces that are in the same column, row, or
	 * diagonal, etc. as this space.
	 */
	public final boolean doesCompleteStraightLine(final Space space) {
		return getLineManager().doesCompleteStraightLine(space);
	}

	/**
	 * Returns the space that is adjacent to the given space in the
	 * given direction or null if no such space exists
	 */
	public final Space getAdjacentSpace(final Space space, 
			final String direction) {
		return getAdjacencyManager().getAdjacentSpace(space, direction);
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

	/**
	 * Setter for adjacencyManager
	 */
	public final void setAdjacencyManager(
			final AdjacencyManager adjacencyManagerIn) {
		this.adjacencyManager = adjacencyManagerIn;
	}

	/**
	 * Setter for lineManager
	 */
	public final void setLineManager(final LineManager lineManagerIn) {
		this.lineManager = lineManagerIn;
	}

	/**
	 * Get adjacency manager and create one if we do not have one yet
	 */
	public final AdjacencyManager getAdjacencyManager() {

		if (adjacencyManager == null) {
			adjacencyManager = new SquareAdjacencyManager(this);
		}
		
		return adjacencyManager;
	}
	
	/**
	 * Get line manager and create one if we do not have one yet
	 */
	public final LineManager getLineManager() {

		if (lineManager == null) {
			lineManager = new SquareLineManager(this);
		}
		
		return lineManager;
	}
}
