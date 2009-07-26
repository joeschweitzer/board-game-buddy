package com.google.code.bgb.tictactoe;

import com.google.code.bgb.basic.move.BasicMove;
import com.google.code.bgb.basic.table.BasicTableManager;
import com.google.code.bgb.core.board.Piece;
import com.google.code.bgb.core.board.Space;
import com.google.code.bgb.core.game.Game;
import com.google.code.bgb.core.move.Move;
import com.google.code.bgb.core.player.Player;
import com.google.code.bgb.core.table.Table;
import com.google.code.bgb.core.table.TableManager;
import com.google.code.bgb.core.user.User;
import com.google.code.bgb.tictactoe.board.TicTacToePiece;
import com.google.code.bgb.tictactoe.board.TicTacToePiece.PieceType;
import com.google.code.bgb.tictactoe.table.TicTacToeTable;
import com.google.code.bgb.tictactoe.user.TicTacToeUser;

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
