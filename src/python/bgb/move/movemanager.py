
from datetime import date
from pybgb.move.move import MoveHistory

class MoveManager:
    """Manager for moves in a game

    Attributes:
        game -- Game for this move manager
        move_history -- History of moves in this game
        move_listeners -- Listeners for moves
    """
    
    def __init__(self, game):
        self.game = game
        self.move_history = []
        self.move_listeners = []
        self.add_move_listener(self)
        
    def valid_move(self, move):
        if move.player != self.game.turn_manager.current_player:
            raise InvalidMoveError("It is not this player's turn")
        
        if move.piece not in self.game.board_manager.pieces:
            raise InvalidMoveError("This is an invalid piece")
        
        if move.piece.player != move.player:
            raise InvalidMoveError("Player may not move another player's piece")
        
        if move.space not in self.game.board_manager.spaces:
            raise InvalidMoveError("This is an invalid space")
        
        if move.space.piece != None:
            raise InvalidMoveError("Space is already occupied by a piece")
        
        return True
    
    def add_move_listener(self, listener):
        self.move_listeners.append(listener)
        
    def remove_move_listener(self, listener):
        self.move_listeners.remove(listener)
        
    def move(self, move):
        if valid_move(move):
            move.space.piece = move.piece
            
            for listener in self.move_listeners:
                listener.move_made(game, move)
            
    def move_made(self, game, move):
        self.move_history.append(MoveHistory(move, date.today()))
        
        