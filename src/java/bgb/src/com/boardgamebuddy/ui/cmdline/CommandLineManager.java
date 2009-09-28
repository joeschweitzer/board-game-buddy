/**
 * Board Game Buddy - A board game framework
 * 
 * Copyright (c) 2009, Joe Schweitzer
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 *    1. Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *    2. Redistributions in binary form must reproduce the above
 *       copyright notice, this list of conditions and the following
 *       disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *    3. The name of the author may not be used to endorse or promote
 *       products derived from this software without specific prior
 *       written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER
 * IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN
 * IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.boardgamebuddy.ui.cmdline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.boardgamebuddy.basic.move.BasicMove;
import com.boardgamebuddy.core.board.Piece;
import com.boardgamebuddy.core.board.Space;
import com.boardgamebuddy.core.game.Game;
import com.boardgamebuddy.core.move.Move;
import com.boardgamebuddy.core.player.Player;

/**
 * Manager to handle interaction with a command line
 */
public class CommandLineManager {

	private Game game;
	
	/**
	 * Constructor for game
	 */
	public CommandLineManager(final Game gameIn) {
		super();
		this.game = gameIn;
	}
	
	/**
	 * Starts command line manager
	 */
	public void start() {
		boolean gameOver = false;
		BufferedReader in = null;
		String command = null;
		
		while (!gameOver) {
			try {
				in = new BufferedReader(new InputStreamReader(System.in));
				game.getBoardManager().getMainBoard().printBoard();
				System.out.println();
				System.out.print("bgb> ");
				command = in.readLine();
				String[] commandValues = command.split(" ");
				
				CommandLineMove cmdLineMove = new CommandLineMove(
						commandValues[0], commandValues[1], commandValues[2]);
				
				try {
					makeMove(cmdLineMove);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if (game.getScoreManager().getWinner() != null) {
					gameOver = true;
					game.getBoardManager().getMainBoard().printBoard();
					System.out.println();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Makes a given move
	 */
	public void makeMove(CommandLineMove cmdLineMove) {
		Move move = getMove(cmdLineMove);
		
		game.getMoveManager().makeMove(move);
	}

	/**
	 * Converts a CommandLineMove into a move
	 */
	private Move getMove(CommandLineMove cmdLineMove) {
		Player player = 
			game.getPlayerManager().getPlayer(cmdLineMove.getPlayer());
		
		if (player == null) {
			throw new IllegalArgumentException(
					"Invalid player: " + cmdLineMove.getPlayer());
		}
		
		Space space = game.getBoardManager().getMainBoard().getSpaceByValue(
				cmdLineMove.getSpace());
		
		if (space == null) {
			throw new IllegalArgumentException(
					"Invalid space: " + cmdLineMove.getSpace());
		}
		
		Piece piece = game.getPieceManager().getPiece(
				player, cmdLineMove.getPiece());
		
		if (piece == null) {
			throw new IllegalArgumentException(
					"Could not get piece " + cmdLineMove.getPiece());
		}
		
		Move move = new BasicMove(player, space, piece);
		
		return move;
	}
}
