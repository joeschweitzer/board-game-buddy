
class Piece:
    def __init__(self, type):
        self.type = type

class Space:
    def __init__(self):
        self.piece = None

class TicTacToeBoard:
    def __init__(self):
        self.spaces = []
        for space in range(0, 9):
            self.spaces.append(Space())

