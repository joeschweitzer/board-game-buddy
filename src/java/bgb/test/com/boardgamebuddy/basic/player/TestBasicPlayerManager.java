package com.boardgamebuddy.basic.player;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test for BasicPlayerManager
 */
public class TestBasicPlayerManager {

	private BasicPlayerManager playerManager;
	private BasicPlayer player;
	
	/**
	 * Setup
	 */
	@Before
	public final void setUp() throws Exception {
		playerManager = new BasicPlayerManager();
		player = new BasicPlayer("player", "theme1");
	}

	/**
	 * Test for adding player
	 */
	@Test
	public final void testAddPlayer() {
		assertEquals(0, playerManager.getPlayers().size());
		playerManager.addPlayer(player);
		assertEquals(1, playerManager.getPlayers().size());
	}

	/**
	 * Test for adding too many players
	 */
	@Test(expected = IllegalStateException.class)
	public final void testAddTooManyPlayer() {
		playerManager.addPlayer(player);
		playerManager.addPlayer(player);
		playerManager.addPlayer(player);
	}
}
