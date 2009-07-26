package com.google.code.bgb.core.turn;

import java.util.Collection;

import com.google.code.bgb.core.player.Player;

public interface TurnManager {

	Player getCurrentPlayer();
	void orderPlayers(Collection<Player> players);
}
