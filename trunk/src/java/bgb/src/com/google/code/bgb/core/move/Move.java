package com.google.code.bgb.core.move;

import com.google.code.bgb.core.board.Piece;
import com.google.code.bgb.core.board.Space;
import com.google.code.bgb.core.player.Player;

public interface Move {

	Player getPlayer();
	Space getSpace();
	Piece getPiece();
}
