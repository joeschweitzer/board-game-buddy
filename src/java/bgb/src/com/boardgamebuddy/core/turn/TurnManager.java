package com.boardgamebuddy.core.turn;

import java.util.Collection;

import com.boardgamebuddy.core.player.Player;

public interface TurnManager {

	Player getCurrentPlayer();
	void orderPlayers(Collection<Player> players);
}
