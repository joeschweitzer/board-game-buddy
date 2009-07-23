
class Turn:
    """A single turn in a game

    Attributes:
        player -- Player whose turn it is
        moves -- Moves in this turn
    """
    def __init__(self, player):
        self.player = player
        self.moves = []
    
    def add_move(self, move):
        self.moves.append(move)
    
class TurnHistory:
    """Records a turn that was made

    Attributes:
        turn -- Turn that was made
        time -- Time turn was made
    """
    def __init__(self, turn, time):
        self.turn = turn
        self.time = time