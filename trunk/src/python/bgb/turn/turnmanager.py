
from datetime import date
from pybgb.move.move import MoveHistory

class TurnManager:
    """Manager for turns in a game

    Attributes:
        game -- Game for this turn manager
        turn_history -- History of turns in this game
        turn_listeners -- Listeners for turns
    """
    
    def __init__(self, game):
        self.game = game
        self.turn_history = []
        self.turn_listeners = []
        self.add_turn_listener(self)
        self.current_turn = None
    
    def add_turn_listener(self, listener):
        self.turn_listeners.append(listener)
        
    def remove_turn_listener(self, listener):
        self.turn_listeners.remove(listener)
            
    def start_turn(self, player):
        if self.current_turn:
            raise InvalidTurnError("Cannot start turn while in a turn")
        
        self.current_player = player
        self.current_turn = Turn()
            
        for listener in self.turn_listeners:
            listener.turn_started(game, self.current_turn)
        
    def end_turn(self):
        if not self.current_turn:
            raise InvalidTurnError("Cannot end turn if not in a turn")
        
        for listener in self.turn_listeners:
            listener.turn_ended(game, self.current_turn)
            
        self.current_player = None
        self.current_turn = None
        
    def turn_started(self):
        pass
    
    def turn_ended(self, turn):
        self.turn_history.append(TurnHistory(turn, date.today()))
        
    def move_made(self, game, move):
        self.current_turn.add_move(move)
        
        