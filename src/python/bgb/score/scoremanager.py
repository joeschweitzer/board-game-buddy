
class ScoreManager:
    """Manager for scores in a game

    Attributes:
        game -- Game for this score manager
        winner -- Winner of game
    """
    
    def __init__(self, game):
        self.game = game
        self.winner = None
    
    def move_made(self, move):
        board = game.board_manager.board
        
        
        