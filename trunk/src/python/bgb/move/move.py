
class Move:
    """A single move in a game

    Attributes:
        player -- Player making the move
        piece -- Piece being moved
        space -- Space to which piece is being moved
    """
    def __init__(self, player, piece, space):
        self.player = player
        self.piece = piece
        self.space = space
     
class MoveHistory:
    """Records a move that was made

    Attributes:
        move -- Move that was made
        time -- Time move was made
    """
    def __init__(self, move, time):
        self.move = move
        self.time = time

        
class InvalidMoveError(Exception):
    """Error thrown for invalid move

    Attributes:
        value -- Error string
    """
    def __init__(self, value):
        self.value = value
        
    def __str__(self):
        return repr(self.value)