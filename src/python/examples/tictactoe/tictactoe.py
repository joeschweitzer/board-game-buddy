##Tic-tac-toe, also spelled tick tack toe, and
##alternatively called noughts and crosses, hugs and kisses,
##and many other names, is a pencil-and-paper game for two players,
##O and X, who take turns marking the spaces in a 33 grid,
##usually X going first. The player who succeeds in placing
##three respective marks in a horizontal, vertical or diagonal
##row wins the game.

# Set up two players
# Set up game board
# Set up basic turn algorithm
# Set up basic round algorithm
# Valid moves - where empty space
# Game over? - all spaces are filled or someone won
# Victory conditions - 3 in a row
# Set up basic who goes first - random?
# Output/Print out board
# Input for moves index?

from pybgb.player.player import Player
from pybgb.player.playermanager import PlayerManager
from pybgb.board.board import SquareBoard
from pybgb.board.boardmanager import BoardManager
from pybgb.move.movemanager import MoveManager
from pybgb.game.game import Game

player1 = Player("player1")
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




