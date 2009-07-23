
class Piece:
    def __init__(self, player, type):
        self.player = player
        self.type = type

class Space:
    def __init__(self, value):
        self.piece = None
        self.value = value

class SquareBoard:
    """Square board (same number of spaces for width and height)

    Attributes:
        size -- Size of game
        spaces -- Spaces on this board
        rows - all of the rows of the board
        columns - all of the columns of the board
        diagonals - all of the diagonals of the board
    """
    def __init__(self, size):
        self.size = size
        self.spaces = []
        
        for space in range(size * size):
            self.spaces.append(Space(space))
            
        self.rows = []
        
        for row in range(self.size):
            row_spaces = self.spaces[row * size:(row * size) + size]
            self.rows.append(row_spaces)
            
        self.columns = []
        
        for column in range(self.size):
            column_spaces = []
            for row in self.rows:
                column_spaces.append(row[column])
            self.columns.append(column_spaces)
            
        self.diagonals = []
        
        for row in range(self.size):
            asc_diagonal_spaces = []
            for element in range(row + 1):
                space = (self.columns[element])[row - element]
                asc_diagonal_spaces.append(space)
            self.diagonals.append(asc_diagonal_spaces)
 
        del self.diagonals[-1]
        
        for row in range(self.size):
            asc_diagonal_spaces = []
            for element in range(self.size - row): 
                space = (self.columns[self.size - element - 1])[row + element]
                asc_diagonal_spaces.append(space)
            self.diagonals.append(asc_diagonal_spaces)
        
        reverse_columns = []
        reverse_columns.extend(self.columns)
        reverse_columns.reverse()
         
        for row in range(self.size):
            asc_diagonal_spaces = []
            for element in range(row + 1):
                space = (reverse_columns[element])[row - element]
                asc_diagonal_spaces.append(space)
            self.diagonals.append(asc_diagonal_spaces)
 
        del self.diagonals[-1]
        
        for row in range(self.size):
            asc_diagonal_spaces = []
            for element in range(self.size - row): 
                space = (reverse_columns[self.size - element - 1])[row + element]
                asc_diagonal_spaces.append(space)
            self.diagonals.append(asc_diagonal_spaces)
 

        
    def print_board(self):
        all_spaces = ""
        for space in self.spaces:
            all_spaces += str(space.value) + " "
        print all_spaces
        
        print ""
        
        for row in self.rows:
            row_print = ""
            for space in row:
                row_print += str(space.value) + " "
            print row_print
        
        print ""
        
        for column in self.columns:
            column_print = ""
            for space in column:
                column_print += str(space.value) + " "
            print column_print
        
        print ""
        
        for diagonal in self.diagonals:
            diagonal_print = ""
            for space in diagonal:
                diagonal_print += str(space.value) + " "
            print diagonal_print
#===============================================================================
#                2,2
#                1,2    2,1
#                0,2    1,1    2,0
#        
#            
#                0, 0
#                0, 1    1, 0
#                0, 2    1, 1     2, 0
#    0 1 2
#    3 4 5
#    6 7 8
#    
#    00 01 02 03
#    04 05 06 07
#    08 09 10 11
#    12 13 14 15
#===============================================================================
