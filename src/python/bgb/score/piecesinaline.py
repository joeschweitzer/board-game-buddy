

class PiecesInALine:
    """Manager for scores in a game

    Attributes:
        game -- Game for this score manager
        winner -- Winner of game
    """
    
    def does_move_win(self, move):
        board = game.board_manager.board
        
        