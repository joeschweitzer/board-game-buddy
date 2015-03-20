# User Interface Parts #

  * Get status
    * Board
    * Pieces
    * Players
    * Round/turn
    * Available moves
    * Last move
  * Commands
    * Move
    * End game/resign
    * Quit
    * Chat/message



# Basic Flow #

## Status ##

  * Background polling to see if status has changed
  * If status has changed, update screen (try to keep any commands that were partially entered)
  * Have to know what to poll to see what has changed (board, round/turn, etc.)
  * Perhaps have UIManager as observer so that notifications come as push vs. pull
  * Have to know what information to get back and then how to update the screen appropriately

## Commands ##

  * First word - command type
  * Following words - arguments (if any)
  * Enter (submit)
  * Convert strings to objects (lookup objects using managers - give error if object not found)
  * Make move (give error if move has error)
  * Status should update automatically

## Move Command ##