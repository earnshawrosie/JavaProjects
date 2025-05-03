package com.lottoland.rps;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.lottoland.rps.game.GameResult;
import com.lottoland.rps.game.Move;

public class MoveTest {

	@Test
	public void testRockBeatsScissors() throws Exception {
		assertTrue(GameResult.WIN.equals(Move.ROCK.versus(Move.SCISSORS)));
	}
	
	@Test
	public void testRockLosesToPaper() throws Exception {
		assertTrue(GameResult.LOSE.equals(Move.ROCK.versus(Move.PAPER)));
	}
	
	@Test
	public void testRockDraw() throws Exception {
		assertTrue(GameResult.DRAW.equals(Move.ROCK.versus(Move.ROCK)));
	}
	
	@Test
	public void testScissorsBeatsPaper() throws Exception {
		assertTrue(GameResult.WIN.equals(Move.SCISSORS.versus(Move.PAPER)));
	}
	
	@Test
	public void testScissorsLosesToRock() throws Exception {
		assertTrue(GameResult.LOSE.equals(Move.SCISSORS.versus(Move.ROCK)));
	}
	
	@Test
	public void testScissorsDraw() throws Exception {
		assertTrue(GameResult.DRAW.equals(Move.SCISSORS.versus(Move.SCISSORS)));
	}
	
	@Test
	public void testPaperBeatsRock() throws Exception {
		assertTrue(GameResult.WIN.equals(Move.PAPER.versus(Move.ROCK)));
	}
	
	@Test
	public void testPaperLosesToScisors() throws Exception {
		assertTrue(GameResult.LOSE.equals(Move.PAPER.versus(Move.SCISSORS)));
	}
	
	@Test
	public void testPaperDraw() throws Exception {
		assertTrue(GameResult.DRAW.equals(Move.PAPER.versus(Move.PAPER)));
	}
}
