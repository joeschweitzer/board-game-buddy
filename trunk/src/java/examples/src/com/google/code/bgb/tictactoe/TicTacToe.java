package com.google.code.bgb.tictactoe;

import com.google.code.bgb.tictactoe.board.SquareBoard;
import com.google.code.bgb.tictactoe.player.Player;

public class TicTacToe {
	
	public static void main(String[] args) {
		Player player1 = new Player("player1");
		Player player2 = new Player("player2");
		
		SquareBoard board = new SquareBoard(8);
		
		board.printBoard();
	}
/**
 * player1 = Player("player1")
player2 = Player("player2")

game = Game("tictactoe")

player_manager = PlayerManager()

game.set_player_manager(player_manager)

game.player_manager.add_player(player1)
game.player_manager.add_player(player2)

board_manager = BoardManager()
board = SquareBoard(3)
board_manager.add_board("main", board)
game.set_board_manager(board_manager)

move_manager = MoveManager(game)
game.set_move_manager(move_manager)

game.start()

board.print_board()
 */
}
