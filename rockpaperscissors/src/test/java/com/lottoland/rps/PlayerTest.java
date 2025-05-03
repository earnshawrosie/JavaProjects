package com.lottoland.rps;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.lottoland.rps.game.Move;
import com.lottoland.rps.player.FixedPlayer;
import com.lottoland.rps.player.Player;
import com.lottoland.rps.player.RandomPlayer;

public class PlayerTest {

	private Player fixedPlayer;
	private Player randomPlayer;

	@Before
	public void init() {
		fixedPlayer = new FixedPlayer();
		randomPlayer = new RandomPlayer();
	}

	@Test
	public void testFixedPlayerAlwaysPlaysRock() {
		for (int i = 0; i < 100; i++) {
			assertTrue(fixedPlayer.getMove().equals(Move.ROCK));
		}
	}

	@Test
	public void testRandomPlayerPlaysAllMoves() throws Exception {
		int rockPlayed = 0;
		int paperPlayed = 0;
		int scissorsPlayed = 0;

		for (int i = 0; i < 100; i++) {
			Move nextMove = randomPlayer.getMove();

			switch (nextMove) {
			case ROCK:
				rockPlayed++;
				break;
			case PAPER:
				paperPlayed++;
				break;

			case SCISSORS:
				scissorsPlayed++;
				break;
			default:
				throw new Exception("Invalid Move");
			}
		}
	
		assertTrue(rockPlayed < 100 && rockPlayed > 0);
		assertTrue(paperPlayed < 100 && paperPlayed > 0);
		assertTrue(scissorsPlayed < 100 && scissorsPlayed > 0);
	}
}
