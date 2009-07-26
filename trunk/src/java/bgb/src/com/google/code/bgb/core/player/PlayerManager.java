package com.google.code.bgb.core.player;

import java.util.Collection;

public interface PlayerManager {

	void addPlayer(Player player);
	Collection<Player> getPlayers();
}
