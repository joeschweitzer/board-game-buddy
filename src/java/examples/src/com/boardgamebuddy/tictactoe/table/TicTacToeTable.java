package com.boardgamebuddy.tictactoe.table;

import java.util.ArrayList;
import java.util.Collection;

import com.boardgamebuddy.core.game.Game;
import com.boardgamebuddy.core.table.Table;
import com.boardgamebuddy.core.user.User;
import com.boardgamebuddy.tictactoe.game.TicTacToeGame;

public class TicTacToeTable implements Table {

	private Collection<User> users = new ArrayList<User>();
	private Game game;
	
	public void addUser(User user) {
		users.add(user);
		
		if(users.size() == 2) {
			game = new TicTacToeGame("Game1");
			game.addPlayers(users);
			game.start();
		}
	}

	public Game getGame() {
		return game;
	}

}
