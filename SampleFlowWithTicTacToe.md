# Setup #

  1. (UI) Some way for players to find each other/communicate with each other with desire to play a game
  1. Create players/wait until enough players join
  1. Infrastructure
    1. Create player manager and add players to player manager
    1. Create empty board
    1. Create board manager and add board to board manager as main/only board
    1. Create move manager
    1. Create turn manager
    1. Create round manager
    1. Create score manager
    1. Create game manager
    1. Create whatever connection/listeners that need to be created to facilitate communication between these managers
  1. Ask turn manager who goes first
    1. Turn manager asks first player manager who goes first
      1. (UI) First player manager either figures this out on its own (e.g. random) or receives input from players to determine who goes first

# Game #

  1. Game manager starts game
  1. Round manager starts round 1
  1. Turn manager starts turn 1-1 with player 1 to move
  1. (UI) Move manager waits for a move from player 1
  1. Move manager receives a move from player 1 and validates it
  1. Move manager executes the move from player 1
  1. Turn manager ends turn 1-1
  1. Turn manager starts turn 1-2 with player 2 to move
  1. (UI) Move manager waits for a move from player 2
  1. Move manager receives a move from player 2 and validates it
  1. Move manager executes the move from player 2
  1. Turn manager ends turn 1-2
  1. Round manager ends round 1
  1. Round manager starts round 2
  1. Turn manager starts turn 2-1 with player 1 to move
  1. Turn manager/round manager continue
  1. After each move, score manager is consulted
  1. Score manager calculates whether or not game has been won/lost/tie and if won/lost who the winner is
  1. Once score manager determines this, the game is over

# Tic Tac Toe Command Line Sample #

  1. User A sees an empty "table" and joins
  1. User B sees the table with one spot left and joins
  1. Infrastructure created
    1. Empty tic tac toe board with 9 spaces (3x3)
  1. Turn manager randomly picks User A as Player 1 (X) and User B and Player 2 (O)
  1. Game/round 1/turn 1-1 starts with player 1 to move
  1. Player 1 inputs their move as placing an X on an empty space
  1. Move validated, score manager consulted, turn ends, game continues with turn 1-2 and player 2 to move
  1. Player 2 inputs their move as placing an O on an empty space
  1. Move validated, score manager consulted, turn ends, round ends
  1. Round 2/turn 2-1 starts with player 1 to move
  1. ...
  1. Player enters a move that either wins the game or fills up all 9 spaces with no winner (i.e. a tie)
  1. Game ends

# Actual Code #

  1. tm = new TableManager();
  1. tm.listen()
  1. userA = new User()
  1. userA.login()
  1. table = tm.createNewTable(userA)
  1. userB = new User()
  1. userB.login()
  1. tm.addPlayer(userB, table)
  1. game = new TicTacToeGame()
  1. game.setStatus("Initializing")
  1. game.init()
    1. boardManager = new TicTacToeBoardManager()
    1. board = boardManager.createNewBoard()
    1. board.init()
    1. boardManager.addBoard(board)
    1. boardManager.init()
    1. pieceManager = new TicTacToePieceManager()
    1. pieceManager.init()
    1. moveManager = new TicTacToeMoveManager()
    1. moveManager.init()
    1. turnManager = new TicTacToeTurnManager()
    1. turnManager.init()
    1. roundManager = new TicTacToeRoundManager()
    1. roundManager.init()
    1. playerManager = new TicTacToePlayerManager()
    1. player1 = new Player(userA)
    1. player1.init()
    1. player2 = new Player(userB)
    1. player2.init()
    1. playerManager.addPlayer(player1)
    1. playerManager.addPlayer(player2)
    1. playerManager.init()
    1. scoreManager = new TicTacToeScoreManager()
    1. scoreManager.init()
  1. game.setStatus("Determining player order")
  1. firstPlayer = turnManager.getFirstPlayer()
  1. secondPlayer = turnManager.getSecondPlayer()
  1. pieceManager.assignPieces("X", firstPlayer)
  1. pieceManager.assignPieces("O", secondPlayer)
  1. round1 = roundManager.createNewRound()
  1. turn1\_1 = turnManager.createNewTurn()
  1. round1.setCurrentTurn(turn1\_1)
  1. turn1\_1.setCurrentPlayer(firstPlayer)
  1. game.setStatus("In progress")
  1. move = new TicTacToeMove()
  1. pieceX = playerManager.getPiece(firstPlayer)
  1. space = boardManager.getSpace(CENTER)
  1. move.setPlayer(firstPlayer)
  1. move.setPiece(pieceX)
  1. move.setSpace(space)
  1. moveManager.validateMove(move)
  1. moveManager.makeMove(move)
    1. boardManager.movePiece(pieceX, space)
    1. scoreManager.isGameOver()
  1. turn1\_2 = turnManager.createNewTurn()
  1. round1.setCurrentTurn(turn1\_2)
  1. turn1\_2.setCurrentPlayer(secondPlayer)
  1. move = new TicTacToeMove()
  1. pieceO = playerManager.getPiece(secondPlayer)
  1. space = boardManager.getSpace(UPPER\_LEFT)
  1. move.setPlayer(secondPlayer)
  1. move.setPiece(pieceO)
  1. move.setSpace(space)
  1. moveManager.validateMove(move)
  1. moveManager.makeMove(move)
    1. boardManager.movePiece(pieceO, space)
    1. scoreManager.isGameOver()
  1. .....
  1. game.setStatus("Game over")


Event manager to listen for events and then route notifications to the proper places at the proper time - wait to hear back for acknowledgement from everyone to make sure event is ok?

  1. Managers have events that they fire (and know when they should fire them)
  1. Managers have event handlers that are called when certain events are fired (and know how they should handle them)
  1. Event manager configured with events it should care about and which managers should be notified (and   # potentially what order they should be notified if that matters)
  1. Something happens in manager and event is fired
  1. Event manager is notified with event
  1. Event manager looks up to see if it should notify anyone about the event (and who should be notified - and perhaps in what order)
  1. Event manager notifies first manager that event occurred
  1. Manager processes event and perhaps fires an event of its own
  1. Event manager has to figure out which event takes priority if more than one event is being fired
  1. Eventually, events get resolved and everyone is waiting again


Events:






