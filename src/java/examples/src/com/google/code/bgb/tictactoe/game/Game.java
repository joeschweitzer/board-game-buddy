package com.google.code.bgb.tictactoe.game;

import java.util.ArrayList;
import java.util.Collection;

import com.google.code.bgb.core.board.BoardManager;
import com.google.code.bgb.core.event.EventListener;
import com.google.code.bgb.core.move.MoveManager;
import com.google.code.bgb.core.round.RoundManager;
import com.google.code.bgb.core.turn.TurnManager;
import com.google.code.bgb.tictactoe.player.PlayerManager;

public class Game {

	private BoardManager boardManager;
	private MoveManager moveManager;
	private TurnManager turnManager;
	private RoundManager roundManager;
	private PlayerManager playerManager;
	private Collection<EventListener> eventListeners;
	
	private String name;
	private String status;
	
	public Game(String name) {
		this.name = name;
		this.status = "WAITING FOR PLAYERS";
		eventListeners = new ArrayList<EventListener>();
	}
	
	public void addGameListener(EventListener listener) {
		eventListeners.add(listener);
	}
	
	public void removeGameListener(EventListener listener) {
		eventListeners.remove(listener);
	}
	
	public void start() {
		this.status = "RUNNING";
	}
	
	public void end() {
		this.status = "ENDED";
	}
}
