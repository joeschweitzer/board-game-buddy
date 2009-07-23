package com.google.code.bgb.tictactoe.player;

import java.util.ArrayList;
import java.util.Collection;


public class PlayerManager {

	private Collection<Player> players;
	
	public PlayerManager() {
		players = new ArrayList<Player>();
	}
	
	public void addPlayer(Player player) {
		if(players.size() >= 2) {
			throw new IllegalStateException("Too many players");
		}
		
		players.add(player);
	}
	
	public boolean playersReady() {
		return (players.size() == 2);
	}
}
