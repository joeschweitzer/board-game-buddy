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

from pybgb.player.player import *
from pybgb.player.playermanager import *
from pybgb.board.board import *

player1 = Player("player1")
player2 = Player("player2")

player_manager = PlayerManager()
player_manager.add_player(player1)
player_manager.add_player(player2)

print player_manager.players_ready()

board = TicTacToeBoard()



