package com.boardgamebuddy.core.game;

import java.util.Collection;

import com.boardgamebuddy.core.board.BoardManager;
import com.boardgamebuddy.core.event.EventManager;
import com.boardgamebuddy.core.move.MoveManager;
import com.boardgamebuddy.core.player.PlayerManager;
import com.boardgamebuddy.core.round.RoundManager;
import com.boardgamebuddy.core.score.ScoreManager;
import com.boardgamebuddy.core.turn.TurnManager;
import com.boardgamebuddy.core.user.User;

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
