package com.boardgamebuddy.tictactoe.player;

import java.util.ArrayList;
import java.util.Collection;

import com.boardgamebuddy.core.player.Player;
import com.boardgamebuddy.core.player.PlayerManager;


public class TicTacToePlayerManager implements PlayerManager {

	private Collection<Player> players;
	
	public TicTacToePlayerManager() {
		players = new ArrayList<Player>();
	}

	public void addPlayer(Player player) {
		if(players.size() >= 2) {
			throw new IllegalStateException("Too many players");
		}
		
		players.add(player);
	}

	public Collection<Player> getPlayers() {
		return players;
	}
}
