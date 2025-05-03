package com.lottoland.rps.game;

public enum Move {
	ROCK, PAPER, SCISSORS;

	public GameResult versus(Move otherMove) throws Exception {
		return this == otherMove ? GameResult.DRAW : calculateResult(otherMove);
	}

	private GameResult calculateResult(Move otherMove) throws Exception {
		switch (otherMove) {
		case ROCK: {
			return this == PAPER ? GameResult.WIN : GameResult.LOSE;
		}
		case PAPER: {
			return this == SCISSORS ? GameResult.WIN : GameResult.LOSE;
		}
		case SCISSORS: {
			return this == ROCK ? GameResult.WIN : GameResult.LOSE;
		}
		default:
			throw new Exception("Invalid move");

		}
	}

}
