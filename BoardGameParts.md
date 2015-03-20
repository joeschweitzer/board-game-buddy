# Player #

A person actively participating in the game.  Games can have one or more players.  Players have attributes such as a name.

# Board #

A board acts as the "user interface" for playing a board game.  One is normally able to see the current state of the game by looking at the board and players can interact with the board in order to move the game along.

# Space #

A space is a distinct region on the board.  Spaces may be occupied by pieces or may be empty.  Spaces may have different attributes and may be influenced by different rules of the game at different times.

# Piece #

A distinct entity that players use to interact with the board and with other pieces.  Pieces often act as "extensions" of the players themselves - the players move them instead of moving themselves.  Pieces often go on board spaces and may enter play or be removed from play at various times.

# Move #

A single action carried out by a player.  While this is often moving a piece on a board, it can be any deliberate action carried out by a particular player.

# Turn #

A series of zero or more moves that are usually triggered by a single player (the player whose "turn" it is).  These moves may be just between the player and the board or may be between the player and other players.  Usually players complete their turns in a specific order and one player needs to finish their turn before the next player may start their turn.

# Round #

A series of turns that usually involve a chance for each player to have a turn in a particular sequence.  A game is usually made up of many rounds of play.

# Rule #

Constraints on the game in order to give the game structure so it is well defined and understood.  Games usually have many rules.  Although rules often do not change over the course of the game, rules can range from the very general to the very specific and affect all parts of the game.  Rules also dictate when the game is over and who has won the game.

# Event #

Indication that "something has happened" - usually an event is fired and then there are event listeners that listen for certain events and take action when they occur.  For instance, after a move is made it is the next player's turn so the turn manager may want to listen for move events.

# Game #

An all-encompassing entity that tracks the board game at the highest level.  To break down the game into more manageable parts, it is divided into various managers that manage different aspects of the game.  These managers are listed just at a generic level - they may in turn delegate to specific implementations or other submanagers in order to do the actual work.


---


# Player Manager #

Manager for all player related aspects of the game.  Handles allowing players to join or quit.

# Board Manager #

Manager for all board related aspects of the game.  Handles creating the initial board setup, interactions between the players and the board, and displaying the board to the players.

# Move Manager #

Manager for all move related aspects of the game.  Keeps track of all of the moves played.  Knows if a move is valid or not before allowing it to be played.  Knows the allowable moves that can be played.

# Turn Manager #

Manager for all turn related aspects of the game.  Keeps track of all of the turns played.  Knows whose turn it is and the order of turns (including who goes first).  Knows anything special that happens at the beginning and ending of a turn.

# Round Manager #

Manager for all round related aspects of the game.  Keeps track of all of the rounds played.  Knows anything special that happens at the beginning and ending of a round.

# Score Manager #

Manager for all score related aspects of the game.  Keeps track of all of the scores for the players.

# Event Manager #

Manager that other managers raise events to.  Allows event listeners to register for certain events and then notifies those listeners when the events occur.

# User Interface Manager #

Manager that interacts with user.  Interaction may be over a variety of connections/protocols.  Accepts commands from the user and also sends back status and events.  Prompts the user for input when needed.

# Log Manager #

Manager to log events/messages over the course of the game.

# Persistence Manager #

Manager to allow the state of a game to be persisted in some form - either for storage/later retrieval or to be sent to the user for display.

# Game Manager #

Manager for all general game related aspects of the game.  Knows the general state of the game including whether the game is over or not (if someone has won or lost).


---


# Table/Table Manager #

Used to manage users before they enter a game.  The table owner may also be able to set game preferences before the game starts.

# User/User Manager #

Used to manage a user account with a particular gaming service.  Provides some authentication/authorization for users to login and then play/view certain games.