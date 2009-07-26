package com.boardgamebuddy.core.player;

import java.util.Collection;

public interface PlayerManager {

	void addPlayer(Player player);
	Collection<Player> getPlayers();
}
