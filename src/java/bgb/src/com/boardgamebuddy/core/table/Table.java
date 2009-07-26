package com.boardgamebuddy.core.table;

import com.boardgamebuddy.core.game.Game;
import com.boardgamebuddy.core.user.User;

public interface Table {

	void addUser(User user);
	Game getGame();
}
