package com.boardgamebuddy.basic.board;

import java.util.ArrayList;
import java.util.List;

import com.boardgamebuddy.core.board.Board;
import com.boardgamebuddy.core.board.Space;


public class SquareBoard implements Board {

	private int size;
	private List<Space> spaces;
	
	public SquareBoard(int size) {
		this.size = size;
		spaces = new ArrayList<Space>();
		
		init();
	}
	
	public void init() {
		for(int index = 0; index < (size * size); index++) {
			spaces.add(new BasicSpace(String.valueOf(index)));
		}
	}

	public Space getSpace(String value) {
		int index = Integer.parseInt(value);
		
		if(index >= 0 && index < spaces.size()) {
			return spaces.get(index);
		} else {
			throw new IllegalArgumentException("Invalid space value " + value);
		}
	}
	
	public Space getAdjacentNorth(Space space) {
		int index = Integer.parseInt(space.getValue());
		
		int north = index - size;
		
		return north < 0 ? null : spaces.get(north);
	}

	public Space getAdjacentNorthEast(Space space) {
		Space northEast = null;
		Space north = getAdjacentNorth(space);
		
		if(north != null) {
			northEast = getAdjacentEast(north);
		}
		
		return northEast;
	}
	
	public Space getAdjacentEast(Space space) {
		int index = Integer.parseInt(space.getValue());
		
		int east = index + 1;
		
		return east % size == 0 ? null : spaces.get(east);
	}
	
	public Space getAdjacentSouthEast(Space space) {
		Space southEast = null;
		Space south = getAdjacentSouth(space);
		
		if(south != null) {
			southEast = getAdjacentEast(south);
		}
		
		return southEast;
	}
	
	public Space getAdjacentSouth(Space space) {
		int index = Integer.parseInt(space.getValue());
		
		int south = index + size;
		
		return south > ((spaces.size()) - 1) ? null : spaces.get(south);
	}

	public Space getAdjacentSouthWest(Space space) {
		Space southWest = null;
		Space south = getAdjacentSouth(space);
		
		if(south != null) {
			southWest = getAdjacentWest(south);
		}
		
		return southWest;
	}

	public Space getAdjacentWest(Space space) {
		int index = Integer.parseInt(space.getValue());
		
		int west = index - 1;
		
		return index % size == 0 ? null : spaces.get(west);
	}

	public Space getAdjacentNorthWest(Space space) {
		Space northWest = null;
		Space north = getAdjacentNorth(space);
		
		if(north != null) {
			northWest = getAdjacentWest(north);
		}
		
		return northWest;
	}
	
	public boolean doesCompleteStraightLine(Space space) {
		return doesCompleteVerticalLine(space) || 
			doesCompleteHorizontalLine(space) || 
			doesCompleteUpDiagonalLine(space) ||
			doesCompleteDownDiagonalLine(space);
	}
	
	public boolean doesCompleteLine(Space space, String direction) {
		Space currSpace = space;
		
		while(currSpace != null) {
			if(currSpace.getPiece() == null ||
					!currSpace.getPiece().equals(space.getPiece())) {
				return false;
			}
			currSpace = getAdjacentSpace(currSpace, direction);
		}
		
		return true;
	}
	
	public Space getAdjacentSpace(Space space, String direction) {
		if(space == null) {
			return null;
		}
		
		if("NORTH".equals(direction)) {
			return getAdjacentNorth(space);
		} else if("SOUTH".equals(direction)) {
			return getAdjacentSouth(space);
		} else if("EAST".equals(direction)) {
			return getAdjacentEast(space);
		} else if("WEST".equals(direction)) {
			return getAdjacentWest(space);
		} else if("NORTHWEST".equals(direction)) {
			return getAdjacentNorthWest(space);
		} else if("NORTHEAST".equals(direction)) {
			return getAdjacentNorthEast(space);
		} else if("SOUTHWEST".equals(direction)) {
			return getAdjacentSouthWest(space);
		} else if("SOUTHEAST".equals(direction)) {
			return getAdjacentSouthEast(space);
		} else {
			throw new IllegalArgumentException(
					"Unknown direction: " + direction);
		}
	}
	
	public int countAdjacentSpaces(Space space, String direction) {
		Space currSpace = getAdjacentSpace(space, direction);
		int adjacentSpaces = 0;
		
		do {
			adjacentSpaces++;
			currSpace = getAdjacentSpace(currSpace, direction);
		} while(currSpace != null);
		
		return adjacentSpaces;
	}
	
	public boolean doesCompleteVerticalLine(Space space) {
		return doesCompleteLine(space, "NORTH") &&
			doesCompleteLine(space, "SOUTH");
	}

	public boolean doesCompleteHorizontalLine(Space space) {
		return doesCompleteLine(space, "WEST") &&
			doesCompleteLine(space, "EAST");
	}

	public boolean doesCompleteUpDiagonalLine(Space space) {
		return isOnUpDiagonal(space) &&
			doesCompleteLine(space, "SOUTHWEST") &&
			doesCompleteLine(space, "NORTHEAST");
	}
	
	public boolean doesCompleteDownDiagonalLine(Space space) {
		return isOnDownDiagonal(space) &&
			doesCompleteLine(space, "NORTHWEST") &&
			doesCompleteLine(space, "SOUTHEAST");
	}
	
	public boolean isOnUpDiagonal(Space space) {
		return (countAdjacentSpaces(space, "SOUTHWEST") + 
			countAdjacentSpaces(space, "NORTHEAST")) == size;
	}
	
	public boolean isOnDownDiagonal(Space space) {
		return (countAdjacentSpaces(space, "NORTHWEST") + 
			countAdjacentSpaces(space, "SOUTHEAST")) == size;
	}
	
	public boolean noEmptySpaces() {
		for(Space space : spaces) {
			if(space.getPiece() == null) {
				return false;
			}
		}
		
		return true;
	}

	public void printBoard() {
		String allSpaces = "";
		
		for(Space space : spaces) {
			int index = Integer.valueOf(space.getValue());
			String value = space.getPiece() == null ? "" :
				space.getPiece().getValue();
			
			if(index % size == 0) {
				allSpaces += "\n";
			}
			allSpaces += value + " ";
		}
		System.out.println(allSpaces);
	}
}
