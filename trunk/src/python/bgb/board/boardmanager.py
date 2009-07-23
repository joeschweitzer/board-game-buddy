
class BoardManager:
    def __init__(self):
        self.boards = {}
        
    def add_board(self, board_name, board):
        self.boards[board_name] = board
        if board_name == "main":
            self.board = board