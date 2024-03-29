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
package com.boardgamebuddy.tictactoe.board;

import com.boardgamebuddy.core.board.Piece;
import com.boardgamebuddy.core.player.Player;

/**
 * TicTacToe implementation of Piece
 */
public class TicTacToePiece implements Piece {

	/**
	 * Types of pieces in a TicTacToe game
	 */
	public enum PieceType { X, O };
	
	private Player player;
	private PieceType type;
	
	/**
	 * Constructor for player and piece type
	 */
	public TicTacToePiece(final Player playerIn, final PieceType typeIn) {
		this.player = playerIn;
		this.type = typeIn;
	}

	/**
	 * Returns the value of this piece
	 */
	public final String getValue() {
		return type.toString();
	}

	/**
	 * Returns the string representation of this piece
	 */
	@Override
	public final String toString() {
		if (type == null) {
			return "";
		} else {
			return type.toString();
		}
	}

	/**
	 * hashCode() implementation off of type
	 */
	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result;
		
		if (type != null) {
			result += type.hashCode();
		}
		
		return result;
	}

	/**
	 * equals() implementation off of type
	 */
	@Override
	public final boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		TicTacToePiece other = (TicTacToePiece) obj;
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		return true;
	}

	/**
	 * Returns the player for this piece
	 */
	public final Player getPlayer() {
		return player;
	}
}
