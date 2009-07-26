package com.boardgamebuddy.tictactoe.user;

import com.boardgamebuddy.core.user.User;

public class TicTacToeUser implements User {

	private String userName;
	
	public TicTacToeUser(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}
}
