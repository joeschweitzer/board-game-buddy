package com.boardgamebuddy.tictactoe;

import com.boardgamebuddy.basic.move.BasicMove;
import com.boardgamebuddy.basic.table.BasicTableManager;
import com.boardgamebuddy.core.board.Piece;
import com.boardgamebuddy.core.board.Space;
import com.boardgamebuddy.core.game.Game;
import com.boardgamebuddy.core.move.Move;
import com.boardgamebuddy.core.player.Player;
import com.boardgamebuddy.core.table.Table;
import com.boardgamebuddy.core.table.TableManager;
import com.boardgamebuddy.core.user.User;
import com.boardgamebuddy.tictactoe.board.TicTacToePiece;
import com.boardgamebuddy.tictactoe.board.TicTacToePiece.PieceType;
import com.boardgamebuddy.tictactoe.table.TicTacToeTable;
import com.boardgamebuddy.tictactoe.user.TicTacToeUser;

public class TicTacToe {
	
	public static void main(String[] args) {
		TableManager tableManager = new BasicTableManager();
		
		User joe = new TicTacToeUser("Joe");
		User laura = new TicTacToeUser("Laura");
		
		Table table = new TicTacToeTable();
		tableManager.addNewTable(table);
		table.addUser(joe);
		table.addUser(laura);
		
		Game game = table.getGame();
		game.getTurnManager().orderPlayers(
				game.getPlayerManager().getPlayers());
		
		game.getMoveManager().makeMove(getMove(game, 0));
		game.getMoveManager().makeMove(getMove(game, 1));
		game.getMoveManager().makeMove(getMove(game, 2));
		game.getMoveManager().makeMove(getMove(game, 3));
		game.getMoveManager().makeMove(getMove(game, 4));
		game.getMoveManager().makeMove(getMove(game, 5));
		game.getMoveManager().makeMove(getMove(game, 6));
		game.getMoveManager().makeMove(getMove(game, 7));
		game.getMoveManager().makeMove(getMove(game, 8));
		
		game.getBoardManager().getMainBoard().printBoard();
	}
	
	private static Move getMove(Game game, int index) {
		Player player = game.getTurnManager().getCurrentPlayer();
		Piece piece = null;
		if(player.getName().equals("Joe")) {
			piece = new TicTacToePiece(player, PieceType.X);
		} else {
			piece = new TicTacToePiece(player, PieceType.O);
		}
		
		Space space = game.getBoardManager().getMainBoard().getSpace(
				String.valueOf(index));
		
		return new BasicMove(player, space, piece);
	}
}
