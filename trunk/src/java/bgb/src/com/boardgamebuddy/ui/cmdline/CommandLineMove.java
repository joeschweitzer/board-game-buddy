package com.boardgamebuddy.ui.cmdline;

/**
 * Move input by command line
 */
public class CommandLineMove {

	private String player;
	private String piece;
	private String space;
	
	/**
	 * Constructor
	 */
	public CommandLineMove(String player, String piece, String space) {
		this.player = player;
		this.piece = piece;
		this.space = space;
	}

	/**
	 * Get player
	 */
	public final String getPlayer() {
		return player;
	}
	
	/**
	 * Set player
	 */
	public final void setPlayer(final String playerIn) {
		this.player = playerIn;
	}
	
	/**
	 * Get piece
	 */
	public final String getPiece() {
		return piece;
	}
	
	/**
	 * Set piece
	 */
	public final void setPiece(final String pieceIn) {
		this.piece = pieceIn;
	}
	
	/**
	 * Get space
	 */
	public final String getSpace() {
		return space;
	}
	
	/**
	 * Set space
	 */
	public final void setSpace(final String spaceIn) {
		this.space = spaceIn;
	}
}
