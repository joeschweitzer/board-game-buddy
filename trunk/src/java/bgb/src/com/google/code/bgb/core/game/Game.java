package com.google.code.bgb.core.game;

import java.util.Collection;

import com.google.code.bgb.core.board.BoardManager;
import com.google.code.bgb.core.event.EventManager;
import com.google.code.bgb.core.move.MoveManager;
import com.google.code.bgb.core.player.PlayerManager;
import com.google.code.bgb.core.round.RoundManager;
import com.google.code.bgb.core.score.ScoreManager;
import com.google.code.bgb.core.turn.TurnManager;
import com.google.code.bgb.core.user.User;

public interface Game {

	void addPlayers(Collection<User> users);
	void start();
	
	BoardManager getBoardManager();
	EventManager getEventManager();
	MoveManager getMoveManager();
	PlayerManager getPlayerManager();
	RoundManager getRoundManager();
	ScoreManager getScoreManager();
	TurnManager getTurnManager();
	
}
