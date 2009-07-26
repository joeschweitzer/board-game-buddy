package com.google.code.bgb.tictactoe.user;

import com.google.code.bgb.core.user.User;

public class TicTacToeUser implements User {

	private String userName;
	
	public TicTacToeUser(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}
}
