/**
 * Board Game Buddy - A board game framework
 * 
 * Copyright (c) 2009, Joe Schweitzer
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 *    1. Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *    2. Redistributions in binary form must reproduce the above
 *       copyright notice, this list of conditions and the following
 *       disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *    3. The name of the author may not be used to endorse or promote
 *       products derived from this software without specific prior
 *       written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER
 * IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN
 * IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.boardgamebuddy.tictactoe.round;

import com.boardgamebuddy.core.event.Event;
import com.boardgamebuddy.core.event.EventListener;
import com.boardgamebuddy.core.event.EventManager;
import com.boardgamebuddy.core.game.Game;
import com.boardgamebuddy.core.round.RoundManager;
import com.boardgamebuddy.tictactoe.event.TicTacToeEvent;
import com.boardgamebuddy.tictactoe.event.TicTacToeEvent.TicTacToeEventType;

public class TicTacToeRoundManager implements RoundManager, EventListener {

	private Game game;
	private EventManager eventManager;
	private int numTurns = 0;
	
	public TicTacToeRoundManager(Game game) {
		this.game = game;
		this.eventManager = this.game.getEventManager();
		
		eventManager.registerListener(
				TicTacToeEventType.TURN_COMPLETE.toString(), this);
	}
	
	public void eventRaised(Event event) {
		if(TicTacToeEventType.TURN_COMPLETE.equals(
				TicTacToeEventType.valueOf(event.getEventType()))) {
			numTurns++;
			System.out.println("Turn complete");
		}
		
		if(numTurns % 2 == 0) {
			eventManager.raiseEvent(
					new TicTacToeEvent(TicTacToeEventType.ROUND_COMPLETE));
			System.out.println("Round complete");
		}
	}
}
