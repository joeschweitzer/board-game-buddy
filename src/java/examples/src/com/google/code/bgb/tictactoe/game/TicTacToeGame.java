package com.google.code.bgb.tictactoe.game;

import java.util.Collection;

import com.boardgamebuddy.core.board.Board;
import com.boardgamebuddy.core.board.BoardManager;
import com.boardgamebuddy.core.event.Event;
import com.boardgamebuddy.core.event.EventListener;
import com.boardgamebuddy.core.event.EventManager;
import com.boardgamebuddy.core.game.Game;
import com.boardgamebuddy.core.move.MoveManager;
import com.boardgamebuddy.core.player.Player;
import com.boardgamebuddy.core.player.PlayerManager;
import com.boardgamebuddy.core.round.RoundManager;
import com.boardgamebuddy.core.score.ScoreManager;
import com.boardgamebuddy.core.turn.TurnManager;
import com.boardgamebuddy.core.user.User;
import com.google.code.bgb.tictactoe.board.TicTacToeBoard;
import com.google.code.bgb.tictactoe.board.TicTacToeBoardManager;
import com.google.code.bgb.tictactoe.event.TicTacToeEventManager;
import com.google.code.bgb.tictactoe.event.TicTacToeEvent.TicTacToeEventType;
import com.google.code.bgb.tictactoe.move.TicTacToeMoveManager;
import com.google.code.bgb.tictactoe.player.TicTacToePlayer;
import com.google.code.bgb.tictactoe.player.TicTacToePlayerManager;
import com.google.code.bgb.tictactoe.round.TicTacToeRoundManager;
import com.google.code.bgb.tictactoe.score.TicTacToeScoreManager;
import com.google.code.bgb.tictactoe.turn.TicTacToeTurnManager;

public class TicTacToeGame implements Game, EventListener {

	private EventManager eventManager = new TicTacToeEventManager();
	private BoardManager boardManager = new TicTacToeBoardManager();
	private MoveManager moveManager = new TicTacToeMoveManager(this);
	private TurnManager turnManager = new TicTacToeTurnManager(this);
	private RoundManager roundManager = new TicTacToeRoundManager(this);
	private PlayerManager playerManager = new TicTacToePlayerManager();
	private ScoreManager scoreManager = new TicTacToeScoreManager(this);
	
	private String name;
	private String status;
	
	public TicTacToeGame(String name) {
		this.name = name;
		this.status = "WAITING FOR PLAYERS";
		
		Board board = new TicTacToeBoard(3);
		boardManager.addBoard(board);
		
		eventManager.registerListener(
				TicTacToeEventType.GAME_COMPLETE.toString(), this);
	}
	
	public void start() {
		this.status = "RUNNING";
	}
	
	public void end() {
		this.status = "ENDED";
	}

	public void addPlayers(Collection<User> users) {
		for(User user : users) {
			Player player = new TicTacToePlayer(user.getUserName());
			playerManager.addPlayer(player);
		}
	}

	public void eventRaised(Event event) {
		if(TicTacToeEventType.GAME_COMPLETE.equals(
				TicTacToeEventType.valueOf(event.getEventType()))) {
			System.out.println("Game over");
			System.out.println("Winner = " + scoreManager.getWinner());
			end();
		}
	}

	public BoardManager getBoardManager() {
		return boardManager;
	}

	public MoveManager getMoveManager() {
		return moveManager;
	}

	public TurnManager getTurnManager() {
		return turnManager;
	}

	public RoundManager getRoundManager() {
		return roundManager;
	}

	public PlayerManager getPlayerManager() {
		return playerManager;
	}

	public ScoreManager getScoreManager() {
		return scoreManager;
	}

	public EventManager getEventManager() {
		return eventManager;
	}
}
