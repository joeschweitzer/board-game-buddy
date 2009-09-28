package com.boardgamebuddy.basic.move;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.boardgamebuddy.basic.board.BasicPieceHelper;
import com.boardgamebuddy.basic.board.BasicSpace;
import com.boardgamebuddy.basic.player.BasicPlayer;
import com.boardgamebuddy.core.board.Piece;
import com.boardgamebuddy.core.board.Space;
import com.boardgamebuddy.core.player.Player;

/**
 * Test for BasicMove
 */
public class TestBasicMove {

	/**
	 * Test for BasicMove
	 */
	@Test
	public final void testBasicMove() {
		Player player = new BasicPlayer("player", "theme1");
		Space space = new BasicSpace("space");
		Piece piece = new BasicPieceHelper("piece", player);
		
		BasicMove basicMove = new BasicMove(player, space, piece);
		assertEquals(piece, basicMove.getPiece());
		assertEquals(player, basicMove.getPlayer());
		assertEquals(space, basicMove.getSpace());
		assertEquals(player.toString() + " " + piece.toString() + " " 
				+ space.toString(), basicMove.toString());
	}
}
