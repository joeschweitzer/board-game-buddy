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
package com.boardgamebuddy.basic.move;

import com.boardgamebuddy.core.board.Piece;
import com.boardgamebuddy.core.board.Space;
import com.boardgamebuddy.core.move.Move;
import com.boardgamebuddy.core.player.Player;

/**
 * Basic move implementation for a single player, space, and piece
 */
public class BasicMove implements Move {

	private Player player;
	private Space space;
	private Piece piece;

	/**
	 * Constructor for player moving/placing piece to space
	 */
	public BasicMove(final Player playerIn, final Space spaceIn, 
			final Piece pieceIn) {
		this.player = playerIn;
		this.space = spaceIn;
		this.piece = pieceIn;
	}
	
	/**
	 * Retrieves the piece for this move
	 */
	public final Piece getPiece() {
		return piece;
	}

	/**
	 * Retrieves the player for this move
	 */
	public final Player getPlayer() {
		return player;
	}

	/**
	 * Retrieves the space for this move
	 */
	public final Space getSpace() {
		return space;
	}
}
