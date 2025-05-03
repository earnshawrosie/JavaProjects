package com.lottoland.rps.runner;

import com.lottoland.rps.game.GameResult;
import com.lottoland.rps.player.FixedPlayer;
import com.lottoland.rps.player.RandomPlayer;

public class GameRunner {
	
	public static void playGame() throws Exception {
		FixedPlayer player1 = new FixedPlayer();
		RandomPlayer player2 = new RandomPlayer();
		
		int drawCount = 0;
		int winCount = 0;
		int loseCount = 0;

		for (int i = 0; i < 100; i++) {
			GameResult result = player1.getMove().versus(player2.getMove());
			if (result.equals(GameResult.DRAW)) {
				drawCount++ ;
			}
			else if (result.equals(GameResult.WIN)) {
				winCount++;
			} else {
				loseCount++;
			}
		}
		
		System.out.println("Games DRAWN : " + drawCount);
		System.out.println("Player 1 WINS : " + winCount);
		System.out.println("Player 2 WINS : " + loseCount);
	}

}
