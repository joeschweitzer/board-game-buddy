
class Game:
    """Upper level game class

    Attributes:
        name -- Name of the game
        status -- Current status of game
        game_listeners -- Listeners for game
        
        board_manager -- Board manager for the game
        move_manager - Move manager for the game
        turn_manager - Turn manager for the game
        round_manager - Round manager for the game
        player_manager - Player manager for the game
    """
    
    def __init__(self, name):
        self.name = name
        self.status = "WAITING FOR PLAYERS"
        self.game_listeners = []
        self.add_game_listener(self)
        
    def set_board_manager(self, board_manager):
        self.board_manager = board_manager
        
    def set_move_manager(self, move_manager):
        self.move_manager = move_manager
        
    def set_turn_manager(self, turn_manager):
        self.turn_manager = turn_manager
        
    def set_round_manager(self, round_manager):
        self.round_manager = round_manager
        
    def set_player_manager(self, player_manager):
        self.player_manager = player_manager
    
    def add_game_listener(self, listener):
        self.game_listeners.append(listener)
        
    def remove_game_listener(self, listener):
        self.game_listeners.remove(listener)
        
    def start(self):
        if self.player_manager.players_ready:
            for listener in self.game_listeners:
                listener.game_started(self)
        else:
            raise InvalidStartError("Players not ready yet")
        
    def end(self):
        for listener in self.game_listeners:
            listener.game_ended(self)
            
    def game_started(self, game):
        self.status = "RUNNING"
            
    def game_ended(self, game):
        self.status = "ENDED"
        
        
class InvalidStartError(Exception):
    """Error thrown for invalid start

    Attributes:
        value -- Error string
    """
    def __init__(self, value):
        self.value = value
        
    def __str__(self):
        return repr(self.value)