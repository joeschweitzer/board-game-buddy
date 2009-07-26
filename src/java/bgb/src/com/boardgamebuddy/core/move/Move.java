package com.boardgamebuddy.core.move;

import com.boardgamebuddy.core.board.Piece;
import com.boardgamebuddy.core.board.Space;
import com.boardgamebuddy.core.player.Player;

public interface Move {

	Player getPlayer();
	Space getSpace();
	Piece getPiece();
}
