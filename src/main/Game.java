package main;


import algorithm.Strategy;
import model.Board;
import model.Player;

public class Game {
	private Player[] players;
	private Board board;
	private Strategy strategy;
	private boolean over;

	public Game(Strategy strategy) {
		this.players = new Player[]{ new Player( "P1", "X" ), new Player( "P2", "O" ) };
		this.board = board.getInstance();
		this.over = false;
		this.strategy = strategy;

	}
	
	public Player[] getPlayers() {
		return players;
	}


	public Board getBoard() {
		return board;
	}

	public boolean isOver(Player p){
		return over = strategy.isEnd(board, p);
	}
	
	
	
	
}
