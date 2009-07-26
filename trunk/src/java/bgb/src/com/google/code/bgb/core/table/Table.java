package com.google.code.bgb.core.table;

import com.google.code.bgb.core.game.Game;
import com.google.code.bgb.core.user.User;

public interface Table {

	void addUser(User user);
	Game getGame();
}
