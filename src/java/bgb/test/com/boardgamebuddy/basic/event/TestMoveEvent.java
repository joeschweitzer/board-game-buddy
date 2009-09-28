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
package com.boardgamebuddy.basic.event;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.boardgamebuddy.basic.board.BasicPieceHelper;
import com.boardgamebuddy.basic.board.BasicSpace;
import com.boardgamebuddy.basic.move.BasicMove;
import com.boardgamebuddy.basic.player.BasicPlayer;
import com.boardgamebuddy.core.board.Piece;
import com.boardgamebuddy.core.board.Space;
import com.boardgamebuddy.core.move.Move;
import com.boardgamebuddy.core.player.Player;

/**
 * Test for MoveEvent
 */
public class TestMoveEvent {

	/**
	 * Test for basic getters/toString for MoveEvent
	 */
	@Test
	public final void testValues() {
		Player player = new BasicPlayer("player", "theme1");
		Space space = new BasicSpace("space");
		Piece piece = new BasicPieceHelper("piece", player);
		
		Move move = new BasicMove(player, space, piece);
		MoveEvent event = new MoveEvent("blah", move);
		
		assertEquals("blah", event.getEventType());
		assertEquals(move, event.getMove());
		assertEquals("blah " + move.toString(), event.toString());
	}
}
