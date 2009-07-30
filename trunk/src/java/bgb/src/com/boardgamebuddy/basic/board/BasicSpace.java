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

import com.boardgamebuddy.core.board.Piece;
import com.boardgamebuddy.core.board.Space;

/**
 * Basic implementation for a space with a simple string value
 */
public class BasicSpace implements Space {

	private String value;
	private Piece piece;
	
	/**
	 * Constructor for value
	 */
	public BasicSpace(final String valueIn) {
		this.value = valueIn;
	}
	
	/**
	 * Getter for value
	 */
	public final String getValue() {
		return value;
	}

	/**
	 * Setter for value
	 */
	public final void setValue(final String valueIn) {
		this.value = valueIn;
	}

	/**
	 * Getter for piece
	 */
	public final Piece getPiece() {
		return piece;
	}

	/**
	 * Setter for piece
	 */
	public final void setPiece(final Piece pieceIn) {
		this.piece = pieceIn;
	}

	/**
	 * Implementation for equals()
	 */
	@Override 
	public final boolean equals(final Object obj) {
		BasicSpace space = (BasicSpace) obj;
		
		if (space.getValue().equals(value)) {
			return true;
		}
		
		return false;
	}

	/**
	 * Implementation for hashCode()
	 */
	@Override
	public final int hashCode() {
		return value.hashCode();
	}

	/**
	 * String representation
	 */
	@Override
	public final String toString() {
		return "" + value;
	}
}
